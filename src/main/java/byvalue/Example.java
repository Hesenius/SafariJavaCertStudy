package byvalue;

public class Example {
  public static void q14A(Integer x) {
//    x.increment() // can't do this, Integer etc. are immutable
    x = x + 1;
  }

  public static void main(String[] args) {
    Integer x = 99;
    q14A(x);
    System.out.println(x);
  }
}
