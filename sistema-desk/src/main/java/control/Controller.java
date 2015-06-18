package control;

import java.awt.event.ActionListener;

public abstract class Controller {
  
  private ActionListener actionListener;

  protected abstract void createActionListener();
  
  protected void setActionListener(ActionListener actionListener) {
    this.actionListener = actionListener;
  }
  public ActionListener getActionListener() {
    return actionListener;
  }
}
