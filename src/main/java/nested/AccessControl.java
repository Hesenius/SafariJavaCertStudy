package nested;

public class AccessControl {
  private static String msg1 = "msg1";
  public class Inner1 {
    private static String msg2 = "msg2";
    public void doStuff() {
      System.out.println(msg1);
      System.out.println(msg2);
      System.out.println(Inner2.msg3);
    }
  }
  public class Inner2 {
    private static String msg3 = "msg3";
    public void doStuff() {
      System.out.println(msg1);
      System.out.println(Inner1.msg2);
      System.out.println(msg3);
    }
  }
  public void doStuff() {
    System.out.println(msg1);
    System.out.println(Inner1.msg2);
    System.out.println(Inner2.msg3);
  }
}
