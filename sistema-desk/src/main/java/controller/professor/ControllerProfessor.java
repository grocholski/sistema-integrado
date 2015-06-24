package controller.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.util.ControllerGeneric;
import model.entidades.Professor;
import model.rn.RNProfessor;
import view.professor.ViewCadastrarProfessor;
import view.professor.ViewEditarProfessor;

public class ControllerProfessor extends ControllerGeneric {

  private RNProfessor rnProf = new RNProfessor();
  private Professor prof = new Professor();
  
  private ViewCadastrarProfessor p1;
  private ViewEditarProfessor p2;
  
  public ControllerProfessor() {
    createActionListener();
  }

  protected void createActionListener() {
    this.setActionListener(
    new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Cadastrar":
          cadastrar();
          p1.dispose();
          break;
        case "Salvar":
          editar();
          break;
        } 
      }
    });
  }
  
  private void cadastrar() {
    prof.setId(null);
    prof.setNome(p1.getNomeField().getText());
    prof.setEmail(p1.getEmailField().getText());
    prof.setSenha(p1.getSenhaField().getText());
    prof.setDepartamento(p1.getDepartField().getText());
    prof.setDisciplinaPrincipal(p1.getDiscField().getText());
    prof.setSituacao(2); // 1: novo
    prof.setPapel(3); // 3: professor
    
    rnProf.salvar(prof);
    prof = new Professor();
  }
  
  private void editar() {
    prof.setId(p2.sessao.getUsuario().getId());
    prof.setNome(p2.getNomeField().getText());
    prof.setEmail(p2.getEmailField().getText());
    prof.setSenha(p2.getSenhaField().getText());
    prof.setDepartamento(p2.getDepartField().getText());
    prof.setDisciplinaPrincipal(p2.getDiscField().getText());
    prof.setSituacao(2); // 2: ativo
    prof.setPapel(3); // 3: professor
    
    rnProf.alterar(prof);
    prof = new Professor();
  }

  public void setP1(ViewCadastrarProfessor p1) {
    this.p1 = p1;
  }

  public void setP2(ViewEditarProfessor p2) {
    this.p2 = p2;
  }
}
