package dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.interfaces.DAOProjeto;
import dao.tabelas.TBProjeto;
import dao.tabelas.TBResposta;

public class DAOProjetoImp extends DAOGenericImp<TBProjeto> implements DAOProjeto {

  public DAOProjetoImp(EntityManagerFactory factory) {
    super(factory, TBProjeto.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<TBProjeto> buscarPorSituacao(Integer s) {
    List<TBProjeto> projetos = new ArrayList<TBProjeto>();
    try {
      String jpql = "SELECT p FROM TBProjeto p WHERE p.situacao = :situacao";
      
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql, TBProjeto.class);
      query.setParameter("situacao", s);
      projetos = query.getResultList();
    } catch (RuntimeException e) {
      e.printStackTrace();
    } finally {
      manager.close();
    }
    return projetos;
  }

	@SuppressWarnings("unchecked")
  @Override
  public List<TBProjeto> buscarPorAlunoMembro(Integer idaluno) {
	  List<TBProjeto> projetos = new ArrayList<TBProjeto>();
		try {
	    
			String jpql = ""
					+ "select p from TBProjeto p "
					+ "join fetch p.membros membro "
					//+ "join p.membros membro "
					+ "where membro.idusuario = " + idaluno.toString();
			
			manager = factory.createEntityManager();
			Query query = manager.createQuery(jpql);
			List<TBProjeto> list = query.getResultList();
			
			jpql = ""
					+ "select r from TBResposta r "
					+ "where r.projeto = :projeto";
			query = manager.createQuery(jpql);
			
			for (TBProjeto tbProjeto : list) {
	      query.setParameter("projeto", tbProjeto);
	      List<TBResposta> resps = query.getResultList();
	      tbProjeto.setRespostas(resps);
	      projetos.add(tbProjeto);
      }
			
    } catch (RuntimeException e) {
	    e.printStackTrace();
    }
	  return projetos;
  }

}
