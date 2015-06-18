package dao.implement;

import javax.persistence.EntityManagerFactory;

import dao.interfaces.DAOAdministrador;
import dao.tabelas.TBAdministrador;

public class DAOAdministradorImp extends DAOGenericImp<TBAdministrador> 
    implements DAOAdministrador {

  public DAOAdministradorImp(EntityManagerFactory factory) {
    super(factory, TBAdministrador.class);
  }
}
