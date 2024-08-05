package com.negocio;

public class DAOFactory {
	public static <T> GenericDAO<T> criarDAO(){
        return new GenericDAO<>();
    }
}
