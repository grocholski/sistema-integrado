package dao.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="avaliador", catalog="integrados3")
public class TBAvaliador {

  @Id
  @GenericGenerator(name = "generator", strategy = "foreign", 
  parameters = @Parameter(name = "property", value = "usuario"))
  @GeneratedValue(generator = "generator")
  @Column(name="idusuario", unique = true, nullable = false)
  private Integer idusuario;
  
  @Column(nullable=false)
  private String nome;
  
  @Column(nullable=false)
  private String atuacao;
  
  @Column(nullable=false)
  private String formacao;
  
  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
  private TBUsuario usuario;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.avaliador")
  private List<TBAvaliaProjeto> projetos = new ArrayList<TBAvaliaProjeto>();

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

  public TBUsuario getUsuario() {
    return usuario;
  }

  public void setUsuario(TBUsuario usuario) {
    this.usuario = usuario;
  }

  public List<TBAvaliaProjeto> getProjetos() {
    return projetos;
  }

  public void setProjetos(List<TBAvaliaProjeto> projetos) {
    this.projetos = projetos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((atuacao == null) ? 0 : atuacao.hashCode());
    result = prime * result + ((formacao == null) ? 0 : formacao.hashCode());
    result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
    TBAvaliador other = (TBAvaliador) obj;
    if (atuacao == null) {
      if (other.atuacao != null)
        return false;
    } else if (!atuacao.equals(other.atuacao))
      return false;
    if (formacao == null) {
      if (other.formacao != null)
        return false;
    } else if (!formacao.equals(other.formacao))
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
