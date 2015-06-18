package dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.interfaces.DAOGeneric;

public class DAOGenericImp<T> implements DAOGeneric<T> {

  protected EntityManagerFactory factory;
  protected EntityManager manager;
  protected Class<?> classe;

  public DAOGenericImp(EntityManagerFactory factory, Class<?> classe) {
    this.factory = factory;
    this.classe = classe;
  }
  
  @Override
  public void salvar(T obj) {
    try {
      manager = factory.createEntityManager();
      manager.getTransaction().begin();
      manager.persist(obj); 
      manager.getTransaction().commit();      
      
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new RuntimeException("Erro ao tentar salvar.", e);
    } finally {
      manager.close();
    }
  }

  @Override
  public void remover(Object pk) {
    try {
      manager = factory.createEntityManager();
      manager.getTransaction().begin();
      manager.remove(manager.find(classe, pk));
      manager.getTransaction().commit();
      
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new RuntimeException("Erro ao tentar remover.", e);
    } finally {
      manager.close();
    }
  }
  
  @Override
  public void alterar(T obj) {
    try {
      manager = factory.createEntityManager();
      manager.getTransaction().begin();
      manager.merge(obj);
      manager.getTransaction().commit();
      
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new RuntimeException("Erro ao tentar alterar.", e);
    } finally {
      manager.close();
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<T> listAll() {
    List<T> list = null;
    try {
      String jpql = "SELECT t FROM " + classe.getSimpleName() +" t";
      
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql, classe);
      list = query.getResultList();
      
    } catch (RuntimeException e) {
      
    } finally {
      manager.close();
    }
    return list;
  }

  @Override
  public void alterarSituacao(Integer pk, Integer situacao) {
    try {
      String jpql = "UPDATE " + classe.getSimpleName() + "SET situacao=? WHERE idusuario=?";
      
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql, classe);
      query.setParameter("situacao", situacao);
      query.setParameter("idusuario", pk);
      query.executeUpdate();
      
    } catch (RuntimeException e) {
      
    } finally {
      manager.close();
    }
  }

}
