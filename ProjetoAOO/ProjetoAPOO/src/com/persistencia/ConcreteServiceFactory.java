package com.persistencia;

import Interfaces.ILivroDAO;
import Interfaces.ILivroService;
import Interfaces.ServiceFactory;

public class ConcreteServiceFactory implements ServiceFactory{

	@Override
	public ILivroService criarLivroService(ILivroDAO livroDAO) {
        return new LivroService();

	}
}
