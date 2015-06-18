package dao.tabelas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idprojeto", nullable = false)
  private TBProjeto projeto;
  
  @Column(nullable=false)
  private Integer quadro;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idusuario", nullable = false)
  private TBUsuario usuario;
  
  @Column(nullable=false)
  private String comentario;

}
