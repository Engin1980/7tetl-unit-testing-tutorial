package cz.osu.prf.kip.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentAssertsTest {

  @Test
  void isNotNull_Success() {
    ArgumentAsserts.isNotNull(1, "number");
  }

  @Test
  void isNotNull_Failure() {
    Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      ArgumentAsserts.isNotNull(null, "param");
    });
    assertTrue(ex.getMessage().contains("param"));
    assertTrue(ex.getMessage().toLowerCase().contains("null"));
  }

  @Test
  void isNullOrWhitespace_Success() {
    ArgumentAsserts.isNotNullOrWhitespace("dudla", "param");
  }

  @ParameterizedTest
  @ValueSource(strings = {"a", "bas", "asef", "byuoasmef", " fasef af fasef"})
  void isNullOrWhitespace_SuccessMulti(String param) {
    ArgumentAsserts.isNotNullOrWhitespace(param, "param");
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "   ", "\t", "\t \t", "     "})
  void isNullOrWhitespace_FailureMulti(String param) {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> ArgumentAsserts.isNotNullOrWhitespace(param, "param"));
  }

  @Test
  void isNullOrWhitespace_FailureOnNull() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> ArgumentAsserts.isNotNullOrWhitespace(null, "param"));
  }

  @ParameterizedTest
  @CsvSource({
      "a, true",
      "aa, true",
      " , false",
      "\t, false",
      "   , false"
  })
  void isNullOrWhitespace_FailureMultipleWithCsv(String param, boolean result) {
    if (!result)
      isNullOrWhitespace_FailureMulti(param);
    else
      isNullOrWhitespace_SuccessMulti(param);
  }
}