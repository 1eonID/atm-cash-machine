package box;

import commands.Command;
import java.util.ArrayList;
import java.util.List;

/* The Invoker class */
public class History {
  private List<Command> history = new ArrayList<Command>();

  /*
  public void storeAndExecute(final Command cmd) {
    this.history.add(cmd);
    cmd.execute();
  }
  */
}