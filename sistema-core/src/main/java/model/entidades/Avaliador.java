package model.entidades;

public class Avaliador extends Usuario {
    
  private String atuacao;
  
  private String formacao;

  public String getAtuacao() {
    return atuacao;
  }
  public void setAtuacao(String atuacao) {
    this.atuacao = atuacao;
  }
  public String getFormacao() {
    return formacao;
  }
  public void setFormacao(String formacao) {
    this.formacao = formacao;
  }
}
