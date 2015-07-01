package dao.implement;

import javax.persistence.EntityManagerFactory;

import dao.interfaces.DAOAvaliador;
import dao.tabelas.TBAvaliador;

public class DAOAvaliadorImp extends DAOGenericImp<TBAvaliador> implements DAOAvaliador {

	public DAOAvaliadorImp(EntityManagerFactory factory) {
	  super(factory, TBAvaliador.class);
  }
}
