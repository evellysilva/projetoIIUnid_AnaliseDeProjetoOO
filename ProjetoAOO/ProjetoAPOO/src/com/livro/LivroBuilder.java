package com.livro;

public class LivroBuilder {
	private int id;
    private String titulo;
    private String autor;
    private String editora;
    private double preco;
    
    public LivroBuilder() {}

    public LivroBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public LivroBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LivroBuilder setEditora(String editora) {
        this.editora = editora;
        return this;
    }

    public LivroBuilder setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public Livro build() {
        return new Livro(id, titulo, autor, editora, preco);
    }
}
