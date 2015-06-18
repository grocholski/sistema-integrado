package view.avaliador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewAvaliarProjeto extends JPanel {

  private static final long serialVersionUID = 1L;

  public ViewAvaliarProjeto() {
    
    JComboBox<String> comboBox = new JComboBox<String>();
    comboBox.addFocusListener(new FocusListener() {
      
      @Override
      public void focusLost(FocusEvent e) {}
      
      @Override
      public void focusGained(FocusEvent e) {
        comboBox.addItem("teste 1");
        comboBox.addItem("teste 2");
      }
    });
    
    JScrollBar scrollBar = new JScrollBar();
    
    JButton btnMostrar = new JButton("Mostrar");
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(comboBox, 0, 326, Short.MAX_VALUE)
          .addGap(18)
          .addComponent(btnMostrar)
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMostrar))
          .addContainerGap(269, Short.MAX_VALUE))
        .addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
    );
    setLayout(groupLayout);

  }
}
