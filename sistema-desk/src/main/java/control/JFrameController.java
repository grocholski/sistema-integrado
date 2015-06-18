package control;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.principal.VWPrincipal;

public class JFrameController extends Controller {
  
  private VWPrincipal p;
  
  public JFrameController(VWPrincipal p) {
    createActionListener();
    this.p = p;
  }
  
  protected void createActionListener() {
    this.setActionListener(
    new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        switch (((JMenuItem) e.getSource()).getText()) {
        case "Novo":
          showCadastrarDialog();
          break;
        case "Login":
          showLoginDialog();
          break;
        case "Logout":
          //sair();
          // fechar programa ou destruir sessao
          break;
        case "Editar professor":
          getLayout().show(p.getContentPane(), "panel2");
          break;
        case "Desabilitar":
          desabilitar();
          break;
        case "Avaliar projeto":
          getLayout().show(p.getContentPane(), "panel3");
          // ** nao aqui: mas criar panel somente quando for avaliador??!!
          // mostrar pagina
          // carregar combobox
        } 
      }
    });
  }
  
  private void showLoginDialog() {
    p.l.setVisible(true);
  }
  
  private void showCadastrarDialog() {
    p.c.setVisible(true);
  }
  
  private void desabilitar() {
    p.sessao.alterarSituacao();
    p.sessao.terminarSessao();
    // fechar com estilo
    System.exit(1);
  }
  
  private CardLayout getLayout() {
    return (CardLayout) p.getContentPane().getLayout();
  }
}
