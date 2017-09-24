package Box;

import java.util.ArrayList;
import java.util.List;
import Commands.Command;

/** The Invoker class */
public class History {
  private List<Command> history = new ArrayList<Command>();

  public void storeAndExecute(final Command cmd) {
    this.history.add(cmd); // optional
//    cmd.execute();
  }
}