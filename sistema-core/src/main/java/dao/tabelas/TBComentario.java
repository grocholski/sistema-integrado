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
@Table(name="comentario", catalog="integrados3")
public class TBComentario {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idcomentario;
  
  @ManyToOne
  @JoinColumn(name = "idprojeto", nullable = false)
  private TBProjeto projeto;
  
  @Column(nullable=false)
  private Integer quadro;
  
  @ManyToOne
  @JoinColumn(name = "idusuario", nullable = false)
  private TBUsuario usuario;
  
  @Column(nullable=false)
  private String comentario;

  public Integer getIdcomentario() {
    return idcomentario;
  }

  public void setIdcomentario(Integer idcomentario) {
    this.idcomentario = idcomentario;
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

  public TBUsuario getUsuario() {
    return usuario;
  }

  public void setUsuario(TBUsuario usuario) {
    this.usuario = usuario;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((comentario == null) ? 0 : comentario.hashCode());
    result = prime * result
        + ((idcomentario == null) ? 0 : idcomentario.hashCode());
    result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
    result = prime * result + ((quadro == null) ? 0 : quadro.hashCode());
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
    TBComentario other = (TBComentario) obj;
    if (comentario == null) {
      if (other.comentario != null)
        return false;
    } else if (!comentario.equals(other.comentario))
      return false;
    if (idcomentario == null) {
      if (other.idcomentario != null)
        return false;
    } else if (!idcomentario.equals(other.idcomentario))
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
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    return true;
  }
}
