package model.rn;

import model.entidades.Aluno;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOAluno;
import dao.tabelas.TBAluno;

public class RNAluno {
  
  private DAOAluno daoAluno = DAOFactory.createDAOAluno();

  public Aluno buscarPorEmail(String email) {
    Aluno aluno = null;
    TBAluno tbAluno = daoAluno.buscarPorEmail(email);
    if (tbAluno != null) {
      aluno = Conversor.toAluno(tbAluno);
    }
    return aluno;
  }
  
  public void alterar(Aluno aluno) {
    TBAluno tbAluno = Conversor.toTBAluno(aluno);
    daoAluno.alterar(tbAluno);
  }
  
}
