package br.com.donatti.VO;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 13/06/2023 - 10:45:28
 *
 * Altera o nome da variavel no JSON serialization*
 *
 */

@Entity
@Table(name = "empresa")
@JsonPropertyOrder({"id","nome_empresa","servico","endereco","cpnj","data_contrato"})
public class EmpresaVO implements Serializable{

	private static final long serialVersionUID = 1619042252823718575L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Define o nome da variavel
	 */
	@JsonProperty("nome_empresa")
	private String nomeEmpresa;
	
	private String cnpj;
	private String endereco;
	private String servico;
	private String telefone;
	
	/**
	 * Ignora a variavel na serializacao
	 *
	 * @JsonIgnore
	 */
	@JsonProperty("data_contrato")
	private String dataContrato;
	
	public EmpresaVO() {
	}

	public EmpresaVO(String nomeEmpresa, String cnpj, String endereco, String servico, String telefone,
			String dataContrato) {
		this.nomeEmpresa = nomeEmpresa;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.servico = servico;
		this.telefone = telefone;
		this.dataContrato = dataContrato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(String dataContrato) {
		this.dataContrato = dataContrato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, dataContrato, endereco, id, nomeEmpresa, servico, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaVO other = (EmpresaVO) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(dataContrato, other.dataContrato)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nomeEmpresa, other.nomeEmpresa) && Objects.equals(servico, other.servico)
				&& Objects.equals(telefone, other.telefone);
	}
}
