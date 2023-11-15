package switchstuff;

enum Day { MONDAY; }
public class Ex1 {
  public static void main(String[] args) {
//    var x = 10;
//    var x = "Hello";
//    var x = Day.MONDAY;
//    var x = Character.valueOf('x');
//    var x = Boolean.valueOf(true);
//    var x = 1L;
    String x = null;
    switch (x) { // NPE HERE!!!
      case "":
        System.out.println("Empty String");
    }
  }
}
