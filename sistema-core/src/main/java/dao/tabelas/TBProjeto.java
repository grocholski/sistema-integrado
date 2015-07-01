package dao.tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="projeto", catalog="integrados3")
public class TBProjeto {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idprojeto;

  @Column(nullable=false)
  private String titulo;
  
  @Column(nullable=false)
  private String descricao;
  
  @Column(nullable=false)
  private Integer situacao;
  
  @ManyToOne
  @JoinColumn(name = "orientador", nullable = false, updatable = false)
  private TBProfessor orientador;
  
  @ManyToOne
  @JoinColumn(name = "lider", nullable = false, updatable = false)
  private TBAluno lider;
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "membro_projeto", catalog = "integrados3",
      joinColumns = { @JoinColumn(name = "idprojeto", nullable = false, updatable = true) },
      inverseJoinColumns = { @JoinColumn(name = "idusuario", nullable = false, updatable = true) })
  private List<TBAluno> membros = new ArrayList<TBAluno>();
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.projeto", cascade=CascadeType.ALL)
  private List<TBAvaliaProjeto> avaliaprojeto = new ArrayList<TBAvaliaProjeto>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto")
  private List<TBResposta> respostas = new ArrayList<TBResposta>();
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto")
  private List<TBComentario> comentarios = new ArrayList<TBComentario>();

  public Integer getIdprojeto() {
    return idprojeto;
  }

  public void setIdprojeto(Integer idprojeto) {
    this.idprojeto = idprojeto;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getSituacao() {
    return situacao;
  }

  public void setSituacao(Integer situacao) {
    this.situacao = situacao;
  }

  public TBProfessor getOrientador() {
    return orientador;
  }

  public void setOrientador(TBProfessor orientador) {
    this.orientador = orientador;
  }

  public TBAluno getLider() {
    return lider;
  }

  public void setLider(TBAluno lider) {
    this.lider = lider;
  }

  public List<TBAluno> getMembros() {
    return membros;
  }

  public void setMembros(List<TBAluno> membros) {
    this.membros = membros;
  }

  public List<TBAvaliaProjeto> getAvaliaProjeto() {
    return avaliaprojeto;
  }

  public void setAvaliaProjeto(List<TBAvaliaProjeto> avaliaProjeto) {
    this.avaliaprojeto = avaliaProjeto;
  }

  public List<TBResposta> getRespostas() {
    return respostas;
  }

  public void setRespostas(List<TBResposta> respostas) {
    this.respostas = respostas;
  }

  public List<TBComentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(List<TBComentario> comentarios) {
    this.comentarios = comentarios;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((avaliaprojeto == null) ? 0 : avaliaprojeto.hashCode());
    result = prime * result
        + ((comentarios == null) ? 0 : comentarios.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((idprojeto == null) ? 0 : idprojeto.hashCode());
    result = prime * result + ((lider == null) ? 0 : lider.hashCode());
    result = prime * result + ((membros == null) ? 0 : membros.hashCode());
    result = prime * result
        + ((orientador == null) ? 0 : orientador.hashCode());
    result = prime * result + ((respostas == null) ? 0 : respostas.hashCode());
    result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
    result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
    TBProjeto other = (TBProjeto) obj;
    if (avaliaprojeto == null) {
      if (other.avaliaprojeto != null)
        return false;
    } else if (!avaliaprojeto.equals(other.avaliaprojeto))
      return false;
    if (comentarios == null) {
      if (other.comentarios != null)
        return false;
    } else if (!comentarios.equals(other.comentarios))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (idprojeto == null) {
      if (other.idprojeto != null)
        return false;
    } else if (!idprojeto.equals(other.idprojeto))
      return false;
    if (lider == null) {
      if (other.lider != null)
        return false;
    } else if (!lider.equals(other.lider))
      return false;
    if (membros == null) {
      if (other.membros != null)
        return false;
    } else if (!membros.equals(other.membros))
      return false;
    if (orientador == null) {
      if (other.orientador != null)
        return false;
    } else if (!orientador.equals(other.orientador))
      return false;
    if (respostas == null) {
      if (other.respostas != null)
        return false;
    } else if (!respostas.equals(other.respostas))
      return false;
    if (situacao == null) {
      if (other.situacao != null)
        return false;
    } else if (!situacao.equals(other.situacao))
      return false;
    if (titulo == null) {
      if (other.titulo != null)
        return false;
    } else if (!titulo.equals(other.titulo))
      return false;
    return true;
  }
}