package com.livro;

public class Livro {
	private int id_ISBN;
    private String titulo;
    private String editora;
    private String autor;	
    
    public Livro(int id_ISBN, String titulo, String editora, String autor) {
        this.id_ISBN = id_ISBN;
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
    }
    


    public int getId_ISBN() {
		return id_ISBN;
	}



	public void setId_ISBN(int id_ISBN) {
		this.id_ISBN = id_ISBN;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getEditora() {
		return editora;
	}



	public void setEditora(String editora) {
		this.editora = editora;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	@Override
    public String toString() {
        return "Livroo [id_ISBN=" + id_ISBN + ", titulo=" + titulo + ", editora=" + editora + ", autor=" + autor + "]";
    }

} 
