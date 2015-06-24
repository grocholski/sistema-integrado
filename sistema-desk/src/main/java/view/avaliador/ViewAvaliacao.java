package view.avaliador;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Color;

public class ViewAvaliacao extends JDialog {

  private static final long serialVersionUID = 1L;

  public ViewAvaliacao() {
    setBounds(100, 100, 583, 437);
    JDesktopPane contentPane = new JDesktopPane();
    contentPane.setBackground(Color.LIGHT_GRAY);
    setContentPane(contentPane);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBackground(SystemColor.scrollbar);
    
    JComboBox comboBox = new JComboBox();
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(comboBox, 0, 547, Short.MAX_VALUE)
          .addContainerGap())
        .addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap()
          .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
    );
    
    JPanel panel = new JPanel();
    tabbedPane.addTab("Quadro 1", null, panel, null);
    contentPane.setLayout(gl_contentPane);

  }
}
