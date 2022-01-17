package eu.happycoders.substring;

import java.lang.reflect.Field;

public class SubstringInternalsDemo {
  public static void main(String[] args) throws IllegalAccessException {
    String string = "HappyCoders.eu";
    String substring = string.substring(5, 9);

    printDetails("original string", string);
    printDetails("substring", substring);
    printDetails("substring appended to empty string", "" + substring);
    printDetails("substring wrapped with new string", new String(substring));
  }

  private static void printDetails(String name, String string) throws IllegalAccessException {
    System.out.println(name + ":");
    System.out.println("  string identity  : " + identity(string));
    System.out.println("  string           : " + string);

    Object value = getPrivateField(string, "value");
    System.out.println("  value[] identity : " + identity(value));
    System.out.println("  value[]          : " + valueToString(value));

    // Java 1-6: offset + count
    Integer offset = (Integer) getPrivateField(string, "offset");
    if (offset != null) {
      System.out.println("  offset           : " + offset);
    }

    Integer count = (Integer) getPrivateField(string, "count");
    if (count != null) {
      System.out.println("  count            : " + count);
    }

    // Java 9+: coder
    Byte coder = (Byte) getPrivateField(string, "coder");
    if (coder != null) {
      System.out.println("  coder            : " + coder);
    }

    System.out.println();
  }

  private static String identity(Object o) {
    return "@" + Integer.toHexString(System.identityHashCode(o));
  }

  private static String valueToString(Object value) {
    if (value instanceof byte[]) {
      return Arrays.toString((byte[]) value);
    }

    if (value instanceof char[]) {
      return Arrays.toString((char[]) value);
    }

    return value.toString();
  }

  private static Object getPrivateField(String string, String fieldName)
      throws IllegalAccessException {
    try {
      Field field = String.class.getDeclaredField(fieldName);
      field.setAccessible(true);
      return field.get(string);
    } catch (NoSuchFieldException e) {
      return null;
    }
  }
}
