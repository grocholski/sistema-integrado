package teste;

import java.math.BigDecimal;

import dao.factory.DAOFactory;
import dao.interfaces.DAOProjeto;
import dao.tabelas.AvaliaProjetoId;
import dao.tabelas.TBAvaliaProjeto;
import dao.tabelas.TBAvaliador;
import dao.tabelas.TBProjeto;

public class AppTesteProjetoAvaliador {

  public static void main(String[] args) {
    
//    EntityManagerFactory fac = Persistence.createEntityManagerFactory("sistema-core");
//    EntityManager man = fac.createEntityManager();

    TBProjeto pj;
    TBAvaliador av;
    TBAvaliaProjeto av_pj = new TBAvaliaProjeto();
    av_pj.setPk(new AvaliaProjetoId());
    av_pj.getPk().setQuadro(5); //****
    av_pj.setNota(BigDecimal.valueOf(10));
    
    DAOProjeto dao = DAOFactory.createDAOProjeto();
    System.out.println(dao.buscarPorAvaliador(6).size());
    
    //System.out.println(pj.getMembros().get(0).getCampus());
    
    //man.getTransaction().begin();
    //pj = man.find(TBProjeto.class, 1);
    //av = man.find(TBAvaliador.class, 6);
    //man.getTransaction().commit();
    
//    pj.getAvaliaProjeto().get(0);// isso faz funcionar !!!!?
//    
//    av_pj.setAvaliador(av);
//    av_pj.setProjeto(pj);
//    pj.getAvaliaProjeto().add(av_pj);
//    
//    man.getTransaction().begin();
//    man.merge(pj);
//    man.getTransaction().commit();
    
    //man.persist(av_pj);
    
    
    //System.out.println(pj.getAvaliaProjeto().get(0).getAvaliador().getAtuacao());// isso faz funcionar !!!!?
    //man.close();
    //fac.close();
    
    //man = fac.createEntityManager();
    
    //System.out.println(pj.getAvaliaProjeto().get(0).getAvaliador().getAtuacao());// isso faz funcionar !!!!?
    System.exit(1);
  }

}
