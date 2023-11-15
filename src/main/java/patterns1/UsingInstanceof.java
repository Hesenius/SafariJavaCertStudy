package patterns1;

public class UsingInstanceof {
  public static void showStringThing(Object obj) {
//    if (obj instanceof String) {
//      String s = (String)obj;
    if (obj instanceof String s && s.length() > 3) {
      System.out.println("It's a longish String of " + s.length() + " characters!");
    } else {
      System.out.println("short string or not a string");
    }

    if (!(obj instanceof String s) || s.length() > 3) {
      System.out.println("long string or not a string");
    } else {
      System.out.println("It's a shortish String of " + s.length() + " characters!");
    }

//    do {
//
//    } while (!(obj instanceof String x));
//    System.out.println(x);
  }

  public static void main(String[] args) {
    showStringThing("Hello");
    showStringThing("He");
    showStringThing(99);
  }
}
