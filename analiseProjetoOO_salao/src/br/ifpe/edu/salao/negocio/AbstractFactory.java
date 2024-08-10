package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.persistencia.GenericDAO;

public abstract class AbstractFactory {
    public abstract GenericDAO<?> criarDAO();
}
