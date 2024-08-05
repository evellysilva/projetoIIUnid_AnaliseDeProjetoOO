package com.persistencia;

import java.util.List;

public interface InterfaceGenericDAO<T> {
	void registrar(T object);
    boolean deletar(T object);
    List<T> listarTudo();
	T buscar(Predicate<T> filter);

}
