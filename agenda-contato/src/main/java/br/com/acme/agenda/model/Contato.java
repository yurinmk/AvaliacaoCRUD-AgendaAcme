/**
 * 
 */
package br.com.acme.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.acme.agenda.utils.JPAUtil;

@Entity
@Table(name = "contatos")
@NamedQuery(name = "Contato.buscarPorEmail", query = "SELECT c FROM Contato c WHERE c.email = :email and c.id_usuario = :idUsuario")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long id_usuario;

	@Column(name = "nome_contato")
	private String nome;

	@Column(name = "email_contato")
	private String email;

	@Column(name = "telefone_contato")
	private String telefone;
	
//	@OneToMany
//	private List<Telefone> telefones;

	private boolean ativo;
	
	public Contato() {
	
	}
	
	public Contato(Long id, Long id_usuario, String nome, String email, String telefone, boolean ativo) {
		this.id = id;
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.ativo = ativo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", ativo="
				+ ativo + "]";
	}
	
	

}
