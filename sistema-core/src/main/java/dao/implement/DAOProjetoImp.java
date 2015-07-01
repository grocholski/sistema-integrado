package dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.interfaces.DAOProjeto;
import dao.tabelas.TBAvaliador;
import dao.tabelas.TBProjeto;
import dao.tabelas.TBResposta;
import dao.util.BDUtil;

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
  public List<TBProjeto> buscarPorAvaliador(Integer idavaliador) {
    List<TBProjeto> projetos = new ArrayList<TBProjeto>();
    TBAvaliador av = new TBAvaliador();//melhorar
    av.setIdusuario(idavaliador);
    try {
      // limitar projecao: idprojeto + titulo + situacao
      // carregar respostas tbm
      // buscar por avaliador e situacao??
      String jpql = 
          "SELECT p FROM TBProjeto p, TBAvaliaProjeto ap WHERE "
          + "p.idprojeto = ap.pk.projeto AND ap.pk.avaliador = :avaliador";
      
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql, TBProjeto.class);
      query.setParameter("avaliador", av);
      projetos = query.getResultList();
    } catch (RuntimeException e) {
      e.printStackTrace();
    } finally {
      manager.close();
    }
    return projetos;
  }
  
  @Override
  public TBProjeto buscarProjetoAluno(Integer idprojeto) {
    TBProjeto tbProj = null;
    try {
      // mudar para query
      String jpql = "";
      
      manager = factory.createEntityManager();
      manager.getTransaction().begin();
      tbProj = manager.find(TBProjeto.class, idprojeto);
      tbProj.getMembros().get(0);
      tbProj.getRespostas().get(0);
      tbProj.getComentarios().get(0);
      manager.getTransaction().commit();
    } catch (RuntimeException e) {
      manager.getTransaction().rollback();
    } finally {
      manager.close();
    }
    return tbProj;
  }

  @Override
  public TBProjeto buscarProjetoAvaliador(Integer idprojeto, Integer idavaliador) {
    TBProjeto tbProj = null;
    try {
      String jpql = "";
      
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql);
      tbProj = (TBProjeto) query.getResultList().get(0);
      
    } catch (RuntimeException e) {
      manager.getTransaction().rollback();
    } finally {
      manager.close();
    }
    return tbProj;
  }

  @Override
  public TBProjeto buscarProjetoAdministrador(Integer idprojeto) {
    // TODO Auto-generated method stub
    return null;
  }

	@SuppressWarnings("unchecked")
  @Override
  public List<TBProjeto> buscarProjetoPorAvaliador(Integer id, Integer situacao) {
		List<TBProjeto> list = new ArrayList<TBProjeto>();
  	
		try {
			
			List<Object> params = new ArrayList<Object>(2);
			params.add(id);
			params.add(situacao);
			
			String sql = ""
					+ "SELECT p.id, p.titulo,  FROM projeto p "
					+ "JOIN resposta r ON p.id = r.idprojeto "
					+ "JOIN avalia_projeto a ON p.id = a.idprojeto "
					+ "WHERE a.idusuario = ?"
					+ "AND p.situacao = ?";
			
			Connection conn = BDUtil.getConnection();
			ResultSet rs = BDUtil.executeSQL(conn, sql, params);
			
			while (rs.next()) {
				
			}
			
		} catch(SQLException e) {
			
		}
		
		
		
		try {
  		
  		String jpql = ""
  				+ "SELECT p FROM TBProjeto p "
      			+ "JOIN FETCH p.respostas	"
      			+ "JOIN FETCH p.avaliaprojeto "
      			+ "JOIN p.avaliaprojeto	"
      			+ "WHERE p.avaliaprojeto.pk.avaliador = :id AND p.situacao = :situacao";
  		
  		manager = factory.createEntityManager();
  		Query query = manager.createQuery(jpql);
  		query.setParameter("id", id);
  		query.setParameter("situacao", situacao);
  		list = query.getResultList();
  		
  	} catch (RuntimeException e) {
  		e.printStackTrace();
  	} finally {
  		manager.close();
  	}
  	
  	return list;
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
