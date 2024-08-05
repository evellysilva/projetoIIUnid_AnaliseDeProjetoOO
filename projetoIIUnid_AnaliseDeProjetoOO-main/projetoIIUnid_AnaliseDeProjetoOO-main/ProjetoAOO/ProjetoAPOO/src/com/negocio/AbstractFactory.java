package com.negocio;

public interface AbstractFactory<T> {
	T criar (String tipo);

}
