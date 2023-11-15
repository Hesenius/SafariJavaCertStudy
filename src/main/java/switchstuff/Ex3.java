package switchstuff;

public class Ex3 {
  public static void main(String[] args) {
    short s = 8;
    System.out.println(switch (s) { // line n1
      // line n2
      case 2, 4, 6, 8 -> {
        System.out.println("Matched an even!");
        yield "even < 10"; // yield is required for arrow with block
      }
      default -> "It's something else"; // line n3
    });

//    System.out.println(switch (s) { // line n1
//      // line n2
//      case 2, 4, 6, 8 :
//        System.out.println("Matched an even!");
//        yield "even < 10"; // also effectively "break"
//      default : yield "It's something else"; // line n3
//    });
  }
}
