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
@Table(name="resposta", catalog="integrados3")
public class TBResposta {

  /*
   * idealmente, idprojeto + quadro + pergunta = pk
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idresposta;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idprojeto", nullable = false)
  private TBProjeto projeto;
  
  @Column(nullable=false)
  private Integer quadro;
  
  @Column(nullable=false)
  private Integer pergunta;
  
  @Column(nullable=false)
  private String resposta;
  
}
