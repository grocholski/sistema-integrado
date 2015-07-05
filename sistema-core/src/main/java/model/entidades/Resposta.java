package model.entidades;

public class Resposta {

  private Integer idresposta;
  
  private String resposta;
  
  private Integer quadro;
  
  private Integer pergunta;
  
  private Integer projeto;

  public Integer getIdresposta() {
    return idresposta;
  }

  public void setIdresposta(Integer idresposta) {
    this.idresposta = idresposta;
  }

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  public Integer getQuadro() {
    return quadro;
  }

  public void setQuadro(Integer quadro) {
    this.quadro = quadro;
  }

  public Integer getPergunta() {
    return pergunta;
  }

  public void setPergunta(Integer pergunta) {
    this.pergunta = pergunta;
  }

  public Integer getProjeto() {
    return projeto;
  }

  public void setProjeto(Integer projeto) {
    this.projeto = projeto;
  }
  
}
