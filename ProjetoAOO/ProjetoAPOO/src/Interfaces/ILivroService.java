package Interfaces;

import java.util.List;

import com.livro.Livro;

public interface ILivroService {
	void addLivro(String titulo, String autor, String editora, double preco);
    Livro getLivro(int id);
    List<Livro> getTodosLivros();
    void atualizarLivro(int id, String titulo, String autor, String editora, double preco);
    void deleteLivro(int id);
}
