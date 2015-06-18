package view.principal;

import java.awt.CardLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.util.Sessao;
import view.avaliador.ViewAvaliarProjeto;
import view.professor.CadastrarProfessor;
import view.professor.EditarProfessor;
import control.Controller;
import control.ControllerFactory;

public class VWPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;
  
  public Sessao sessao = new Sessao();
  public Controller jcont = ControllerFactory.createJFrameController(this);
  
  private JDesktopPane contentPane;
  public JMenuBar menuBar = new JMenuBar();
  
  public Login l = new Login(this);
  public CadastrarProfessor c = new CadastrarProfessor(this);

  public VWPrincipal() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 400);
    
    setJMenuBar(menuBar);
    
    JMenu mnInicio = new JMenu("Inicio");
    menuBar.add(mnInicio);
    
    JMenuItem mntmNovo = new JMenuItem("Novo");
    mntmNovo.addActionListener(jcont.getActionListener());
    mnInicio.add(mntmNovo);
    
    JMenuItem mntmLogin = new JMenuItem("Login");
    mntmLogin.addActionListener(jcont.getActionListener());
    mnInicio.add(mntmLogin);
    
    JMenuItem mntmLogout = new JMenuItem("Logout");
    mntmLogout.setEnabled(false);
    mntmLogout.addActionListener(jcont.getActionListener());
    mnInicio.add(mntmLogout);
    
    JMenu mnConta = new JMenu("Conta");
    mnConta.setEnabled(false);
    menuBar.add(mnConta);
    
    JMenuItem mntmEditarProfessor = new JMenuItem("Editar");
    mntmEditarProfessor.addActionListener(jcont.getActionListener());
    mnConta.add(mntmEditarProfessor);
    
    JMenuItem mntmDesabilitar = new JMenuItem("Desabilitar");
    mntmDesabilitar.addActionListener(jcont.getActionListener());
    mnConta.add(mntmDesabilitar);
    
    JMenu mnAdministrador = new JMenu("Administrador");
    mnAdministrador.setEnabled(false);
    menuBar.add(mnAdministrador);
    
    JMenuItem mntmHabilitarContas = new JMenuItem("Habilitar contas");
    mnAdministrador.add(mntmHabilitarContas);
    
    JMenu mnAvaliador = new JMenu("Avaliador");
    menuBar.add(mnAvaliador);
    
    JMenuItem mntmAvaliarProjeto = new JMenuItem("Avaliar projeto");
    mntmAvaliarProjeto.addActionListener(jcont.getActionListener());
    mnAvaliador.add(mntmAvaliarProjeto);
    
    contentPane = new JDesktopPane();
    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    contentPane.setLayout(new CardLayout(0, 0));
    setContentPane(contentPane);
    
    JPanel panel1 = new JPanel();
    contentPane.add(panel1, "panel1");
    
    EditarProfessor panel2 = new EditarProfessor(sessao);
    contentPane.add(panel2, "panel2");
    
    ViewAvaliarProjeto panel3 = new ViewAvaliarProjeto();
    contentPane.add(panel3, "panel3");
    
  }
}
