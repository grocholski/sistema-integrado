package dao.implement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.interfaces.DAOProfessor;
import dao.tabelas.TBProfessor;

public class DAOProfessorImp extends DAOGenericImp<TBProfessor> 
    implements DAOProfessor {

  public DAOProfessorImp(EntityManagerFactory factory) {
    super(factory, TBProfessor.class);
  }

  @Override
  public TBProfessor buscarPorEmail(String email) {
    TBProfessor tbProf = null;
    try {
      String jpql = "SELECT p FROM TBProfessor p WHERE p.usuario.email = :email";
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql);
      query.setParameter("email", email);
      tbProf = (TBProfessor) query.getSingleResult();
      
    } catch (RuntimeException e) {
      e.printStackTrace();
    } finally {
      manager.close();
    }
    return tbProf;
  }

}
