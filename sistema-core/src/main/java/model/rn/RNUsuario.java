package model.rn;

import model.entidades.Usuario;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOUsuario;
import dao.tabelas.TBAluno;
import dao.tabelas.TBProfessor;
import dao.tabelas.TBUsuario;

public class RNUsuario {
  
  private DAOUsuario daoUsuario = DAOFactory.createDAOUsuario();
  
  public Usuario login(String email, String senha) {
    TBUsuario tbs = daoUsuario.verificarLog(email, senha);
    
    if (tbs != null) {
      switch (tbs.getPapel()) {
        case 2:
          TBAluno tba = tbs.getAluno();
          tba.setUsuario(tbs);
          return Conversor.toAluno(tba);
        case 3:
          TBProfessor tbp = tbs.getProfessor();
          tbp.setUsuario(tbs);
          return Conversor.toProfessor(tbp);
      }
    }
    return null;
  }

}
