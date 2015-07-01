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
import view.professor.ViewCadastrarProfessor;
import view.professor.ViewAtualizarProfessor;
import controller.util.ControllerFactory;
import controller.util.ControllerGeneric;

public class WindowMain extends JFrame {

  private static final long serialVersionUID = 1L;
  
  public Sessao sessao = new Sessao();
  private ControllerGeneric controller = ControllerFactory.createControllerMain(this);
  
  private JDesktopPane contentPane;
  
  public Login login = new Login(this);
  public ViewCadastrarProfessor cadProf = new ViewCadastrarProfessor(this);

  public WindowMain() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 400);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnInicio = new JMenu("Inicio");
    menuBar.add(mnInicio);
    
    JMenuItem mntmNovo = new JMenuItem("Novo");
    mntmNovo.addActionListener(controller.getActionListener());
    mnInicio.add(mntmNovo);
    
    JMenuItem mntmLogin = new JMenuItem("Login");
    mntmLogin.addActionListener(controller.getActionListener());
    mnInicio.add(mntmLogin);
    
    JMenuItem mntmLogout = new JMenuItem("Logout");
    mntmLogout.setEnabled(false);
    mntmLogout.addActionListener(controller.getActionListener());
    mnInicio.add(mntmLogout);
    
    JMenu mnCadastro = new JMenu("Cadastro");
    mnCadastro.setEnabled(false); // inicia desabilitada
    menuBar.add(mnCadastro);
    
    JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
    mntmAtualizar.addActionListener(controller.getActionListener());
    mnCadastro.add(mntmAtualizar);
    
    JMenuItem mntmDesabilitar = new JMenuItem("Desabilitar");
    mntmDesabilitar.addActionListener(controller.getActionListener());
    mnCadastro.add(mntmDesabilitar);
    
    JMenu mnAdministrador = new JMenu("Administrador");
    mnAdministrador.setEnabled(false); // inicia desabilitada
    menuBar.add(mnAdministrador);
    
    JMenuItem mntmHabilitarContas = new JMenuItem("Habilitar Contas");
    mnAdministrador.add(mntmHabilitarContas);
    
    JMenuItem mntmNovoAvaliador = new JMenuItem("Novo Avaliador");
    mnAdministrador.add(mntmNovoAvaliador);
    
    JMenuItem mntmAtribuirAvaliador = new JMenuItem("Atribuir Avaliador");
    mnAdministrador.add(mntmAtribuirAvaliador);
    
    JMenu mnAvaliador = new JMenu("Avaliador");
    mnAvaliador.setEnabled(false); // inicia desabilitada
    menuBar.add(mnAvaliador);
    
    JMenuItem mntmAvaliarProjeto = new JMenuItem("Avaliar Projeto");
    mntmAvaliarProjeto.addActionListener(controller.getActionListener());
    mnAvaliador.add(mntmAvaliarProjeto);
    
    JMenu mnProfessor = new JMenu("Professor");
    mnProfessor.setEnabled(false); // inicia desabilitada
    menuBar.add(mnProfessor);
    
    JMenuItem mntmComentar = new JMenuItem("Comentar Projeto");
    mnProfessor.add(mntmComentar);
    
    contentPane = new JDesktopPane();
    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    contentPane.setLayout(new CardLayout(0, 0));
    setContentPane(contentPane);
    
    // tela inicial
    JPanel panel1 = new JPanel();
    contentPane.add(panel1, "panel1");
    
    ViewAtualizarProfessor panel2 = new ViewAtualizarProfessor(sessao);
    contentPane.add(panel2, "panel2");
    
  }
}
