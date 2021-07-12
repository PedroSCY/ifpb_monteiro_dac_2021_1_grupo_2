package com.bookstore.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author NPG (nome dado a equipe que esta desenvolvendo esse sistema)
 * Essa classe tem relação N:1 com a classe livro
 *
 */
@Entity
@Table(name = "TB_AUTOR")
public class Autor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long ID;
	
	@Column(name = "NOME")
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name = "TB_LIVRO_AUTOR",
			   joinColumns = @JoinColumn(name = "FK_AUTOR"), 
			   inverseJoinColumns = @JoinColumn(name = "FK_LIVRO"))
	private Set<Livro> livros = new LinkedHashSet<Livro>();
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}

	public Autor(String nome) {
		
		this.nome = nome;
	}
	
	public Autor() {}
	
	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
	@Override
	public String toString() {
		return "Nome Autor: " + nome;
	}
	
	public boolean equals(Autor autor) {
		return autor.getID().equals(ID);
	}
	

}