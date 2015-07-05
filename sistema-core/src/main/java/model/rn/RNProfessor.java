package model.rn;

import model.entidades.Professor;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOProfessor;
import dao.tabelas.TBProfessor;

public class RNProfessor {

  private DAOProfessor daoProf = DAOFactory.createDAOProfessor();
  
  public void salvar(Professor prof) {
    TBProfessor tbProf = Conversor.toTBProfessor(prof);
    daoProf.salvar(tbProf);
  }
  
  public void alterar(Professor prof) {
    TBProfessor tbProf = Conversor.toTBProfessor(prof);
    daoProf.alterar(tbProf);
  }
  
  public Professor buscarPorEmail(String email) {
    Professor prof = null;
    TBProfessor tbProf = daoProf.buscarPorEmail(email);
    if (tbProf != null) {
      prof = Conversor.toProfessor(tbProf);
    }
    return prof;
  }
}
