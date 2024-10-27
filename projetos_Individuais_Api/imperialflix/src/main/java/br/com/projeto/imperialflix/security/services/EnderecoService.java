package br.com.projeto.imperialflix.security.services;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

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
    private Util util;

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Criar um novo endereço
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

        Endereco enderecoConvertido = new Endereco();
        enderecoConvertido.setCep(endereco.getCep());
        enderecoConvertido.setLogradouro(endereco.getLogradouro());
        enderecoConvertido.setComplemento(endereco.getComplemento());
        enderecoConvertido.setBairro(endereco.getBairro());
        enderecoConvertido.setLocalidade(endereco.getLocalidade());
        enderecoConvertido.setRegiao(endereco.getRegiao());
        enderecoConvertido.setUf(endereco.getUf());
        enderecoConvertido.setEstado(endereco.getEstado());

        enderecoRepository.save(enderecoConvertido);

        return endereco;
    }

    // Buscar um endereço por ID
    public EnderecoResponseDTO buscarEndereco(Integer id) {
        Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
        if (enderecoOpt.isPresent()) {
            Endereco endereco = enderecoOpt.get();

            EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
            enderecoResponseDTO.setCep(endereco.getCep());
            enderecoResponseDTO.setBairro(endereco.getBairro());
            enderecoResponseDTO.setComplemento(endereco.getComplemento());
            enderecoResponseDTO.setEstado(endereco.getEstado());
            enderecoResponseDTO.setLocalidade(endereco.getLocalidade());
            enderecoResponseDTO.setLogradouro(endereco.getLogradouro());
            enderecoResponseDTO.setRegiao(endereco.getRegiao());
            enderecoResponseDTO.setUf(endereco.getUf());

            return enderecoResponseDTO;
        } else {
            return null; 
        }
    }

    // Atualizar um endereço existente
    public EnderecoResponseDTO updateEndereco(Integer id, EnderecoRequestDTO enderecoDTO) {
        Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
        if (enderecoOpt.isPresent()) {
            Endereco endereco = enderecoOpt.get();

            EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoDTO.getCep());
            endereco.setCep(viaCep.getCep());
            endereco.setLogradouro(viaCep.getLogradouro());
            endereco.setBairro(viaCep.getBairro());
            endereco.setEstado(viaCep.getEstado());
            endereco.setLocalidade(viaCep.getLocalidade());
            endereco.setRegiao(viaCep.getRegiao());
            endereco.setUf(viaCep.getUf());
            endereco.setComplemento(enderecoDTO.getComplemento());

            Endereco enderecoAtualizado = enderecoRepository.save(endereco);

            EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
            enderecoResponseDTO.setCep(enderecoAtualizado.getCep());
            enderecoResponseDTO.setBairro(enderecoAtualizado.getBairro());
            enderecoResponseDTO.setComplemento(enderecoAtualizado.getComplemento());
            enderecoResponseDTO.setEstado(enderecoAtualizado.getEstado());
            enderecoResponseDTO.setLocalidade(enderecoAtualizado.getLocalidade());
            enderecoResponseDTO.setLogradouro(enderecoAtualizado.getLogradouro());
            enderecoResponseDTO.setRegiao(enderecoAtualizado.getRegiao());
            enderecoResponseDTO.setUf(enderecoAtualizado.getUf());

            return enderecoResponseDTO;
        } else {
            return null; 
        }
    }

    // Deletar um endereço por ID
    public void deletarEndereco(Integer id) {
        enderecoRepository.deleteById(id);
    }

    // Listar todos os endereços
    public List<EnderecoResponseDTO> findAll() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoResponseDTO> enderecoResponseList = new ArrayList<>();

        for (Endereco endereco : enderecos) {
            EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
            enderecoResponseDTO.setCep(endereco.getCep());
            enderecoResponseDTO.setBairro(endereco.getBairro());
            enderecoResponseDTO.setComplemento(endereco.getComplemento());
            enderecoResponseDTO.setEstado(endereco.getEstado());
            enderecoResponseDTO.setLocalidade(endereco.getLocalidade());
            enderecoResponseDTO.setLogradouro(endereco.getLogradouro());
            enderecoResponseDTO.setRegiao(endereco.getRegiao());
            enderecoResponseDTO.setUf(endereco.getUf());
            enderecoResponseList.add(enderecoResponseDTO);
        }

        return enderecoResponseList;
    }
}
