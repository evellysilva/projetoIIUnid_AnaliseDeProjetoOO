package br.ifpe.edu.salao.persistencia;

import java.util.List;

public interface GenericDAO<T> {
	void criar(T entity);
    void atualizar(T entity);
    void deletar(T entity);
    T buscar(int id);
    List<T> listarTudo();
}
