package com.negocio;

import java.util.List;

import com.livro.Livro;
import com.livro.LivroBuilder;

import Interfaces.IGenericDAO;

public class LivroService {
private IGenericDAO<Livro> livroDAO;
    
	public LivroService(IGenericDAO<Livro> livroDAO) {
		this.livroDAO = livroDAO;
	}

	public void add(String titulo, String autor, String editora, double preco) {
		Livro newLivro= new LivroBuilder();
			.setTitulo(titulo)
			.setAutor(autor)
			.setEditora(editora)
			.setPreco(preco)
		    .build();
			
    livroDAO.add(newLivro);
	}
	
	public Livro getLivro(int id) {
		return livroDAO.get(id);
	}
	
    public List<Livro> getTodosLivros() {
        return livroDAO.getAll();
    }
	public void updateLivro(int id, String titulo, String autor, String editora, double preco) {
		 Livro livro = livroDAO.get(id);
		 Livro updatedLivro = new LivroBuilder()
	                .setId(id)
	                .setTitulo(titulo)
	                .setAutor(autor)
	                .setEditora(editora)
	                .setPreco(preco)
	                .build();
	            livroDAO.update(updatedLivro);
    }

	public void deleteLivro(int id) {
		livroDAO.delete(id);		
	}
}
