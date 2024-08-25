package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.persistencia.GenericDAO;
//Classe abstrata que define o padrão de fábrica para criar objetos DAO
public abstract class AbstractFactory {
    // Método abstrato que deve ser implementado pelas subclasses para criar instâncias de GenericDAO
    public abstract GenericDAO<?> criarDAO();
}
