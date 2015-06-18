package model.util;

import model.entidades.Usuario;
import dao.factory.DAOFactory;
import dao.interfaces.DAOUsuario;
import dao.tabelas.TBUsuario;

public class Sessao {
  
  private DAOUsuario daoUsuario = DAOFactory.createDAOUsuario();
  
  private Usuario usuario;
  private boolean logado = false;
  private Integer papel = 0;
  
  public void alterarSituacao() {
    daoUsuario.alterarSituacao(usuario.getId(), usuario.getSituacao());
  }
  
  public boolean verificarLogin(String email, String senha) {
    TBUsuario tbUsuario = daoUsuario.verificarLog(email, senha);
    if (tbUsuario != null) {
      if (tbUsuario.getSituacao() == 2) {
        criarSessao(tbUsuario);
        return true;
      }
    }
    return false;
  }
  
  private void criarSessao(TBUsuario tbUsuario) {
    papel = tbUsuario.getPapel();
    logado = true;
    
    switch (papel) {
    case 1:
      usuario = Conversor.toAdministrador(tbUsuario.getAdministrador());
      break;
    case 3:
      usuario = Conversor.toProfessor(tbUsuario.getProfessor());
      break;
    case 4:
      usuario = Conversor.toAvaliador(tbUsuario.getAvaliador());
      break;
    }
  }
  
  public void terminarSessao() {
    usuario = null;
    logado = false;
    papel = 0;
  }

  public boolean isLogado() {
    return logado;
  }
  
  public Integer getPapel() {
    return papel;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
