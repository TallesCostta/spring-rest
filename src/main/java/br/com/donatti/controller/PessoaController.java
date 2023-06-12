package br.com.donatti.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.donatti.entities.BtpPessoa;
import br.com.donatti.services.PessoaServices;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 11/06/2023 - 22:15:19
 *
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 5604315736534441544L;

	@Autowired
	private PessoaServices service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BtpPessoa> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BtpPessoa finById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BtpPessoa create(@RequestBody BtpPessoa pessoa) {
		return service.criarRegistroPessoa(pessoa);
	}

	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BtpPessoa update(@RequestBody BtpPessoa pessoa) {
		return service.atualizarRegistroPessoa(pessoa);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.excluirRegistroPessoa(id);
		
		return ResponseEntity.noContent().build();
	}
}
