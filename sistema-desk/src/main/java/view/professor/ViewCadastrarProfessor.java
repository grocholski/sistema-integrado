package view.professor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import view.principal.WindowMain;
import controller.util.ControllerFactory;
import controller.util.ControllerGeneric;

public class ViewCadastrarProfessor extends JDialog {

  private static final long serialVersionUID = 1L;
  
  private final JDesktopPane contentPane = new JDesktopPane();
  
  private JTextField departField;
  private JTextField senhaField;
  private JTextField emailField;
  private JTextField nomeField;
  private JTextField discField;
  
  private JPanel panel;
  private ControllerGeneric ctProf;

  public ViewCadastrarProfessor(WindowMain frame) {
    super(frame);
    setBounds(300, 300, 450, 400);
    contentPane.setLayout(null);
    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    setContentPane(contentPane);

    panel = new JPanel();
    panel.setBounds(0, 0, 412, 362);
    contentPane.add(panel);
    ctProf = ControllerFactory.createControllerProfessor(this);
    
    JLabel lblNome = new JLabel("Nome:");
    JLabel lblEmail = new JLabel("Email:");
    JLabel lblSenha = new JLabel("Senha:");
    JLabel lblDepartamento = new JLabel("Departamento:");
    JLabel lblDisciplina = new JLabel("Disciplina:");
    
    JCheckBox chckbxProfessor = new JCheckBox("Professor");
    chckbxProfessor.setSelected(true);
    chckbxProfessor.setEnabled(false);
    
    JButton btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.addActionListener(ctProf.getActionListener());
    
    departField = new JTextField();
    departField.setColumns(10);
    
    senhaField = new JTextField();
    senhaField.setColumns(10);
    
    emailField = new JTextField();
    emailField.setColumns(10);
    
    nomeField = new JTextField();
    nomeField.setColumns(10);
    
    discField = new JTextField();
    discField.setColumns(10);
    
    GroupLayout groupLayout = new GroupLayout(panel);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(chckbxProfessor)
            .addComponent(btnCadastrar)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblDepartamento)
                .addComponent(lblSenha)
                .addComponent(lblEmail)
                .addComponent(lblNome)
                .addComponent(lblDisciplina))
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(senhaField, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addComponent(departField, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addComponent(discField, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNome)
            .addComponent(nomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblEmail)
            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblSenha)
            .addComponent(senhaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblDepartamento)
            .addComponent(departField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblDisciplina)
            .addComponent(discField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(chckbxProfessor)
          .addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
          .addComponent(btnCadastrar)
          .addContainerGap())
    );
    panel.setLayout(groupLayout);

  }
  public JTextField getDepartField() {
    return departField;
  }
  public void setDepartField(JTextField departField) {
    this.departField = departField;
  }
  public JTextField getSenhaField() {
    return senhaField;
  }
  public void setSenhaField(JTextField senhaField) {
    this.senhaField = senhaField;
  }
  public JTextField getEmailField() {
    return emailField;
  }
  public void setEmailField(JTextField emailField) {
    this.emailField = emailField;
  }
  public JTextField getNomeField() {
    return nomeField;
  }
  public void setNomeField(JTextField nomeField) {
    this.nomeField = nomeField;
  }
  public JTextField getDiscField() {
    return discField;
  }
  public void setDiscField(JTextField discField) {
    this.discField = discField;
  }

}
