package com.livro.apresentacao;

import com.negocio.LivroService;
import com.persistencia.GenericDAO;

import Interfaces.IGenericDAO;

public class Main {
	 public static void main(String[] args) {
	        IGenericDAO<Livro> bookDAO = new GenericDAO<>();
	        LivroService livroService = new LivroService(livroDAO);
	        ControladorLivro controladorLivro = new ControladorLivro(livroService);

	        controladorLivro.run();
	    }
}
