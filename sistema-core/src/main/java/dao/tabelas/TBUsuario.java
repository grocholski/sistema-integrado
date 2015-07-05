package dao.tabelas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", catalog = "integrados3")
public class TBUsuario implements Serializable {
	
  private static final long serialVersionUID = 5582683502571197651L;

  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario", unique=true, nullable=false)
	private Integer idusuario;

  @Column(unique = true)
	private String email;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private Integer papel;

	@Column(nullable=false)
	private String senha;

	@Column(nullable=false)
	private Integer situacao;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private TBAdministrador administrador;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
  private TBAluno aluno;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
  private TBProfessor professor;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
  private TBAvaliador avaliador;
	
	@OneToMany(mappedBy = "usuario")
  private List<TBComentario> comentarios = new ArrayList<TBComentario>();

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getPapel() {
    return papel;
  }

  public void setPapel(Integer papel) {
    this.papel = papel;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Integer getSituacao() {
    return situacao;
  }

  public void setSituacao(Integer situacao) {
    this.situacao = situacao;
  }

  public TBAdministrador getAdministrador() {
    return administrador;
  }

  public void setAdministrador(TBAdministrador administrador) {
    this.administrador = administrador;
  }

  public TBAluno getAluno() {
    return aluno;
  }

  public void setAluno(TBAluno aluno) {
    this.aluno = aluno;
  }

  public TBProfessor getProfessor() {
    return professor;
  }

  public void setProfessor(TBProfessor professor) {
    this.professor = professor;
  }

  public TBAvaliador getAvaliador() {
    return avaliador;
  }

  public void setAvaliador(TBAvaliador avaliador) {
    this.avaliador = avaliador;
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
        + ((administrador == null) ? 0 : administrador.hashCode());
    result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
    result = prime * result + ((avaliador == null) ? 0 : avaliador.hashCode());
    result = prime * result
        + ((comentarios == null) ? 0 : comentarios.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((papel == null) ? 0 : papel.hashCode());
    result = prime * result + ((professor == null) ? 0 : professor.hashCode());
    result = prime * result + ((senha == null) ? 0 : senha.hashCode());
    result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
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
    TBUsuario other = (TBUsuario) obj;
    if (administrador == null) {
      if (other.administrador != null)
        return false;
    } else if (!administrador.equals(other.administrador))
      return false;
    if (aluno == null) {
      if (other.aluno != null)
        return false;
    } else if (!aluno.equals(other.aluno))
      return false;
    if (avaliador == null) {
      if (other.avaliador != null)
        return false;
    } else if (!avaliador.equals(other.avaliador))
      return false;
    if (comentarios == null) {
      if (other.comentarios != null)
        return false;
    } else if (!comentarios.equals(other.comentarios))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
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
    if (papel == null) {
      if (other.papel != null)
        return false;
    } else if (!papel.equals(other.papel))
      return false;
    if (professor == null) {
      if (other.professor != null)
        return false;
    } else if (!professor.equals(other.professor))
      return false;
    if (senha == null) {
      if (other.senha != null)
        return false;
    } else if (!senha.equals(other.senha))
      return false;
    if (situacao == null) {
      if (other.situacao != null)
        return false;
    } else if (!situacao.equals(other.situacao))
      return false;
    return true;
  }
}