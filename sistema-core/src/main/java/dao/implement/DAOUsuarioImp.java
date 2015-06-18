package dao.implement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.interfaces.DAOUsuario;
import dao.tabelas.TBUsuario;

public class DAOUsuarioImp extends DAOGenericImp<TBUsuario> 
    implements DAOUsuario {

  public DAOUsuarioImp(EntityManagerFactory factory) {
    super(factory, TBUsuario.class);
  }

  @Override
  public TBUsuario verificarLog(String email, String senha) {
    TBUsuario tbUsuario = null;
    try {
      String jpql = "SELECT u FROM TBUsuario u WHERE u.email = :email "
          + "AND u.senha = :senha";
      
      manager = factory.createEntityManager();
      Query query = manager.createQuery(jpql, TBUsuario.class);
      query.setParameter("email", email);
      query.setParameter("senha", senha);
      tbUsuario = (TBUsuario) query.getSingleResult();
      
    } catch (RuntimeException e) {
      e.printStackTrace();
    } finally {
      manager.close();
    }
    return tbUsuario;
  }
}
