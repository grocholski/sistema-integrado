package model.util;

import model.entidades.Administrador;
import model.entidades.Aluno;
import model.entidades.Avaliador;
import model.entidades.Comentario;
import model.entidades.Professor;
import model.entidades.Projeto;
import model.entidades.Resposta;
import dao.tabelas.TBAdministrador;
import dao.tabelas.TBAluno;
import dao.tabelas.TBAvaliaProjeto;
import dao.tabelas.TBAvaliador;
import dao.tabelas.TBComentario;
import dao.tabelas.TBProfessor;
import dao.tabelas.TBProjeto;
import dao.tabelas.TBResposta;
import dao.tabelas.TBUsuario;

public class Conversor {

  public static Administrador toAdministrador(TBAdministrador tbAdm) {
    Administrador adm = new Administrador();

    adm.setId(tbAdm.getIdusuario());
    adm.setNome(tbAdm.getNome());
    adm.setEmail(tbAdm.getUsuario().getEmail());
    adm.setPapel(tbAdm.getUsuario().getPapel());
    adm.setSenha(tbAdm.getUsuario().getSenha());
    adm.setSituacao(tbAdm.getUsuario().getSituacao());

    return adm;
  }

  public static TBAdministrador toTBAdministrador(Administrador adm) {
    TBAdministrador tbAdm = new TBAdministrador();
    TBUsuario tbUs = new TBUsuario();

    if (adm.getId() != null) {
      tbAdm.setIdusuario(adm.getId());
      tbUs.setIdusuario(adm.getId());
    }
    tbAdm.setNome(adm.getNome());
    tbUs.setEmail(adm.getEmail());
    tbUs.setPapel(adm.getPapel());
    tbUs.setSenha(adm.getSenha());
    tbUs.setSituacao(adm.getSituacao());
    tbAdm.setUsuario(tbUs);

    return tbAdm;
  }

  public static Projeto toProjeto(TBProjeto tbProj) {
    Projeto proj = new Projeto();

    proj.setIdprojeto(tbProj.getIdprojeto());
    proj.setTitulo(tbProj.getTitulo());
    proj.setDescricao(tbProj.getDescricao());
    proj.setSituacao(tbProj.getSituacao());
    proj.setLider(Conversor.toAluno(tbProj.getLider()));
    //proj.setOrientador(Conversor.toProfessor(tbProj.getOrientador()));
    for (TBAluno tbAl : tbProj.getMembros()) {
      proj.getMembros().add(Conversor.toAluno(tbAl));
    }
    for (TBAvaliaProjeto tbAPj: tbProj.getAvaliaProjeto()) {
      TBAvaliador tbAv = tbAPj.getAvaliador();
      proj.getAvaliadores().add(Conversor.toAvaliador(tbAv));
    }
    /*for (TBResposta tbResp : tbProj.getRespostas()) {
      proj.getRespostas().add(Conversor.toResposta(tbResp));
    }
    for (TBComentario tbCom : tbProj.getComentarios()) {
      proj.getComentarios().add(Conversor.toComentario(tbCom));
    }*/
    
    return proj;
  }

  public static TBProjeto toTBProjeto(Projeto proj) {
    TBProjeto tbProj = new TBProjeto();
    TBAluno lider = Conversor.toTBAluno(proj.getLider());
    TBProfessor orient = Conversor.toTBProfessor(proj.getOrientador());
    
    if (proj.getIdprojeto() != null) {
      tbProj.setIdprojeto(proj.getIdprojeto());
    }
    tbProj.setTitulo(proj.getTitulo());
    tbProj.setDescricao(proj.getDescricao());
    tbProj.setSituacao(proj.getSituacao());
    tbProj.setLider(lider);
    tbProj.setOrientador(orient);
    for (Aluno al : proj.getMembros()) {
      tbProj.getMembros().add(Conversor.toTBAluno(al));
    }
    for (TBAvaliaProjeto tbAPj: tbProj.getAvaliaProjeto()) {
      TBAvaliador tbAv = tbAPj.getAvaliador();
      proj.getAvaliadores().add(Conversor.toAvaliador(tbAv));
    }
    /*for (TBResposta tbResp : tbProj.getRespostas()) {
      proj.getRespostas().add(Conversor.toResposta(tbResp));
    }
    for (TBComentario tbCom : tbProj.getComentarios()) {
      proj.getComentarios().add(Conversor.toComentario(tbCom));
    }*/
    
    return null;
  }

