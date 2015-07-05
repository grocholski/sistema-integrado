package dao.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="professor", catalog="integrados3")
public class TBProfessor {
  
  @Id
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "usuario"))
  @GeneratedValue(generator = "generator")
  @Column(name="idusuario", unique = true, nullable = false)
  private Integer idusuario;
  
  private String disciplinaPrincipal;
  
  private String departamento;
  
  @OneToOne(cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private TBUsuario usuario;

  @OneToMany(mappedBy = "orientador")
  private List<TBProjeto> projetos = new ArrayList<TBProjeto>();
  
  public Integer getIdusuario() {
    return idusuario;
  }

  public void setIdusuario(Integer idusuario) {
    this.idusuario = idusuario;
  }

  public String getDisciplinaPrincipal() {
    return disciplinaPrincipal;
  }

  public void setDisciplinaPrincipal(String disciplinaPrincipal) {
    this.disciplinaPrincipal = disciplinaPrincipal;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public TBUsuario getUsuario() {
    return usuario;
  }

  public void setUsuario(TBUsuario usuario) {
    this.usuario = usuario;
  }

  public List<TBProjeto> getProjetos() {
    return projetos;
  }

  public void setProjetos(List<TBProjeto> projetos) {
    this.projetos = projetos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((departamento == null) ? 0 : departamento.hashCode());
    result = prime * result
        + ((disciplinaPrincipal == null) ? 0 : disciplinaPrincipal.hashCode());
    result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
    result = prime * result + ((projetos == null) ? 0 : projetos.hashCode());
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
    TBProfessor other = (TBProfessor) obj;
    if (departamento == null) {
      if (other.departamento != null)
        return false;
    } else if (!departamento.equals(other.departamento))
      return false;
    if (disciplinaPrincipal == null) {
      if (other.disciplinaPrincipal != null)
        return false;
    } else if (!disciplinaPrincipal.equals(other.disciplinaPrincipal))
      return false;
    if (idusuario == null) {
      if (other.idusuario != null)
        return false;
    } else if (!idusuario.equals(other.idusuario))
      return false;
    if (projetos == null) {
      if (other.projetos != null)
        return false;
    } else if (!projetos.equals(other.projetos))
      return false;
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    return true;
  }
}
