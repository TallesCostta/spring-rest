package br.com.donatti.services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.donatti.VO.EmpresaVO;
import br.com.donatti.exceptions.ResourcesNotFoundException;
import br.com.donatti.mapper.MDMapper;
import br.com.donatti.repository.EmpresaRepository;

@Service
public class EmpresaServices implements Serializable {

	private static final long serialVersionUID = -8466644928138533512L;

	private Logger log = Logger.getLogger(EmpresaServices.class.getName());

	@Autowired
	EmpresaRepository repository;

	public List<EmpresaVO> findAll() {

		log.info("Buscando todos os registros para empresas");

		return MDMapper.parseListObjects(repository.findAll(), EmpresaVO.class);
	}

	public EmpresaVO findById(Long id) {

		log.info("Buscando todos os registros para empresas");

		var entity = repository.findById(id).orElseThrow(
				() -> new ResourcesNotFoundException("Nenhum registro de empresa encontrado para esse Id!"));

		return MDMapper.parseObject(entity, EmpresaVO.class);
	}

	public EmpresaVO criarRegistroEmpresa(EmpresaVO empresa) {

		log.info("Registro de Empresa criado!");

		var entity = MDMapper.parseObject(empresa, EmpresaVO.class);
		var vo = MDMapper.parseObject(repository.save(entity), EmpresaVO.class);

		return vo;
	}

	public EmpresaVO atualizarRegistroEmpresa(EmpresaVO empresa) {
		log.info("Registro de Empresa alterado!");

		var entity = repository.findById(empresa.getId())
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado para esse Id!"));

		entity.setNomeEmpresa(empresa.getNomeEmpresa());
		entity.setCnpj(empresa.getCnpj());
		entity.setEndereco(empresa.getEndereco());
		entity.setServico(empresa.getServico());
		entity.setTelefone(empresa.getTelefone());
		entity.setDataContrato(empresa.getDataContrato());

		var vo = MDMapper.parseObject(repository.save(entity), EmpresaVO.class);

		return vo;
	}

	public void excluirRegistroEmpresa(Long id) {
		log.info("Registro de Empresa excluido!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundException("Nenhum registro encontrado para esse Id!"));

		repository.delete(entity);
	}

}
