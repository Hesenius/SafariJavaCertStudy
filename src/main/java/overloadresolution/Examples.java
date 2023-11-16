package overloadresolution;

public class Examples {
  void doStuff(int x, int y) {}         // Method A
  void doStuff(int x, long y) {}        // Method B
  void doStuff(long x, int y) {}        // Method C
  void doStuff(int ... x) {}            // Method D
  void doStuff(Integer x, Integer y) {} // Method E
  void doStuff(Integer x, Number y) {} // Method E
  void doStuff(Number x, Integer y) {} // Method E

  public void doStuff() {
    doStuff(1, 2);
  }
}
