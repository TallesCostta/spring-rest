package br.com.donatti.services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.donatti.entities.BtpPessoa;
import br.com.donatti.exceptions.ResourcesNotFoundException;
import br.com.donatti.repository.PessoaRepository;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 11/06/2023 - 22:26:20
 *
 */
@Service
public class PessoaServices implements Serializable {

	private static final long serialVersionUID = -4228038389558649870L;

	private Logger logger = Logger.getLogger(PessoaServices.class.getName());

	@Autowired
	PessoaRepository repository;

	public List<BtpPessoa> findAll() {
		
		logger.info("Buscando todos os registros de pessoas!");
		
		return repository.findAll();
	}

	public BtpPessoa findById(Long id) {

		logger.info("Buscando um registro de pessoa!");

		return repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado para esse Id!"));
	}

	public BtpPessoa criarRegistroPessoa(BtpPessoa pessoa) {
		logger.info("Registro de pessoa criado!");

		return repository.save(pessoa);
	}

	public BtpPessoa atualizarRegistroPessoa(BtpPessoa pessoa) {
		logger.info("Registro de pessoa alterado!");

		var entity = repository.findById(pessoa.getId())
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado para esse Id!"));

		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setSexo(pessoa.getSexo());

		return repository.save(pessoa);
	}
	
	public void excluirRegistroPessoa(Long id) {
		logger.info("Registro de pessoa excluido!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado para esse Id!"));
		
		repository.delete(entity);
	}
}
