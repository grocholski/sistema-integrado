package dao.implement;

import javax.persistence.EntityManagerFactory;

import dao.interfaces.DAOProfessor;
import dao.tabelas.TBProfessor;

public class DAOProfessorImp extends DAOGenericImp<TBProfessor> 
    implements DAOProfessor {

  public DAOProfessorImp(EntityManagerFactory factory) {
    super(factory, TBProfessor.class);
  }

}
