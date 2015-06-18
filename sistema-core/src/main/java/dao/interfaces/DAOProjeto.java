package dao.interfaces;

import java.util.List;

import dao.tabelas.TBProjeto;

public interface DAOProjeto extends DAOGeneric<TBProjeto> {

  // modificar este???????????
  public List<TBProjeto> buscarPorSituacao(Integer s);
  
  // modificar este???????????
  // passar TBAvaliador (objeto)?????
  public List<TBProjeto> buscarPorAvaliador(Integer idavaliador);
  
  // buscar projeto ponto de vista: aluno
  // retorna: projeto + membros + respostas + comentarios
  public TBProjeto buscarProjetoAluno(Integer idprojeto);
  
  // buscar projeto ponto de vista: avaliador
  // retorna projeto + respostas + avaliacao
  public TBProjeto buscarProjetoAvaliador(Integer idprojeto, Integer idavaliador);
  
  // buscar projeto ponto de vista: administrador
  // acho q nao sera necessario
  public TBProjeto buscarProjetoAdministrador(Integer idprojeto);
  
}
