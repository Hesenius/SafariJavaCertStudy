package switchstuff;

import java.time.LocalDate;

public class Ex4 {
  public static void main(String[] args) {
    String obj = "Hello";

    // exactly parallel to discussion with conditional operator and var
    var x = switch (obj) {
      case "Hello" -> "Textual";
      case "99" -> 99;
      default -> LocalDate.now();
    };
    x.compareTo(null);
  }
}
