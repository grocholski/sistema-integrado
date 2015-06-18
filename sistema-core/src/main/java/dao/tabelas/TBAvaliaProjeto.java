package dao.tabelas;

import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="avalia_projeto", catalog="integrados3")
@AssociationOverrides({
  @AssociationOverride(name = "pk.projeto", 
    joinColumns = @JoinColumn(name = "idprojeto")),
  @AssociationOverride(name = "pk.avaliador",
    joinColumns = @JoinColumn(name = "idusuario")) })
public class TBAvaliaProjeto {

  @EmbeddedId
  private AvaliaProjetoId pk = new AvaliaProjetoId();
  
  // pode ser nulo inicialmente
  @Column
  private BigDecimal nota;
  
  @Transient
  public TBProjeto getProjeto() {
    return pk.getProjeto();
  }
  
  public void setProjeto(TBProjeto projeto) {
    pk.setProjeto(projeto);
  }
  
  @Transient
  public TBAvaliador getAvaliador() {
    return pk.getAvaliador();
  }
  
  public void setAvaliador(TBAvaliador avaliador) {
    pk.setAvaliador(avaliador);
  }

  public AvaliaProjetoId getPk() {
    return pk;
  }

  public void setPk(AvaliaProjetoId pk) {
    this.pk = pk;
  }

  public BigDecimal getNota() {
    return nota;
  }

  public void setNota(BigDecimal nota) {
    this.nota = nota;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
    TBAvaliaProjeto other = (TBAvaliaProjeto) obj;
    if (pk == null) {
      if (other.pk != null)
        return false;
    } else if (!pk.equals(other.pk))
      return false;
    return true;
  }
}
