package exceptions;

class AC implements AutoCloseable {
  private String name;

  public AC(String name) {
    this.name = name;
  }

  @Override
  public void close() {
    System.out.print("Closing " + name);
  }
}

public class CloseOrder {
  public static void main(String[] args) {
    var ac0 = new AC("zero");
    try (
      var ac1 = new AC("one"); // implicitly final :)
      var ac2 = new AC("two");
      ac0;
    ) {
//      ac1 = null; // NOPE!
    }
//    ac0 = null; // NOPE, must be final or effectively final
    // auto-generated finally -- close all resources
    // in REVERSE order of "mention"
    try ( var ac1 = new AC("one")) {
      try (var ac2 = new AC("two")) {
        try (ac0) {}
      }
    }
  }
}
