package model.util;

import model.entidades.Administrador;
import model.entidades.Aluno;
import model.entidades.Avaliador;
import model.entidades.Professor;
import model.entidades.Projeto;
import model.entidades.Resposta;
import dao.tabelas.TBAdministrador;
import dao.tabelas.TBAluno;
import dao.tabelas.TBAvaliador;
import dao.tabelas.TBProfessor;
import dao.tabelas.TBProjeto;
import dao.tabelas.TBResposta;
import dao.tabelas.TBUsuario;

public class Conversor {

  public static Administrador toAdministrador(TBAdministrador tbAdm) {
    Administrador adm = null;
    if (tbAdm != null) {
      adm = new Administrador();
      adm.setId(tbAdm.getIdusuario());
      adm.setNome(tbAdm.getUsuario().getNome());
      adm.setEmail(tbAdm.getUsuario().getEmail());
      adm.setPapel(tbAdm.getUsuario().getPapel());
      adm.setSenha(tbAdm.getUsuario().getSenha());
      adm.setSituacao(tbAdm.getUsuario().getSituacao());
    }
    return adm;
  }

  public static TBAdministrador toTBAdministrador(Administrador adm) {
    TBAdministrador tbAdm = new TBAdministrador();
    tbAdm.setUsuario(new TBUsuario());
    if (adm.getId() != null) {
      tbAdm.setIdusuario(adm.getId());
      tbAdm.getUsuario().setIdusuario(adm.getId());
    }
    tbAdm.getUsuario().setNome(adm.getNome());
    tbAdm.getUsuario().setEmail(adm.getEmail());
    tbAdm.getUsuario().setPapel(adm.getPapel());
    tbAdm.getUsuario().setSenha(adm.getSenha());
    tbAdm.getUsuario().setSituacao(adm.getSituacao());
    return tbAdm;
  }

  public static Projeto toProjeto(TBProjeto tbProj) {
    Projeto proj = null;
    if (tbProj != null) {
      proj = new Projeto();
      proj.setIdprojeto(tbProj.getIdprojeto());
      proj.setTitulo(tbProj.getTitulo());
      proj.setDescricao(tbProj.getDescricao());
      proj.setSituacao(tbProj.getSituacao());
      proj.setLider(Conversor.toAluno(tbProj.getLider()));
      proj.setOrientador(Conversor.toProfessor(tbProj.getOrientador()));  
      for (TBAluno tbAl : tbProj.getMembros()) {
        proj.getMembros().add(Conversor.toAluno(tbAl));
      }
      for (TBResposta tbResp : tbProj.getRespostas()) {
        proj.getRespostas().add(Conversor.toResposta(tbResp));
      }
    }
    return proj;
  }

  public static TBProjeto toTBProjeto(Projeto proj) {
    TBProjeto tbProj = new TBProjeto();
    TBAluno tbLider = Conversor.toTBAluno(proj.getLider());
    TBProfessor tbOrient = Conversor.toTBProfessor(proj.getOrientador());
    if (proj.getIdprojeto() != null) {
      tbProj.setIdprojeto(proj.getIdprojeto());
    }
    tbProj.setTitulo(proj.getTitulo());
    tbProj.setDescricao(proj.getDescricao());
    tbProj.setSituacao(proj.getSituacao());
    tbProj.setLider(tbLider);
    tbProj.setOrientador(tbOrient);
    for (Aluno al : proj.getMembros()) {
      tbProj.getMembros().add(Conversor.toTBAluno(al));
    }
    for (TBResposta tbResp : tbProj.getRespostas()) {
      proj.getRespostas().add(Conversor.toResposta(tbResp));
    }
    return tbProj;
  }

  public static Aluno toAluno(TBAluno tbAl) {
    Aluno al = null;
    if (tbAl != null) {
      al = new Aluno();
      al.setId(tbAl.getIdusuario());
      al.setNome(tbAl.getUsuario().getNome());
      al.setEmail(tbAl.getUsuario().getEmail());
      al.setPapel(tbAl.getUsuario().getPapel());
      al.setSenha(tbAl.getUsuario().getSenha());
      al.setSituacao(tbAl.getUsuario().getSituacao());
      al.setIsLider(tbAl.getIsLider());
      al.setCampus(tbAl.getCampus());
      al.setCurso(tbAl.getCurso());
      al.setPeriodo(tbAl.getPeriodo());
    }
    return al;
  }

