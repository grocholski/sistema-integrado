package model.rn;

import java.util.ArrayList;
import java.util.List;

import model.entidades.Administrador;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOAdministrador;
import dao.tabelas.TBAdministrador;

public class RNAdministrador {

  private DAOAdministrador daoAdm = DAOFactory.createDAOAdministrador();
  
  public void salvar(Administrador adm) throws RuntimeException {
    TBAdministrador tbAdm = Conversor.toTBAdministrador(adm);
    daoAdm.salvar(tbAdm);
  }
  
  public void alterar(Administrador adm) throws RuntimeException {
    TBAdministrador tbAdm = Conversor.toTBAdministrador(adm);
    daoAdm.alterar(tbAdm);
  }
  
  public void remover(Administrador adm) throws RuntimeException {
    daoAdm.remover(adm.getId());
  }
  
  public List<Administrador> listAll() {
    List<Administrador> list = new ArrayList<Administrador>();
    for (TBAdministrador tbAdm : daoAdm.listAll()) {
      list.add(Conversor.toAdministrador(tbAdm));
    }
    return list;
  }
  
}
