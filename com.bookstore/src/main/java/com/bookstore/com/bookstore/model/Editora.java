package com.bookstore.com.bookstore.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EDITORA")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EDITORA_FK", nullable = false)
	private Set<Livro> livros = new LinkedHashSet<Livro>();
	
	public Editora() {

	}
	
	public Editora(String nome, String cidade) {
		this.nome = nome;
		this.cidade = cidade;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	
	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
	
	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}

	public boolean equals(Editora editora) {
		return id == editora.getId();
	}
	
	@Override
	public String toString() {
		String dadosEditora = "Dados da Editora " + nome + ": "
				+ "\n	ID: " + id
				+ "\n	Cidade: " + cidade
				+ "\n	Livros: ";
		
		for (Livro livro : livros) {
			dadosEditora += livro.toString();
		}
		
		return dadosEditora;
	}
}