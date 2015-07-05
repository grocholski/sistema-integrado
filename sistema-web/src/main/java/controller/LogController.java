package controller;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import model.entidades.Aluno;
import model.entidades.Usuario;
import model.rn.RNUsuario;
import web.util.SessionBean;

@ManagedBean(name="log")
public class LogController {
  
  private RNUsuario rnUsuario = new RNUsuario();
  
  private String email;
  private String senha;
  
  // melhorar definicao da sessao
  public String login() {
    Usuario usuario = rnUsuario.login(email, senha);
    
    if (usuario != null) {
      HttpSession session = SessionBean.getSession();
      session.setAttribute("user", usuario);
      session.setAttribute("idusuario", usuario.getId());
      session.setAttribute("papel", usuario.getPapel());
      if (usuario.getPapel() == 2) {
        session.setAttribute("lider", ((Aluno) usuario).getIsLider());
      }
      return "private/home.xhtml?faces-redirect=true";//??
    }
    return null;
  }
  
  public String logout() {
    return null;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getSenha() {
    return senha;
  }
  
  public void setSenha(String senha) {
    this.senha = senha;
  }

}
