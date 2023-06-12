package br.com.donatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.donatti.entities.BtpPessoa;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 11/06/2023 - 22:39:12
 *
 */
@Repository
public interface PessoaRepository extends JpaRepository<BtpPessoa, Long>{

}
