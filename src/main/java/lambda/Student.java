package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Student(String name, double gpa, String ... courses) {
  @Override
  public String toString() {
    return String.format("Student, name=%s, gpa=%4.2f, courses=%s",
      name, gpa, Arrays.toString(courses));
  }
}

@FunctionalInterface
interface InterestingStudent {
  boolean test(Student s);
//  void doStuff();
}

class SmartStudent implements InterestingStudent {
  @Override
  public boolean test(Student s) {
    return s.gpa() > 3.0;
  }
}

class EnthusiasticStudent implements InterestingStudent {
  @Override
  public boolean test(Student s) {
    return s.courses().length > 2;
  }
}

class School {

  public static InterestingStudent getSmartCriterion(double threshold) {
//    threshold++;
    return s -> s.gpa() > threshold; // "closure", must be final or effectively final
  }

//  public static List<Student> getAllSmart(List<Student> ls, double threshold) {
//    List<Student> res = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.gpa() > threshold) {
//        res.add(s);
//      }
//    }
//    return res;
//  }

  public static List<Student> getInteresting(List<Student> ls, InterestingStudent criterion) {
    List<Student> res = new ArrayList<>();
    for (Student s : ls) {
      if (criterion.test(s)) {
        res.add(s);
      }
    }
    return res;
  }



  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
  }
  public static void main(String[] args) {
    List<Student> roster = List.of(
      new Student("Fred", 3.2, "Math", "Physics"),
      new Student("Jim", 2.2, "Journalism"),
      new Student("Sheila", 3.9, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showAll(roster);
    System.out.println("-----------------");
//    showAll(getAllSmart(roster, 3.0));

    // ??? must be a reference to an object that implements InterestingStudent
    // InterestingStudent is an INTERFACE that declares EXACTLY ONE abstract method
    // AND we ONLY want to provide implementation for that ONE method
//    showAll(getInteresting(roster, ??? ));
//    showAll(getInteresting(roster, /* just the method */ ));
    showAll(getInteresting(roster,
//      (Student s) -> { return s.gpa() > 3.0; }
//      (@Deprecated var s) -> { return s.gpa() > 3.0; }
//      (s) -> { return s.gpa() > 3.0; }
//      s -> { return s.gpa() > 3.0; }
      s -> s.gpa() > 3.0
    ));
    System.out.println("-----------------");
//    showAll(getAllSmart(roster, 2.0));
//    showAll(getInteresting(roster, new EnthusiasticStudent()));
    showAll(getInteresting(roster, st -> st.courses().length < 3));

    System.out.println("-----------------");
    InterestingStudent verySmart = getSmartCriterion(3.5);
    InterestingStudent fairlySmart = getSmartCriterion(2.9);
    showAll(getInteresting(roster, verySmart));
    System.out.println("-----------------");
    showAll(getInteresting(roster, verySmart));
    System.out.println("-----------------");
    showAll(getInteresting(roster, fairlySmart));
  }
}
