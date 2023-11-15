package switchstuff;

public class Ex2 {
  public static void main(String[] args) {
//    String s = "Hello";
    String s = "Hi";
    switch (s) {
//      case "Odd" -> break; // NOPE!!
      case "Hello" -> {
        System.out.print("Bonjour "); // line n1
        if (Math.random() > 0.5) break;
        System.out.println("Guten Tag");
      }
//      default -> System.out.print("Bye");
    }
  }
}
