package com.persistencia;

import Interfaces.DAOFactory;
import Interfaces.ILivroDAO;

public class ConcreteDAOFactory implements DAOFactory {
	@Override
	public ILivroDAO criarLivroDAO() {
        return LivroDAO.getInstance();
	}
}
