package enumstuff;

// enum should ensure that exactly these INSTANCES ever exist
// prohibit user-instantiation
// prohibit "deserialization" to a new instance
// guard against reflection weirdness
enum Day {
  MONDAY(1), TUESDAY;
  private Day(int d) {
    System.out.println("making a day with int " + d);
    dn = d;
  }
  Day() {// PRIVATE (not "default access")
    System.out.println("making a day with zero args");
  }
//  public Day(int d) {} // constructors MUST be private!!!
//  public Day() {}
  private static String thing = "I'm a message";
  public static String getThing() {
    return thing;
  }
  private int dn;

  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
//  public String name() { // nope, this is FINAL
//    return null;
//  }
}

public class Example {
  public static void main(String[] args) {
//    new Day() // MUST NOT be able to do this!
    System.out.println(Day.MONDAY);

    Day m = Day.valueOf("MONDAY"); // uses name() method :)
    System.out.println(m == Day.MONDAY);
    System.out.println(Day.MONDAY.name());
    System.out.println(Day.MONDAY.toString());
    System.out.println(Day.MONDAY.ordinal());
  }
}
