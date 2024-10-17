package br.com.projeto.imperialflix.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.imperialflix.security.dto.EnderecoRequestDTO;
import br.com.projeto.imperialflix.security.dto.EnderecoResponseDTO;
import br.com.projeto.imperialflix.security.entities.Endereco;
import br.com.projeto.imperialflix.security.repositories.EnderecoRepository;
import br.com.projeto.imperialflix.utils.Util;



@Service
public class EnderecoService {
	@Autowired
	Util util;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
//	public EnderecoResponseDTO consultarEndereco(String cep) {
	//	EnderecoResponseDTO viaCep = util.buscarEndereco(cep);
		
		//EnderecoResponseDTO endereco = new EnderecoResponseDTO();
		//endereco.setCep(viaCep.getCep());
		//endereco.setBairro(viaCep.getBairro());
		//endereco.setComplemento(viaCep.getComplemento());
		//endereco.setEstado(viaCep.getEstado());
		//endereco.setLocalidade(viaCep.getLocalidade());
		//endereco.setLogradouro(viaCep.getLogradouro());
		//endereco.setRegiao(viaCep.getRegiao());
		//endereco.setUf(viaCep.getUf());
		//return endereco;
	//}
	
	public EnderecoResponseDTO consultarEndereco(EnderecoRequestDTO enderecoDTO) {
		EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoDTO.getCep());
		
		EnderecoResponseDTO endereco = new EnderecoResponseDTO();
		endereco.setCep(enderecoDTO.getCep());
		endereco.setBairro(viaCep.getBairro());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setEstado(viaCep.getEstado());
		endereco.setLocalidade(viaCep.getLocalidade());
		endereco.setLogradouro(viaCep.getLogradouro());
		endereco.setRegiao(viaCep.getRegiao());
		endereco.setUf(viaCep.getUf());
		
		Endereco enderecoConvertido = endereco.toEndereco();
		enderecoRepository.save(enderecoConvertido);
		return endereco;
	}
}

