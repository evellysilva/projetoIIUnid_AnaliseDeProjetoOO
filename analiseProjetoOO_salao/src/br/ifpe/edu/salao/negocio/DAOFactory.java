package br.ifpe.edu.salao.negocio;

import br.ifpe.edu.salao.Servico;
import br.ifpe.edu.salao.persistencia.GenericDAO;
import br.ifpe.edu.salao.persistencia.ServicoDAO;
import br.ifpe.edu.salao.persistencia.ServicoExterno;
import br.ifpe.edu.salao.persistencia.ServicoExternoDAOAdapter;

public class DAOFactory extends AbstractFactory {
    private static DAOFactory instancia;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (instancia == null) {
            instancia = new DAOFactory();
        }
        return instancia;

    }

    @Override
    public GenericDAO<Servico> criarDAO() {
        return new ServicoDAO();
    }

    public GenericDAO<Servico> criarDAOComServicoExterno(ServicoExterno servicoExterno) {
        return new ServicoExternoDAOAdapter(new ServicoDAO(), servicoExterno);
    }
}
