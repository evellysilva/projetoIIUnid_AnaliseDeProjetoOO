package com.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.livro.Livro;

import Interfaces.ILivroDAO;

public class LivroDAO implements ILivroDAO{
	private static LivroDAO instance;
    private List<Livro> livros;
    private int nextId;
    	
    private LivroDAO() {
    	livros= new ArrayList<>();
    	nextId= 1;
    }
    public static synchronized LivroDAO getInstance() {
    	if (instance==null) {
    		instance= new LivroDAO();
    	}
    	return instance;
    }
    
    @Override
    public void addLivro(Livro livro) {
    	livro.setId(nextId++);
    	livros.add(livro);
    }
    
    @Override
    public Livro getLivro(int id) {
        Optional<Livro> livro = livros.stream().filter(b -> b.getId() == id).findFirst();
        return livro.orElse(null); 
    }
    
    @Override
    public List<Livro> getTodosLivros() {
        return new ArrayList<>(livros);
    }
    
    @Override
    public void atualizarLivro(Livro livro) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == livro.getId()) {
                livros.set(i, livro);
                break;
            }
        }
    }

    public void deleteLivro(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }
}
