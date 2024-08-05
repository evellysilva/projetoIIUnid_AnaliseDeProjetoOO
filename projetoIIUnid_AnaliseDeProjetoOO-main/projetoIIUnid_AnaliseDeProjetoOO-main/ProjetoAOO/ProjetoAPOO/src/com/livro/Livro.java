package com.livro;

import com.livro.classesAbstratas.LivroAbstract;

public class Livro extends LivroAbstract{
	private String tipo;
	private String tema;

	public Livro(int id, String titulo, String autor, String editora, double preco, String tipo, String tema) {
		super(id, titulo, autor, editora, preco);
		this.tipo = tipo;
		this.tema = tema;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "Livro [tipo=" + tipo + ", tema=" + tema + ", getTipo()=" + getTipo() + ", getTema()=" + getTema()
				+ ", getId()=" + getId() + ", getTitulo()=" + getTitulo() + ", getAutor()=" + getAutor()
				+ ", getEditora()=" + getEditora() + ", getPreco()=" + getPreco() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	}

