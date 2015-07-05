package dao.interfaces;

import java.util.List;

import dao.tabelas.TBProjeto;

public interface DAOProjeto extends DAOGeneric<TBProjeto> {

	// retorna projeto + respostas
	public List<TBProjeto> buscarPorAlunoMembro(Integer idaluno);
	
  // modificar este???????????
  public List<TBProjeto> buscarPorSituacao(Integer s);
  
}
