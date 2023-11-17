package client;

import java.lang.reflect.Field;

public class Client {
  public static void main(String[] args) throws Throwable {
    System.out.println("The message is " + service.Service.srvMessage);
    Class<?> cl = service.Service.class;
    Field f = cl.getDeclaredField("secretMessage");
    f.setAccessible(true);
    System.out.println(f.get(null));
  }
}
