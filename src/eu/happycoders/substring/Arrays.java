package eu.happycoders.substring;

/** The method <code>java.util.Arrays::toString</code> exists only since Java 5. */
public class Arrays {

  static String toString(byte[] bytes) {
    // StringBuilder exists only since Java 5
    StringBuffer result = new StringBuffer();
    result.append('[');
    for (int i = 0; i < bytes.length; i++) {
      result.append(bytes[i]);
      if (i < bytes.length - 1) result.append(", ");
    }
    result.append(']');
    return result.toString();
  }

  static String toString(char[] chars) {
    // StringBuilder exists only since Java 5
    StringBuffer result = new StringBuffer();
    result.append('[');
    for (int i = 0; i < chars.length; i++) {
      result.append(chars[i]);
      if (i < chars.length - 1) result.append(", ");
    }
    result.append(']');
    return result.toString();
  }
}
