package model.entidades;

public class Aluno extends Usuario {
  
  private String curso;
  
  private String campus;
  
  private Integer periodo;
  
  private Integer isLider;

  public Aluno() {
    super();
  }
  
  public Integer getIsLider() {
    return isLider;
  }

  public void setIsLider(Integer isLider) {
    this.isLider = isLider;
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
