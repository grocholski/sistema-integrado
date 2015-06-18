package dao.tabelas;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AvaliaProjetoId implements Serializable {
  
  private static final long serialVersionUID = 3965535570536729788L;

  private Integer quadro;
  
  @ManyToOne
  private TBProjeto projeto;
  
  @ManyToOne
  private TBAvaliador avaliador;

  public AvaliaProjetoId() {
  }
  
  public TBProjeto getProjeto() {
    return projeto;
  }
  public void setProjeto(TBProjeto projeto) {
    this.projeto = projeto;
  }
  public TBAvaliador getAvaliador() {
    return avaliador;
  }
  public void setAvaliador(TBAvaliador avaliador) {
    this.avaliador = avaliador;
  } 
  public Integer getQuadro() {
    return quadro;
  }
  public void setQuadro(Integer quadro) {
    this.quadro = quadro;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((avaliador == null) ? 0 : avaliador.hashCode());
    result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
    result = prime * result + ((quadro == null) ? 0 : quadro.hashCode());
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
    AvaliaProjetoId other = (AvaliaProjetoId) obj;
    if (avaliador == null) {
      if (other.avaliador != null)
        return false;
    } else if (!avaliador.equals(other.avaliador))
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
    return true;
  }
}
