package controller.avaliador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.entidades.Avaliador;
import model.rn.RNAvaliador;
import controller.util.ControllerGeneric;

public class ControllerAvaliador extends ControllerGeneric {

	private RNAvaliador rnAvaliador = new RNAvaliador();
	private Avaliador avaliador = new Avaliador();
	
	//private ViewAtualizarAvaliador p1;
	//private ViewCadastrarAvaliador p2;
	
	public ControllerAvaliador() {
		createActionListener();
	}
	
  @Override
	protected void createActionListener() {
  	this.setActionListener(
  	new ActionListener() {
  	  @Override
  	  public void actionPerformed(ActionEvent e) {
  	    switch (((JButton) e.getSource()).getText()) {
  	      case "Atualizar":
  	        atualizar();
  	        break;
  	      case "Cadastrar":
  	      	cadastrar();
  	      	break;
  	    } 
  	  }
  	});
	}
  
  private void atualizar() {
  	
  }
  
  private void cadastrar() {
  	
  }

}
