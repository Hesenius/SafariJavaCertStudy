package textblocks;

public class TextBlock {
  public static void main(String[] args) {

    // text blocks DO perform some processing (they're not "raw")
  String message = """
   Hello\n\n
      Java 17 World!      """;
   System.out.println(message + "XXX");
   System.out.println(message.length());
   System.out.println((int)message.charAt(message.length() - 1));
  }
}
