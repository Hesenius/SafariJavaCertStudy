package nested;

class Outer1 {
  private String name;
  public Outer1(String name) {
    this.name = name;
  }
  public class Inner1 {
    private int y = 100;
    private String name = "Inner!";

//    public Inner1(Outer1 Outer1.this) {
    public Inner1() {
      System.out.println("constructing an Inner1 inside: " + Outer1.this.name);
    }
    // line n1
    void showX() {
      System.out.printf("x is " + x);
    }

    public String getMyOwnersName() {
//      return name;
      return Outer1.this.name;
    }
  }

  private int x = 99;
  // line n2
//  void showY() {
//    System.out.printf("y is " + y);
//  }
  void showAnotherY(Inner1 another) {
    System.out.println("y is " + another.y);
  }
//  Inner1 makeOne() { // OK as INSTANCE method, NOT as static
//    return new Inner1();
//  }
}

public class Nested {

//  void showX() { sop("x is " + x); }
//  void showY() { sop("y is " + y); }
//  void showAnotherY(Inner1 another) { sop("y is " + another.y); }
//static Inner1 makeOne() { return new Inner1(); }

  public static void main(String[] args) {
    Outer1 fred = new Outer1("Fred");

    Outer1.Inner1 fredSon1 = fred.new Inner1();
    Outer1.Inner1 fredSon2 = fred.new Inner1();
    System.out.println(fredSon1.getMyOwnersName());
    System.out.println(fredSon2.getMyOwnersName());

    Outer1 jim = new Outer1("Jim");
    Outer1.Inner1 jimSon1 = jim.new Inner1();
    System.out.println(jimSon1.getMyOwnersName());
  }
}
