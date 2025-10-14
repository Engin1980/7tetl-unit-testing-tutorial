package cz.osu.prf.kip.validators;

public class ArgumentAsserts {
  public static void isNotNull(Object value, String argumentName){
    if (value == null)
      throw new IllegalArgumentException(argumentName + " is null.");
  }
  public static void isNotNullOrWhitespace(String value, String argumentName){
    if (value == null || value.trim().isEmpty())
      throw new IllegalArgumentException(argumentName + " is empty string.");
  }
}
