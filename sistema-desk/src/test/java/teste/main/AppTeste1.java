package teste.main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AppTeste1 {

  public static void main(String[] args) {

    JFrame f = new JFrame("meu frame");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JDialog d = new JDialog(f, "dialog1");
    JDialog d2 = new JDialog(f, "dialog2");
    
    JTextField tf = new JTextField();
    JButton b = new JButton("clique");
    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        d.setVisible(false);
        f.setVisible(true);
        d2.add(new JLabel("hi "+tf.getText()));
        d2.setVisible(true);
      }
    });
    
    d.getContentPane().setLayout(new GridLayout());
    d.add(tf);
    d.add(b);
    d.setVisible(true);
    d2.setVisible(false);
    
    
//    VWPrincipal p = new VWPrincipal();
//    p.setVisible(true);
    
  }
}
