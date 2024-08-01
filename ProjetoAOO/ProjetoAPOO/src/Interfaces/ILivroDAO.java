package Interfaces;

import java.util.List;

import com.livro.Livro;

public interface ILivroDAO {
	void addLivro(Livro livro);
    Livro getLivro(int id);
    List<Livro> getTodosLivros();
    void atualizarLivro(Livro livro);
    void deleteLivro(int id);
}
