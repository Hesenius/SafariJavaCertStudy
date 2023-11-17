package sealedhierarchies;

// permits is optional if, but only if, all subtypes are in the SAME source file
final /*sealed*/ /*non-sealed*/ class Truck extends Object implements Transporter /*permits BoxVan*/ {}
sealed interface Transporter /*permits Truck, Car*/ {}
//final class BoxVan extends Truck {}
//final class Car implements Transporter {}
///*final -- implicitly final :) */record Car(int seats, String color) implements Transporter {}
enum Car implements Transporter { FORD_FIESTA, BMW_5 {} }
//class Bicycle implements Transporter {}

public class Example {
  public static boolean canCarryPayload(Transporter t, int p) {
    if (t instanceof Truck) {
      return p < 5_000;
    } else if (t instanceof Car) {
      return p < 500;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Transporter t = new Truck();
    int payload = 1000;

    System.out.println("can carry payload? " + canCarryPayload(t, payload));
  }
}
