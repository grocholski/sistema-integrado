package web.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.entidades.Usuario;

public class SessionBean {

  public static HttpSession getSession() {
    return (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(false);
  }

  public static HttpServletRequest getRequest() {
    return (HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest();
  }

  public static String getUserName() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(false);
    return session.getAttribute("username").toString();
  }
  
  public static String getUserId() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(false);
    return session.getAttribute("idusuario").toString();
  }
  
  public static Usuario getUser() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(false);
    return (Usuario) session.getAttribute("user");
  }
  
}
