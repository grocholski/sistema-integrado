package dao.implement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.interfaces.DAOAluno;
import dao.tabelas.TBAluno;

public class DAOAlunoImp extends DAOGenericImp<TBAluno> implements DAOAluno {

  public DAOAlunoImp(EntityManagerFactory factory) {
    super(factory, TBAluno.class);
  }
  
  @Override
  public TBAluno buscarPorEmail(String email) {
    TBAluno tbAluno = null;
    try {
      String jpql = "SELECT a FROM TBAluno a WHERE a.usuario.email = :email";
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql);
      query.setParameter("email", email);
      tbAluno = (TBAluno) query.getSingleResult();
      
    } catch (RuntimeException e) {
      e.printStackTrace();
      System.out.println("deboas");
    } finally {
      manager.close();
    }
    return tbAluno;
  }

}
