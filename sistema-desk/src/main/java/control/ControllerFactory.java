package control;

import control.professor.CTProfessor;
import view.principal.VWPrincipal;
import view.professor.CadastrarProfessor;
import view.professor.EditarProfessor;

public class ControllerFactory {
  
  private static JFrameController jc;
  private static CTProfessor pc;
  
  public static JFrameController createJFrameController(VWPrincipal p) {
    if (jc == null) {
      jc = new JFrameController(p);
    }
    return jc;
  }
  
  public static CTProfessor createCtProfessor(CadastrarProfessor c) {
    if (pc == null) {
      pc = new CTProfessor();
    }
    pc.setP1(c);
    return pc;
  }
  
  public static CTProfessor createCtProfessor(EditarProfessor c) {
    if (pc == null) {
      pc = new CTProfessor();
    }
    pc.setP2(c);
    return pc;
  }

}
