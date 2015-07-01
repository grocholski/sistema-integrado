package dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.implement.DAOAdministradorImp;
import dao.implement.DAOAvaliadorImp;
import dao.implement.DAOProfessorImp;
import dao.implement.DAOProjetoImp;
import dao.implement.DAOUsuarioImp;
import dao.interfaces.DAOAdministrador;
import dao.interfaces.DAOAvaliador;
import dao.interfaces.DAOProfessor;
import dao.interfaces.DAOProjeto;
import dao.interfaces.DAOUsuario;

public class DAOFactory {
  
  private static EntityManagerFactory factory;

  private static void createFactory() {
    if (factory == null) {
      factory = Persistence.createEntityManagerFactory("sistema-core");
    }
  }
  
  public static DAOUsuario createDAOUsuario() {
    createFactory();
    return new DAOUsuarioImp(factory);
  }
  
  public static DAOAdministrador createDAOAdministrador() {
    createFactory();
    return new DAOAdministradorImp(factory);
  }
  
  public static DAOProfessor createDAOProfessor() {
    createFactory();
    return new DAOProfessorImp(factory);
  }
  
  public static DAOProjeto createDAOProjeto() {
    createFactory();
    return new DAOProjetoImp(factory);
  }
  
  public static DAOAvaliador createDAOAvaliador() {
  	createFactory();
  	return new DAOAvaliadorImp(factory);
  }
}
