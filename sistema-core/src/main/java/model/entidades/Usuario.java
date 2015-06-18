package model.entidades;

public abstract class Usuario {
  
  private Integer id;

  private String nome;
  
  private String email;
  
  private String senha;
  
  private Integer papel;
  
  private Integer situacao;
  
  public Usuario() {
    this.id = null;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
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
  public Integer getPapel() {
    return papel;
  }
  public void setPapel(Integer papel) {
    this.papel = papel;
  }
  public Integer getSituacao() {
    return situacao;
  }
  public void setSituacao(Integer situacao) {
    this.situacao = situacao;
  }
}
