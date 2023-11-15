package usingvar;

import java.io.FileReader;
import java.io.FileWriter;

class X {
//  var x = 99; // var is ONLY for local variables
}

public class Examples {


//  void doStuff(var x) { }

//  void doStuff() {
//    var x; // NOPE, must be initialized (usually)
//    x = 100;
//  }

  void doStuff1() {
//    int a, b, c = 99;
//    var a, b, c = 99; // NOPE! Only a single variable at a time
//    for (int a, b, c = 99; ; ) {break;}
    var x = 2_000_000_000;
//    x = "Hello"; // x is int, not javascript-like
  }

//  void doStuff() {
//    var x = (Object)null; // OK :)
//    var x = null; // NOPE, no type for x!
//  }

  void doStuff3() throws Throwable {
  for (var x = 0; x < 3; x++)
    System.out.println(x);

  try (var in = new FileReader("");
       var out = new FileWriter("")) {
  }

//  try (FileReader in = new FileReader("")) {
//  } catch (var ex) { } // NOPE

  }
  void doStuff4() {
    var x = new int[]{ 1, 2, 3 };
  }

  void useArr(int [] ia) {}
  void doStuff5() {
//    useArr({1,2,3});
    useArr(new int[]{1,2,3});
//    int[] x = { 1, 2, 3 }; // type inferencing!!!
//    var x = { 1, 2, 3 }; // NOPE type inferencing can't work here!!!
  }

}
