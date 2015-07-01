package dao.tabelas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "administrador", catalog = "integrados3")
public class TBAdministrador implements Serializable {

  private static final long serialVersionUID = -6519292267589815747L;
  
  @Id
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "usuario"))
  @GeneratedValue(generator = "generator")
  @Column(name="idusuario", unique = true, nullable = false)
  private Integer idusuario;
  
  @Column(nullable=false)
  private String nome;
  
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private TBUsuario usuario;
  
  public Integer getIdusuario() {
    return idusuario;
  }
  public void setIdusuario(Integer idusuario) {
    this.idusuario = idusuario;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public TBUsuario getUsuario() {
    return usuario;
  }
  public void setUsuario(TBUsuario usuario) {
    this.usuario = usuario;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
    TBAdministrador other = (TBAdministrador) obj;
    if (idusuario == null) {
      if (other.idusuario != null)
        return false;
    } else if (!idusuario.equals(other.idusuario))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    return true;
  }
}
