package model.entidades;

public class Aluno extends Usuario {
  
  private String curso;
  
  private String campus;
  
  private Integer periodo;

  public Aluno() {
    super();
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  public Integer getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Integer periodo) {
    this.periodo = periodo;
  }
}
