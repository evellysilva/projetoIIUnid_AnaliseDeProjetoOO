package com.livro;

public class LivroBuilder {
	
	public LivroBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
    private String titulo;
    private String autor;
    private String editora;
    private double preco;
    private String tipo;
	private String tema;
	
	public LivroBuilder id(int id) {
		this.id = id;
		return this;
	}
	public LivroBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}
	public LivroBuilder autor(String autor) {
		this.autor = autor;
		return this;
	}
	public LivroBuilder editora(String editora) {
		this.editora = editora;
		return this;
	}
	public LivroBuilder preco(double preco) {
		this.preco = preco;
		return this;
	}
	public LivroBuilder tipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	public LivroBuilder tema(String tema) {
		this.tema = tema;
		return this;
	}
	public Livro build() {
		return new Livro(id, titulo, autor, editora, preco, tipo, tema);
	}
}
