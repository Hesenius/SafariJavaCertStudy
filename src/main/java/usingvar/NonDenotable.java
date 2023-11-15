package usingvar;

public class NonDenotable {
  public static void main(String[] args) {
    String s = "Hello";
    Integer i = 99;

    var x = true ? "99" : 99;
    x.compareTo(null);
    System.out.println(x);
    System.out.println(x.getClass().getName());

    // new "special words" in Java are NOT keywords, they're context sensitive...
    // maintain backward compatibility
//    var var = "var";
    String var = "var";
  }
}

//class var {}
