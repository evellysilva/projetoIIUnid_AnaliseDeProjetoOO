package com.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Interfaces.IGenericDAO;
import Interfaces.Identificavel;

public class GenericDAO<T> implementsInterfaceGenericDAO<T>{
	private List<T> dataStore = new ArrayList<>();

	@Override
	public void registrar(T object) {
		dataStore.add(object);
	}

	@Override
	public boolean deletar(T object) {
		return dataStore.remove(object);
	}

	@Override
	public List<T> listarTudo() {
		return new ArrayList<>(dataStore);
	}

	@Override
	public T buscar(Predicate<T> filter) {
		return dataStore.stream().filter(filter).findFirst().orElse(null);
	}
}