  public static Aluno toAluno(TBAluno tbAl) {
    Aluno al = new Aluno();
    
    al.setId(tbAl.getIdusuario());
    al.setNome(tbAl.getNome());
    al.setEmail(tbAl.getUsuario().getEmail());
    al.setPapel(tbAl.getUsuario().getPapel());
    al.setSenha(tbAl.getUsuario().getSenha());
    al.setSituacao(tbAl.getUsuario().getSituacao());
    al.setCampus(tbAl.getCampus());
    al.setCurso(tbAl.getCurso());
    al.setPeriodo(tbAl.getPeriodo());
    
    return al;
  }

  public static TBAluno toTBAluno(Aluno tbAl) {
    TBAluno al = new TBAluno();
    
    if (tbAl.getId() != null) {
      al.setIdusuario(tbAl.getId());
      al.getUsuario().setIdusuario(tbAl.getId());
    }
    al.setNome(tbAl.getNome());
    al.getUsuario().setEmail(tbAl.getEmail());
    al.getUsuario().setPapel(tbAl.getPapel());
    al.getUsuario().setSenha(tbAl.getSenha());
    al.getUsuario().setSituacao(tbAl.getSituacao());
    al.setCampus(tbAl.getCampus());
    al.setCurso(tbAl.getCurso());
    al.setPeriodo(tbAl.getPeriodo());
    
    return al;
  }

  public static Avaliador toAvaliador(TBAvaliador tbAl) {
    Avaliador al = new Avaliador();
    
    al.setId(tbAl.getIdusuario());
    al.setNome(tbAl.getNome());
    al.setEmail(tbAl.getUsuario().getEmail());
    al.setPapel(tbAl.getUsuario().getPapel());
    al.setSenha(tbAl.getUsuario().getSenha());
    al.setSituacao(tbAl.getUsuario().getSituacao());
    al.setFormacao(tbAl.getFormacao());
    al.setAtuacao(tbAl.getFormacao());
    
    return al;
  }

  public static TBAvaliador toTBAvaliador(Avaliador tbAl) {
    TBAvaliador al = new TBAvaliador();
    
    if (tbAl.getId() != null) {
      al.setIdusuario(tbAl.getId());
      al.getUsuario().setIdusuario(tbAl.getId());
    }
    al.setNome(tbAl.getNome());
    al.getUsuario().setEmail(tbAl.getEmail());
    al.getUsuario().setPapel(tbAl.getPapel());
    al.getUsuario().setSenha(tbAl.getSenha());
    al.getUsuario().setSituacao(tbAl.getSituacao());
    al.setFormacao(tbAl.getFormacao());
    al.setAtuacao(tbAl.getFormacao());
    
    return al;
  }

  public static Professor toProfessor(TBProfessor tbAl) {
    Professor al = new Professor();
    
    al.setId(tbAl.getIdusuario());
    al.setNome(tbAl.getNome());
    al.setEmail(tbAl.getUsuario().getEmail());
    al.setPapel(tbAl.getUsuario().getPapel());
    al.setSenha(tbAl.getUsuario().getSenha());
    al.setSituacao(tbAl.getUsuario().getSituacao());
    al.setDepartamento(tbAl.getDepartamento());
    al.setDisciplinaPrincipal(tbAl.getDisciplinaPrincipal());
    
    return al;
  }

  public static TBProfessor toTBProfessor(Professor tbAl) {
    TBProfessor al = new TBProfessor();
    al.setUsuario(new TBUsuario());
    
    if (tbAl.getId() != null) {
      al.setIdusuario(tbAl.getId());
      al.getUsuario().setIdusuario(tbAl.getId());
    }
    al.setNome(tbAl.getNome());
    al.getUsuario().setEmail(tbAl.getEmail());
    al.getUsuario().setPapel(tbAl.getPapel());
    al.getUsuario().setSenha(tbAl.getSenha());
    al.getUsuario().setSituacao(tbAl.getSituacao());
    al.setDepartamento(tbAl.getDepartamento());
    al.setDisciplinaPrincipal(tbAl.getDisciplinaPrincipal());
    
    return al;
  }

  public static Resposta toResposta(TBResposta tbResp) {
    return null;
  }
  
  public static TBResposta toTBResposta(Resposta resp) {
    return null;
  }
  
  public static Comentario toComentario(TBComentario tbCom) {
    return null;
  }
  
  public static TBComentario toTBComentario(Comentario com) {
    return null;
  }

}
