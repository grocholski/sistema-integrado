package dao.interfaces;

import java.util.List;

public interface DAOGeneric<T> {

	public void salvar(T obj);

	public void alterar(T obj);
	
	public void remover(Object pk);
	
	public List<T> listAll();
	
	public void alterarSituacao(Integer pk, Integer situacao);
	
}
