package model.rn;

import model.entidades.Avaliador;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOAvaliador;
import dao.tabelas.TBAvaliador;

public class RNAvaliador {
	
	private DAOAvaliador daoAvaliador = DAOFactory.createDAOAvaliador();
	
	public void salvar(Avaliador avaliador) {
		TBAvaliador tbAvaliador = Conversor.toTBAvaliador(avaliador);
		daoAvaliador.salvar(tbAvaliador);
	}
	
	public void alterar(Avaliador avaliador) {
		TBAvaliador tbAvaliador = Conversor.toTBAvaliador(avaliador);
		daoAvaliador.alterar(tbAvaliador);
	}

}
