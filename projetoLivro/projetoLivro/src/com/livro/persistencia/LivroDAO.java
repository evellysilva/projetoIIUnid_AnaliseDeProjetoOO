package com.livro.persistencia;


import java.util.ArrayList;
import java.util.List;
import com.livro.Livro;

public class LivroDAO {
	private static LivroDAO instance;
    private List<Livro> livros;
    
    private LivroDAO() {
        livros = new ArrayList<>();
    }
    
    public static synchronized LivroDAO getInstance() {
        if (instance == null) {
            instance = new LivroDAO();
        }
        return instance;
    }
    
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }
    
    public Livro encontrarLivroPorId_ISBN(int id_ISBN) {
        for (Livro livro : livros) {
            if (livro.getId_ISBN() == id_ISBN) {
                return livro;
            }
        }
        return null;
    }

    public void atualizarLivro(Livro livro) {
        Livro existente = encontrarLivroPorId_ISBN(livro.getId_ISBN());
        if (existente != null) {
            existente.setTitulo(livro.getTitulo());
            existente.setEditora(livro.getEditora());
            existente.setAutor(livro.getAutor());
        }
    }
    
    public void removerLivro(int id_ISBN) {
        Livro livro = encontrarLivroPorId_ISBN(id_ISBN);
        if (livro != null) {
            livros.remove(livro);
        }
    }

}
