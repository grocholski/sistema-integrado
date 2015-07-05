package dao.tabelas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="resposta", catalog="integrados3")
public class TBResposta {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idresposta;
  
  @ManyToOne
  @JoinColumn(name = "idprojeto", nullable = false)
  private TBProjeto projeto;
  
  @Column(nullable=false)
  private Integer quadro;
  
  @Column(nullable=false)
  private Integer pergunta;
  
  @Column(nullable=false)
  private String resposta;

  public Integer getIdresposta() {
    return idresposta;
  }

  public void setIdresposta(Integer idresposta) {
    this.idresposta = idresposta;
  }

  public TBProjeto getProjeto() {
    return projeto;
  }

  public void setProjeto(TBProjeto projeto) {
    this.projeto = projeto;
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

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((idresposta == null) ? 0 : idresposta.hashCode());
    result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
    result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
    result = prime * result + ((quadro == null) ? 0 : quadro.hashCode());
    result = prime * result + ((resposta == null) ? 0 : resposta.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TBResposta other = (TBResposta) obj;
    if (idresposta == null) {
      if (other.idresposta != null)
        return false;
    } else if (!idresposta.equals(other.idresposta))
      return false;
    if (pergunta == null) {
      if (other.pergunta != null)
        return false;
    } else if (!pergunta.equals(other.pergunta))
      return false;
    if (projeto == null) {
      if (other.projeto != null)
        return false;
    } else if (!projeto.equals(other.projeto))
      return false;
    if (quadro == null) {
      if (other.quadro != null)
        return false;
    } else if (!quadro.equals(other.quadro))
      return false;
    if (resposta == null) {
      if (other.resposta != null)
        return false;
    } else if (!resposta.equals(other.resposta))
      return false;
    return true;
  }
  
}
