package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.tabelas.TBAluno;
import dao.tabelas.TBProfessor;
import dao.tabelas.TBProjeto;
import dao.tabelas.TBUsuario;

public class AppTesteProjetoAluno {

  public static void main(String[] args) {
    
    EntityManagerFactory fac = Persistence.createEntityManagerFactory("sistema-core");
    EntityManager man = fac.createEntityManager();

    man.getTransaction().begin();
    TBProjeto pj = man.find(TBProjeto.class, 1);
    
    for (int i = 0; i < pj.getMembros().size(); i++) {
      System.out.println(pj.getMembros().get(i).getNome());
    }
    
    man.getTransaction().commit();
    
    System.exit(1);
    
    TBProjeto projeto = new TBProjeto();
    projeto.setIdprojeto(5);
    projeto.setTitulo("titulo");
    projeto.setDescricao("descricao");
    projeto.setSituacao(1);
    
    projeto.setLider(new TBAluno());
    projeto.getLider().setIdusuario(4);

    projeto.setOrientador(new TBProfessor());
    projeto.getOrientador().setIdusuario(3);
    
    projeto.setMembros(pj.getMembros());
    
    TBAluno aluno = new TBAluno();
    aluno.setIdusuario(6);
    aluno.setCampus("cwb");
    aluno.setCurso("bsi");
    aluno.setNome("alex");
    aluno.setPeriodo(5);
    aluno.setUsuario(new TBUsuario());
    aluno.getUsuario().setIdusuario(6);
    
//    man.getTransaction().begin();
//    aluno = man.find(TBAluno.class, 5);
//    man.getTransaction().commit();
    
//    TBProfessor prof = new TBProfessor();
//    prof.setIdusuario(3);
//    
//    projeto.setLider(aluno);
//    projeto.setOrientador(prof);
    
//    TBAluno aluno = new TBAluno();
//    aluno.setIdusuario(4);
    
//    Set<TBAluno> membros = new HashSet<TBAluno>();
//    membros.add(aluno);
    
//    projeto.setMembros(membros);
//    aluno.getProjetosMembro().add(projeto);
    
//    TBProfessor prof = new TBProfessor();
//    prof.setIdusuario(3);
    
//    projeto.setLider(aluno);
//    projeto.setOrientador(prof);
    
    try {
      man.getTransaction().begin();
      
//      projeto = man.find(TBProjeto.class, 1);
//    aluno = man.find(TBAluno.class, 4);
      
//    System.out.println(projeto.getMembros().get(0).getNome());
  
      // soh esta funcionando qndo o aluno eh novo
      // funcionou qndo mudei para list
      // ***a list membros deve ser carregada do banco antes de salvar
      projeto.getMembros().add(aluno);
      
      man.merge(projeto);
      man.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      man.close();
      fac.close();
      System.exit(1);
    }
    
    

  }
}
