package exceptions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

class AC4 implements AutoCloseable {
  @Override
  public void close() throws Exception {
    throw new SQLException();
  }
}

public class Suppressed {
  public static void main(String[] args) throws Throwable {
    try (
      var one = new AC4();
      var two = new AC4();
    ) {
//      throw new FileNotFoundException();
    }
  }
}
