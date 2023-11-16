package records;

import java.sql.SQLException;

// Records are intended as "immutable data carrier" -- term "unmodifiable"
// we get constructor, toString, equals, hashCode, get-type methods for free
// "components" type and color result in private final fields of the same name and type
// those fields are initialized by the provided constructor
// NO extends permitted, all records are subtype of java.lang.Record
// Records are FINAL classes
record Car(String type, String color) { // template of "canonical" constructor
// canonical constructor initializes the fields created from the component declarations
// formal param names, if declared explicitly MUST MATCH components
//  Car(String type, String color) {
//    this.type = type; // MUST initialize the component-fields (once!!! they are final)
//    this.color = color;
//  }

//  Car(String type, String color) {
//    if (type == null || type.length() == 0) {
//      throw new IllegalArgumentException("bad type!");
//    }
//    this.type = type;
//    this.color = color;
//  }

  Car { // "compact" constructor runs **BEFORE** the canonical constructor
    System.out.println("in compact constructor");

    if (type == null || type.length() == 0) {
      throw new IllegalArgumentException("bad type!");
    }
    type = type.toUpperCase(); // access formal params OK
//    this.type = x; // MUST NOT TOUCH component-fields
    // code of canonical constructor gets "pasted" here :)
  }

  static String getDefaultColor() {
    System.out.println("Getting default color");
    return "RED";
  }
  Car(String t) {
//    int x = 99;
    // Must delegate (eventually) to the canonical constructor
    this(t.toUpperCase() + "Hello!", getDefaultColor());
  }

  //  private int x; // NOPE!!!
  public static int x = 99;

  public static int getX() {
    System.out.println("accessing static field");
    return x;
  }

  public int getColorLength() {
    return color.length();
  }

  @Override
  public String toString() {
    // NOT really an override, more of a replacement
//    return super.toString().toUpperCase(); // NOPE
    return "Car[type=" + type.toUpperCase() + "]";
  }

  @Override
  // replacements for the access methods must NOT throw checked exceptions
  public String type() /*throws SQLException */{
    return type.toUpperCase();
  }
}

public class Ex1 {
  public static void main(String[] args) {
    Car c1 = new Car("Ford", "Blue");
    Car c2 = new Car("Ford", "Blue");
    Car c3 = new Car("BMW", "Green");
    System.out.println(c1);
    System.out.println(c1.equals(c2));
    System.out.println(c3.type());
    System.out.println(c3.color());
    System.out.println(Car.x);
    Car.x = 100;
    System.out.println(Car.x);

    Car c4 = new Car("Fiat");
  }
}
