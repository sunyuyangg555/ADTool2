package lu.uni.adtool.domains.rings;

import java.io.Serializable;

/**
 * Boolean class with html representation.
 *
 * @author Piot Kordy
 */
public class Bool implements Serializable, Ring {

  /**
   * Allocates a Boolean object representing the <code>newValue</code> argument.
   * * @param newValue
   */
  public Bool(final boolean newValue) {
    value = newValue;
  }

  public Object clone() {
    return new Bool(value);
  }

  /**
   * Returns a String object representing this Boolean's value. If this object
   * represents the value true, a string equal to "true" is returned. Otherwise,
   * a string equal to "false" is returned.
   *
   * @return a string representation of this object.
   */
  public final String toString() {
    return Boolean.toString(value);
  }

  /**
   * Unicode representation.
   *
   * @return an unicode representation of this object.
   */
  public final String toUnicode() {
    return Boolean.toString(value);
  }

  /**
   * Set the new value reading from the string
   *
   */
  public final boolean updateFromString(String s) {
    if (s.toUpperCase().equals("TRUE")) {
      value = true;
      return true;
    }
    else if (s.toUpperCase().equals("FALSE")) {
      value = false;
      return true;
    }
    return false;
  }

  /**
   * Determines if this instance is value.
   *
   * @return The value.
   */
  public final boolean getValue() {
    return this.value;
  }

  /**
   * Logical or.
   *
   * @param a
   *          first parameter
   * @param b
   *          second parameter
   * @return <code>a</code> or <code>b</code>
   */
  public static Bool or(final Bool a, final Bool b) {
    return new Bool(a.getValue() || b.getValue());
  }

  /**
   * Logical and.
   *
   * @param a
   *          first parameter
   * @param b
   *          second parameter
   * @return <code>a</code> and <code>b</code>
   */
  public static Bool and(final Bool a, final Bool b) {
    return new Bool(a.getValue() && b.getValue());
  }

  /**
   * Negation.
   *
   * @param a
   *          parameter
   * @return not <code>a</code>
   */
  public static Bool not(final Bool a) {
    return new Bool(!a.getValue());
  }

  public int compareTo(Object o) {
    if (o instanceof Bool) {
      boolean val2 = ((Bool) o).getValue();
      if (value == val2) {
        return 0;
      }
      if (value) {
        return -1;
      }
      if (!value) {
        return 1;
      }
    }
    throw new ClassCastException("Unable to compare Bool class with " + o);
  }

  private static final long serialVersionUID = 180024879665721515L;
  private boolean           value;
}
