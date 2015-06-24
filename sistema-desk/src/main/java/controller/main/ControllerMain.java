package controller.main;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import controller.util.ControllerGeneric;
import view.principal.WindowMain;

public class ControllerMain extends ControllerGeneric {
  
  private WindowMain w;
  
  public ControllerMain(WindowMain w) {
    createActionListener();
    this.w = w;
  }
  
  protected void createActionListener() {
    this.setActionListener(
    new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        switch (((JMenuItem) e.getSource()).getText()) {
          case "Novo":
            mostrarCadastrarDialog();
            break;
          
          case "Login":
            mostrarLoginDialog();
            break;
          
          case "Logout":
            //sair();
            // fechar programa ou destruir sessao
            break;
          
          case "Editar professor":
            getWindowLayout().show(w.getContentPane(), "panel2");
            break;
          
          case "Desabilitar":
            desabilitarUsuario();
            break;
          
          case "Avaliar projeto":
            getWindowLayout().show(w.getContentPane(), "panel3");
            // ** nao aqui: mas criar panel somente quando for avaliador??!!
            // mostrar pagina
            // carregar combobox
        } 
      }
    });
  }
  
  private void mostrarLoginDialog() {
    w.login.setVisible(true);
  }
  
  private void mostrarCadastrarDialog() {
    // mudar para panel??
    w.cadProf.setVisible(true);
  }
  
  private void desabilitarUsuario() {
    w.sessao.alterarSituacao(3);
    w.sessao.terminarSessao();
    // fechar com estilo
    System.exit(1);
  }
  
  private CardLayout getWindowLayout() {
    return (CardLayout) w.getContentPane().getLayout();
  }
}
