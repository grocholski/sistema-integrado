package view.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JDialog {

  private static final long serialVersionUID = 1L;
  
  private final JDesktopPane contentPane;
  private JTextField emailField;
  private JTextField senhaField;

  public Login(VWPrincipal frame) {
    super(frame);
    setBounds(300, 300, 341, 221);
    contentPane = new JDesktopPane();
    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    contentPane.setLayout(null);
    setContentPane(contentPane);
    
    JPanel panel = new JPanel();
    panel.setBounds(0, 0, 325, 183);
    contentPane.add(panel);
    
    JLabel lblEmail = new JLabel("Email");
    JLabel lblSenha = new JLabel("Senha");
    
    emailField = new JTextField();
    emailField.setColumns(10);
    addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        emailField.requestFocus();
      }
    });
    
    senhaField = new JTextField();
    senhaField.setColumns(10);
    
    JButton btnEntrar = new JButton("Entrar");
    btnEntrar.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        if (frame.sessao.verificarLogin(emailField.getText(), senhaField.getText())) {
          if (frame.sessao.getPapel() == 1) {
            frame.menuBar.getMenu(2).setEnabled(true); // menu administrador
          }
          frame.menuBar.getMenu(1).setEnabled(true); // menu conta
          frame.menuBar.getMenu(0).getItem(1).setEnabled(false); // menu item login
          frame.menuBar.getMenu(0).getItem(2).setEnabled(true); // menu item logout
          frame.l.dispose();
        }
      }
    });
    
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel.setHorizontalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_panel.createSequentialGroup()
              .addContainerGap()
              .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addComponent(lblSenha)
                .addComponent(lblEmail))
              .addGap(18)
              .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addComponent(senhaField, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
            .addGroup(gl_panel.createSequentialGroup()
              .addGap(119)
              .addComponent(btnEntrar)))
          .addContainerGap())
    );
    gl_panel.setVerticalGroup(
      gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblEmail)
            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblSenha)
            .addComponent(senhaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(btnEntrar)
          .addContainerGap(73, Short.MAX_VALUE))
    );
    panel.setLayout(gl_panel);
  }
}
