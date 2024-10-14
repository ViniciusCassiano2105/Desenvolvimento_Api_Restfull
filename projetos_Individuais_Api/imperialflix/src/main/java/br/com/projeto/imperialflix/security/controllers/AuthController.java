package br.com.projeto.imperialflix.security.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.imperialflix.security.dto.JwtResponseDTO;
import br.com.projeto.imperialflix.security.dto.LoginRequestDTO;
import br.com.projeto.imperialflix.security.dto.MessageResponseDTO;
import br.com.projeto.imperialflix.security.dto.SignupRequestDTO;
import br.com.projeto.imperialflix.security.entities.Role;
import br.com.projeto.imperialflix.security.entities.User;
import br.com.projeto.imperialflix.security.enums.RoleEnum;
import br.com.projeto.imperialflix.security.jwt.JwtUtils;
import br.com.projeto.imperialflix.security.repositories.RoleRepository;
import br.com.projeto.imperialflix.security.repositories.UserRepository;
import br.com.projeto.imperialflix.security.services.UserDetailsImpl;

//permite solicitações de recursos de origens diferentes, mecanimos de segurança que impoe restrições 
//permite que você controle quais origens podem acessar o end point
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager; //pertence ao spring docs e é uma interface que gerencia a autenticação de usuários

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder; //responsável por criptografar a senha, e comparar com uma senha armazenada usando o a sha-1 (algoritimo de dispersão seguro/secure hash) ou maior

	@Autowired
	JwtUtils jwtUtils; //usado para gerar o token

	//faz o login de um usuario cadastrado préviamente no banco de dados
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

		//faz a autenticação
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		//fornece acesso ao contexto de segurança atual, permite recuperar informações
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponseDTO(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	//faz o cadastro de um novo usuário
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Username já utilizado!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
		}

		// Cria a nova conta de usuario
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(modRole);
					
					break;
				default:
					Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
	}
}
