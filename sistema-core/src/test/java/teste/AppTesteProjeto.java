package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entidades.Projeto;
import model.util.Conversor;
import dao.tabelas.TBProjeto;

public class AppTesteProjeto {

  public static void main(String [] args) {
      
    EntityManagerFactory fac = Persistence.createEntityManagerFactory("sistema-core");
    EntityManager man = fac.createEntityManager();
    
//    TBProjeto projeto = new TBProjeto();
//    projeto.setTitulo("titulo");
//    projeto.setDescricao("descricao");
//    projeto.setSituacao(1);
//    
//    TBAluno aluno = new TBAluno();
//    aluno.setIdusuario(4);
//    
//    TBProfessor prof = new TBProfessor();
//    prof.setIdusuario(3);
//    
//    projeto.setLider(aluno);
//    projeto.setOrientador(prof);
    
    man.getTransaction().begin();
    TBProjeto tbProj = man.find(TBProjeto.class, 1);
    man.getTransaction().commit();
    
    //System.out.println(tbProj.getAvaliaProjeto().get(0).getAvaliador().getNome());
    
    Projeto proj = Conversor.toProjeto(tbProj);
    System.out.println(proj.getTitulo());
    System.out.println(proj.getLider().getNome());
    System.out.println(proj.getMembros().get(0).getCurso());
    System.out.println(proj.getAvaliadores().get(0).getAtuacao());
    
    man.close();
    fac.close();
  }
}
