package com.livro.negocio;

import java.util.List;

import com.livro.Livro;
import com.livro.persistencia.LivroDAO;

public class LivroService {
	private LivroDAO livroDAO;
	
	public LivroService() {
		this.livroDAO = LivroDAO.getInstance();
	    }
	
	public void adicionarLivro(Livro livro) {
		livroDAO.adicionarLivro(livro);
	    }
	
	public List<Livro> listarLivros() {
		return livroDAO.listarLivros();
	    }
	
	public Livro encontrarLivrooPorId_ISBN(int id_ISBN) {
	    return livroDAO.encontrarLivroPorId_ISBN(id_ISBN);
	    }
	
	public void atualizarLivro(Livro livro) {
		livroDAO.atualizarLivro(livro);
	    }
	
	public void removerLivro(int id_ISBN) {
		livroDAO.removerLivro(id_ISBN);
	    }
}