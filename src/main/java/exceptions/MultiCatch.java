package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultiCatch {
  void doStuff() throws IOException {};
  void doStuff2() throws FileNotFoundException {};
  void tryStuff() {
    try {
      doStuff();
      doStuff2();
      if (Math.random() > 0.5) throw new SQLException();
//    } catch(FileNotFoundException e) {
//      e.printStackTrace();
    } catch(IOException | SQLException e) {
      e.printStackTrace();
      // handle both exceptions
    }
  }
}
/*
A) catch (IOException | FileNotFoundException e)
B) catch (FileNotFoundException | IOException e)
C) catch (FileNotFoundException e)
D) catch (IOException e)
E) finally
 */
