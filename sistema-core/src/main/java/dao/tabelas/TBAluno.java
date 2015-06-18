package dao.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="aluno", catalog="integrados3")
public class TBAluno {

  @Id
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "usuario"))
  @GeneratedValue(generator = "generator")
  @Column(name="idusuario", unique = true, nullable = false)
  private Integer idusuario;
  
  @Column(nullable=false)
  private String nome;
  
  @Column(nullable=false)
  private String curso;
  
  @Column(nullable=false)
  private Integer periodo;
  
  @Column(nullable=false)
  private String campus;
  
  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
  private TBUsuario usuario;
  
  /*
   * Aluno pode ser lider de varios projetos. Mas durante a aplicacao
   * sera lider de um projeto ativo por vez.
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "lider")
  private List<TBProjeto> projetosLider = new ArrayList<TBProjeto>(0);
  
  // remover???????????????
  // a relacao ja esta mantida em projeto
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "membros")
  private List<TBProjeto> projetosMembro = new ArrayList<TBProjeto>(0);

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
  public String getCurso() {
    return curso;
  }
  public void setCurso(String curso) {
    this.curso = curso;
  }
  public Integer getPeriodo() {
    return periodo;
  }
  public void setPeriodo(Integer periodo) {
    this.periodo = periodo;
  }
  public String getCampus() {
    return campus;
  }
  public void setCampus(String campus) {
    this.campus = campus;
  }
  public TBUsuario getUsuario() {
    return usuario;
  }
  public void setUsuario(TBUsuario usuario) {
    this.usuario = usuario;
  }
  public List<TBProjeto> getProjetosLider() {
    return projetosLider;
  }
  public void setProjetosLider(List<TBProjeto> projetosLider) {
    this.projetosLider = projetosLider;
  }
  public List<TBProjeto> getProjetosMembro() {
    return projetosMembro;
  }
  public void setProjetosMembro(List<TBProjeto> projetosMembro) {
    this.projetosMembro = projetosMembro;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((campus == null) ? 0 : campus.hashCode());
    result = prime * result + ((curso == null) ? 0 : curso.hashCode());
    result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
    result = prime * result
        + ((projetosLider == null) ? 0 : projetosLider.hashCode());
    result = prime * result
        + ((projetosMembro == null) ? 0 : projetosMembro.hashCode());
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
    TBAluno other = (TBAluno) obj;
    if (campus == null) {
      if (other.campus != null)
        return false;
    } else if (!campus.equals(other.campus))
      return false;
    if (curso == null) {
      if (other.curso != null)
        return false;
    } else if (!curso.equals(other.curso))
      return false;
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
    if (periodo == null) {
      if (other.periodo != null)
        return false;
    } else if (!periodo.equals(other.periodo))
      return false;
    if (projetosLider == null) {
      if (other.projetosLider != null)
        return false;
    } else if (!projetosLider.equals(other.projetosLider))
      return false;
    if (projetosMembro == null) {
      if (other.projetosMembro != null)
        return false;
    } else if (!projetosMembro.equals(other.projetosMembro))
      return false;
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    return true;
  }
}