  public static TBAluno toTBAluno(Aluno tbAl) {
    TBAluno al = new TBAluno();
    al.setUsuario(new TBUsuario());
    if (tbAl.getId() != null) {
      al.setIdusuario(tbAl.getId());
      al.setUsuario(new TBUsuario());
      al.getUsuario().setIdusuario(tbAl.getId());
    }
    al.getUsuario().setNome(tbAl.getNome());
    al.getUsuario().setEmail(tbAl.getEmail());
    al.getUsuario().setPapel(tbAl.getPapel());
    al.getUsuario().setSenha(tbAl.getSenha());
    al.getUsuario().setSituacao(tbAl.getSituacao());
    al.setCampus(tbAl.getCampus());
    al.setCurso(tbAl.getCurso());
    al.setPeriodo(tbAl.getPeriodo());
    al.setIsLider(tbAl.getIsLider());
    return al;
  }

  public static Avaliador toAvaliador(TBAvaliador tbAl) {
    Avaliador al = null;
    if (tbAl != null) {
      al = new Avaliador();
      al.setId(tbAl.getIdusuario());
      al.setNome(tbAl.getUsuario().getNome());
      al.setEmail(tbAl.getUsuario().getEmail());
      al.setPapel(tbAl.getUsuario().getPapel());
      al.setSenha(tbAl.getUsuario().getSenha());
      al.setSituacao(tbAl.getUsuario().getSituacao());
      al.setFormacao(tbAl.getFormacao());
      al.setAtuacao(tbAl.getFormacao());
    }
    return al;
  }

  public static TBAvaliador toTBAvaliador(Avaliador tbAl) {
    TBAvaliador al = new TBAvaliador();
    al.setUsuario(new TBUsuario());
    if (tbAl.getId() != null) {
      al.setIdusuario(tbAl.getId());
      al.getUsuario().setIdusuario(tbAl.getId());
    }
    al.getUsuario().setNome(tbAl.getNome());
    al.getUsuario().setEmail(tbAl.getEmail());
    al.getUsuario().setPapel(tbAl.getPapel());
    al.getUsuario().setSenha(tbAl.getSenha());
    al.getUsuario().setSituacao(tbAl.getSituacao());
    al.setFormacao(tbAl.getFormacao());
    al.setAtuacao(tbAl.getFormacao());
    return al;
  }

  public static Professor toProfessor(TBProfessor tbAl) {
    Professor al = null;
    if (tbAl != null) {
      al = new Professor();
      al.setId(tbAl.getIdusuario());
      al.setNome(tbAl.getUsuario().getNome());
      al.setEmail(tbAl.getUsuario().getEmail());
      al.setPapel(tbAl.getUsuario().getPapel());
      al.setSenha(tbAl.getUsuario().getSenha());
      al.setSituacao(tbAl.getUsuario().getSituacao());
      al.setDepartamento(tbAl.getDepartamento());
      al.setDisciplinaPrincipal(tbAl.getDisciplinaPrincipal());
    }
    return al;
  }

  public static TBProfessor toTBProfessor(Professor tbAl) {
    TBProfessor al = new TBProfessor();
    al.setUsuario(new TBUsuario());
    if (tbAl.getId() != null) {
      al.setIdusuario(tbAl.getId());
      al.getUsuario().setIdusuario(tbAl.getId());
    }
    al.getUsuario().setNome(tbAl.getNome());
    al.getUsuario().setEmail(tbAl.getEmail());
    al.getUsuario().setPapel(tbAl.getPapel());
    al.getUsuario().setSenha(tbAl.getSenha());
    al.getUsuario().setSituacao(tbAl.getSituacao());
    al.setDepartamento(tbAl.getDepartamento());
    al.setDisciplinaPrincipal(tbAl.getDisciplinaPrincipal());
    return al;
  }

  public static Resposta toResposta(TBResposta tbResp) {
    Resposta resp = null;
    if (tbResp != null) {
      resp = new Resposta();
      resp.setIdresposta(tbResp.getIdresposta());
      resp.setProjeto(tbResp.getProjeto().getIdprojeto());
      resp.setQuadro(tbResp.getQuadro());
      resp.setPergunta(tbResp.getPergunta());
      resp.setResposta(tbResp.getResposta());
    }
    return resp;
  }
  
  public static TBResposta toTBResposta(Resposta resp) {
    TBResposta tResp = new TBResposta();
    tResp.setProjeto(new TBProjeto());
    if (resp.getIdresposta() != null) {
      tResp.setIdresposta(resp.getIdresposta());
    }
    tResp.getProjeto().setIdprojeto(resp.getProjeto());
    tResp.setQuadro(resp.getQuadro());
    tResp.setPergunta(resp.getPergunta());
    tResp.setResposta(resp.getResposta());
    return tResp;
  }

}
