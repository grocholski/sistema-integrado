package dao.interfaces;

import dao.tabelas.TBUsuario;

public interface DAOUsuario extends DAOGeneric<TBUsuario> {
  
  public TBUsuario verificarLog(String email, String senha);

}
