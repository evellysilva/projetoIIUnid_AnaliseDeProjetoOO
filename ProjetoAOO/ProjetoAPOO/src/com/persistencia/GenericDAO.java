package com.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Interfaces.IGenericDAO;
import Interfaces.Identificavel;

public class GenericDAO<T extends Identificavel> implements IGenericDAO <T>{
	private List<T> entities;
    private int nextId;
    public GenericDAO() {
        entities = new ArrayList<>();
        nextId = 1;
    }

    @Override
	public T get(int id) {
        Optional<T> entity = entities.stream().filter(e -> e.getId() == id).findFirst();
        return entity.orElse(null);
	}

	@Override
	public List<T> getAll() {
        return new ArrayList<>(entities);
	}


	@Override
	public void add(T entity) {
        entities.add(entity);		
	}

	@Override
	public void update(T entity) {
	    for (int i = 0; i < entities.size(); i++) {
		       if (entities.get(i).getId() == entity.getId()) {
		           entities.set(i, entity);
		           break;
		            }
	    }		
	}
	public void delete(int id) {
        entities.removeIf(entity -> entity.getId() == id);
		
	}
}
