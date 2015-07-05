package dao.interfaces;

import dao.tabelas.TBProfessor;

public interface DAOProfessor extends DAOGeneric<TBProfessor> {

  public TBProfessor buscarPorEmail(String email);
  
}
