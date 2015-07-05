package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;

import model.entidades.Aluno;
import model.entidades.Professor;
import model.entidades.Projeto;
import model.rn.RNAluno;
import model.rn.RNProfessor;
import model.rn.RNProjeto;
import web.util.SessionBean;

@ManagedBean(name = "controller")
@ViewScoped
public class ProjetoController {

  private RNProjeto rnProjeto = new RNProjeto();
  private RNAluno rnAluno = new RNAluno();
  private RNProfessor rnProfessor = new RNProfessor();

  private static final Projeto projeto = new Projeto();
  private static final List<Aluno> membros = new ArrayList<Aluno>();
  private String alunoEmail;
  private String orientadorEmail;
  
  // ajax event listener
  public void buscaAluno(AjaxBehaviorEvent e) {
    boolean b = true;
    if (alunoEmail != null && !(alunoEmail.equals(""))) {
      for (Aluno al : membros) {
        if (al.getEmail().equals(alunoEmail)) { b = false; break; }
      }
      if (b) {
        Aluno a = rnAluno.buscarPorEmail(alunoEmail);
        if (a != null) { membros.add(a); }
      }
    }
  }
  
  // ajax event listener
  public void buscaProfessor(AjaxBehaviorEvent e) {
    if (orientadorEmail != null && !("".equals(orientadorEmail))) {
      Professor p = rnProfessor.buscarPorEmail(orientadorEmail);
      if (p != null) {
        projeto.setOrientador(p);
      }
    }
  }
  
  // response ajax
  public List<Aluno> getMembros() {
    return membros;
  }
  
  // response ajax
  public String getOrientador() {
    if (projeto.getOrientador() != null) {
      return projeto.getOrientador().getNome();
    }
    return "";
  }
  
  // form action
  public String cadastrar() {
    
    projeto.setMembros(membros);
    
    if (projeto.getOrientador() != null && !(projeto.getMembros().isEmpty())
        && projeto.getTitulo() != null) {
      
      Aluno aluno = (Aluno) SessionBean.getUser();
      SessionBean.getSession().setAttribute("lider", 1);
      aluno.setIsLider(1);
      
      projeto.getMembros().add(aluno);
      projeto.setSituacao(1);
      projeto.setLider(aluno);
      
      rnProjeto.alterar(projeto);
      rnAluno.alterar(aluno);
      return "../private/home.xhtml";
    }
    return null;
  }
  
  public Projeto getProjeto() {
    return projeto;
  }
  
  public String getAlunoEmail() {
    return alunoEmail;
  }
  
  public void setAlunoEmail(String alunoEmail) {
    this.alunoEmail = alunoEmail;
  }

  public String getOrientadorEmail() {
    return orientadorEmail;
  }

  public void setOrientadorEmail(String orientadorEmail) {
    this.orientadorEmail = orientadorEmail;
  }
  
}
