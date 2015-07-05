package model.rn;

import java.util.ArrayList;
import java.util.List;

import model.entidades.Projeto;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOProjeto;
import dao.tabelas.TBProjeto;

public class RNProjeto {

  private DAOProjeto daoProj = DAOFactory.createDAOProjeto();

  public void salvar(Projeto proj) {
    TBProjeto tbProj = Conversor.toTBProjeto(proj);
    daoProj.salvar(tbProj);
  }

  public void alterar(Projeto proj) {
    TBProjeto tbProj = Conversor.toTBProjeto(proj);
    daoProj.alterar(tbProj);
  }
  
  public void remover(Projeto proj) {
    daoProj.remover(proj.getIdprojeto());
  }
  
  public List<Projeto> listAll() {
    List<Projeto> list = new ArrayList<Projeto>();
    for (TBProjeto tbProj : daoProj.listAll()) {
      list.add(Conversor.toProjeto(tbProj));
    }
    return list;
  }
  
  public List<Projeto> buscarPorSituacao() {
    return null;
  }

}
