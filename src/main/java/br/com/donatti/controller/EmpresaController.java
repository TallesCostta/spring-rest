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

import br.com.donatti.VO.EmpresaVO;
import br.com.donatti.services.EmpresaServices;

@RestController
@RequestMapping("/empresa")
public class EmpresaController implements Serializable{

	private static final long serialVersionUID = -703672265565404641L;

	@Autowired
	private EmpresaServices service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmpresaVO> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpresaVO finById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpresaVO create(@RequestBody EmpresaVO empresa) {
		return service.criarRegistroEmpresa(empresa);
	}

	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmpresaVO update(@RequestBody EmpresaVO empresa) {
		return service.atualizarRegistroEmpresa(empresa);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.excluirRegistroEmpresa(id);
		
		return ResponseEntity.noContent().build();
	}
}
