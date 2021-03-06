package model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
  
  private Integer idprojeto;
  
  private String titulo;
  
  private String descricao;
  
  private Integer situacao;
  
  private Aluno lider;
  
  private Professor orientador;
  
  private List<Aluno> membros;
  
  private List<Resposta> respostas;
  
  public Projeto() {
    idprojeto = null;
    membros = new ArrayList<Aluno>();
  }
  
  public Integer getIdprojeto() {
    return idprojeto;
  }
  
  
  public void setIdprojeto(Integer idprojeto) {
    this.idprojeto = idprojeto;
  }
  
  public String getTitulo() {
    return titulo;
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  public String getDescricao() {
    return descricao;
  }
  
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  public Integer getSituacao() {
    return situacao;
  }
  
  public void setSituacao(Integer situacao) {
    this.situacao = situacao;
  }
  
  public Aluno getLider() {
    return lider;
  }
  
  public void setLider(Aluno lider) {
    this.lider = lider;
  }
  
  public Professor getOrientador() {
    return orientador;
  }
  
  public void setOrientador(Professor orientador) {
    this.orientador = orientador;
  }
  
  public List<Aluno> getMembros() {
    return membros;
  }
  
  public void setMembros(List<Aluno> membros) {
    this.membros = membros;
  }

  public List<Resposta> getRespostas() {
    return respostas;
  }
  
  public void setRespostas(List<Resposta> respostas) {
    this.respostas = respostas;
  }
 
}
