package dao.interfaces;

import dao.tabelas.TBAluno;

public interface DAOAluno extends DAOGeneric<TBAluno> {
  
  public TBAluno buscarPorEmail(String email);

}
