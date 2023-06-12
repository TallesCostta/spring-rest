package br.com.donatti.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 11/06/2023 - 21:45:10
 *
 */
@Entity
@Table(name = "pessoa")
public class BtpPessoa implements Serializable {

	private static final long serialVersionUID = 5310003528765289025L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 80)
	private String nome;

	@Column(name = "sobrenome", nullable = false, length = 60)
	private String sobrenome;

	@Column(name = "endereco", nullable = false, length = 200)
	private String endereco;

	@Column(name = "sexo", nullable = false, length = 1)
	private String sexo;

	public BtpPessoa() {
	}

	public BtpPessoa(Long id, String nome, String sobrenome, String endereco, String sexo) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, id, nome, sexo, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BtpPessoa other = (BtpPessoa) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(sexo, other.sexo)
				&& Objects.equals(sobrenome, other.sobrenome);
	}
	
}
