package subtypes;

//abstract class P {
interface P {
  /* public abstract by default in interface*/ void doSomethingAbstract();
}

/*abstract */class Parent /*extends P*/ {
//  @Override
//  void doSomethingAbstract() {
//    System.out.println("something abstract");
//  }

  // default constructor (package access to match the class)
  int x = 99;
  void doStuff() {
    System.out.println("I'm doStuff in Parent");
  }
  static void doStaticStuff() {
    System.out.println("I'm doStaticStuff in Parent");
  }
}

// only ONE parent CLASS in Java
class Child extends Parent implements P {
  // default constructor
  int x = 200;
  @Override
  void doStuff() {
    System.out.println("child doStuff");
    super.doStuff();
    System.out.println("Back in child doStuff");
  }
  static void doStaticStuff() {
    System.out.println("I'm doStaticStuff in Child");
  }

  @Override
  public void doSomethingAbstract() {
    System.out.println("abstract thing");
  }
}
public class Examples {
  public static void main(String[] args) {
    Parent p = new Child();
    System.out.println(p.x);
    p.doStuff();
    p.doStaticStuff(); // UGLY, but legal (yuk!)
    Parent.doStaticStuff();
    Child.doStaticStuff();
    ((Child)p).doStaticStuff();
  }
}
