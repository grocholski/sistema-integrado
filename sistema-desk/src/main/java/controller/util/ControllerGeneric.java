package controller.util;

import java.awt.event.ActionListener;

public abstract class ControllerGeneric {
  
  private ActionListener actionListener;

  protected abstract void createActionListener();
  
  protected void setActionListener(ActionListener actionListener) {
    this.actionListener = actionListener;
  }
  public ActionListener getActionListener() {
    return actionListener;
  }
}
