package teste;

import dao.factory.DAOFactory;
import dao.interfaces.DAOProjeto;
import dao.tabelas.TBProjeto;

public class AppTesteProjeto3 {

	public static void main(String[] args) {
		
		DAOProjeto daoproj = DAOFactory.createDAOProjeto();
		
		for (TBProjeto string : daoproj.buscarPorAlunoMembro(1)) {
	    System.out.println(string.getMembros().get(0).getNome());
	    //System.out.println(string.getMembros().get(1));
    }
		
		

	}

}
