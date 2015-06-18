package teste;

import model.entidades.Administrador;
import model.util.Conversor;
import dao.factory.DAOFactory;
import dao.interfaces.DAOAdministrador;
import dao.tabelas.TBAdministrador;
import dao.tabelas.TBAluno;
import dao.tabelas.TBAvaliador;
import dao.tabelas.TBProfessor;

public class AppTesteUsuario {

  public static void main(String[] args) {
    
    DAOAdministrador daoAdm = DAOFactory.createDAOAdministrador();
    //DAOUsuario daoUsuario = DAOFactory.createDAOUsuario();
    
    Administrador adm = new Administrador();
    adm.setNome("alex");
    adm.setEmail("admin");
    adm.setSenha("123");
    adm.setPapel(1);
    adm.setSituacao(2);
    
//    TBUsuario tbUsuario = new TBUsuario();
//    tbUsuario.setEmail(adm.getEmail());
//    tbUsuario.setSenha(adm.getSenha());
//    tbUsuario.setPapel(adm.getPapel());
//    tbUsuario.setSituacao(adm.getSituacao());
    
//    TBAdministrador tbAdm = new TBAdministrador();
//    tbAdm.setNome(adm.getNome());
    
    TBAdministrador tbAdm = Conversor.toTBAdministrador(adm);
    
    TBProfessor prof = new TBProfessor();
    prof.setDepartamento("dainf");
    prof.setDisciplinaPrincipal("prog");
    prof.setNome("paulo");
    
    TBAluno aluno = new TBAluno();
    aluno.setCampus("cwb");
    aluno.setCurso("bsi");
    aluno.setNome("alex");
    aluno.setPeriodo(5);
    
    TBAvaliador aval = new TBAvaliador();
    aval.setAtuacao("pesquisa");
    aval.setFormacao("mestre");
    aval.setNome("joaozinho");
    
    //tbUsuario.setAvaliador(aval);
    //tbUsuario.setAluno(aluno);
    //tbUsuario.setProfessor(prof);
    //tbUsuario.setAdministrador(tbAdm);
    
    //tbAdm.setUsuario(tbUsuario);
    //prof.setUsuario(tbUsuario);
    //aluno.setUsuario(tbUsuario);
    //aval.setUsuario(tbUsuario);
    
    daoAdm.salvar(tbAdm);
    //daoUsuario.salvar(tbUsuario);
    
  }

}
