package controller.util;

import controller.main.ControllerMain;
import controller.professor.ControllerProfessor;
import view.principal.WindowMain;
import view.professor.ViewCadastrarProfessor;
import view.professor.ViewEditarProfessor;

public class ControllerFactory {
  
  private static ControllerMain contMain;
  private static ControllerProfessor contProf;
  
  public static ControllerMain createControllerMain(WindowMain p) {
    if (contMain == null) {
      contMain = new ControllerMain(p);
    }
    return contMain;
  }
  
  public static ControllerProfessor createControllerProfessor(ViewCadastrarProfessor c) {
    if (contProf == null) {
      contProf = new ControllerProfessor();
    }
    contProf.setP1(c);
    return contProf;
  }
  
  public static ControllerProfessor createControllerProfessor(ViewEditarProfessor c) {
    if (contProf == null) {
      contProf = new ControllerProfessor();
    }
    contProf.setP2(c);
    return contProf;
  }

}
