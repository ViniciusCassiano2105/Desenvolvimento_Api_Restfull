package br.com.projeto.imperialflix.security.services;

import java.util.Optional;

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

	public EnderecoResponseDTO buscarEndereco(Integer id) {
//		Endereco endereco = enderecoRepository.findById(id).get();
		Optional <Endereco> endereco = enderecoRepository.findById(id);
		EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
		enderecoResponseDTO.setBairro(endereco.get().getBairro());
		enderecoResponseDTO.setCep(endereco.get().getCep());
		enderecoResponseDTO.setComplemento(endereco.get().getComplemento());
		enderecoResponseDTO.setEstado(endereco.get().getEstado());
		enderecoResponseDTO.setLocalidade(endereco.get().getLocalidade());
		enderecoResponseDTO.setLogradouro(endereco.get().getLogradouro());
		enderecoResponseDTO.setRegiao(endereco.get().getRegiao());
		enderecoResponseDTO.setUf(endereco.get().getUf());
		return enderecoResponseDTO;
	}
	
	public void deletarEndereco (Integer id) {
		enderecoRepository.deleteById(id);
		
	}
}

