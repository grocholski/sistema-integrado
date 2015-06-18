package view.professor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import control.ControllerFactory;
import control.professor.CTProfessor;
import model.util.Sessao;

public class EditarProfessor extends JPanel {

  private static final long serialVersionUID = 1L;
  private JTextField departField;
  private JTextField senhaField;
  private JTextField emailField;
  private JTextField nomeField;
  private JTextField discField;
  
  private CTProfessor cp;
  public Sessao sessao;

  public EditarProfessor(Sessao sessao) {
    this.sessao = sessao;
    cp = ControllerFactory.createCtProfessor(this);
    
    JLabel lblNome = new JLabel("Nome:");
    
    JLabel lblEmail = new JLabel("Email:");
    
    JLabel lblSenha = new JLabel("Senha:");
    
    JLabel lblDepartamento = new JLabel("Departamento:");
    
    JLabel lblDisciplina = new JLabel("Disciplina:");
    
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
    
    JButton btnSalvar = new JButton("Salvar");
    btnSalvar.addActionListener(cp.getActionListener());
    
    JButton btnDesabilitarConta = new JButton("Desabilitar conta");
    btnDesabilitarConta.addActionListener(cp.getActionListener());
    
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblDepartamento)
                .addComponent(lblSenha)
                .addComponent(lblEmail)
                .addComponent(lblNome)
                .addComponent(lblDisciplina))
              .addGap(18)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(senhaField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addComponent(departField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addComponent(discField, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(btnSalvar)
              .addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
              .addComponent(btnDesabilitarConta)))
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
          .addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnSalvar)
            .addComponent(btnDesabilitarConta))
          .addContainerGap())
    );
    setLayout(groupLayout);

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
