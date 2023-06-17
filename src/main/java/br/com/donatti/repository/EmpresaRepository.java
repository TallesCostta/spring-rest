package br.com.donatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.donatti.VO.EmpresaVO;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 13/06/2023 - 10:50:39
 *
 */
@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaVO, Long>{
}