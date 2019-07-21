package pl.connectis.programator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;

public class CalcTest {

  // System Under Test -> SUT
  Calc calc = new Calc();


  @BeforeEach
  void prepareData(){
    System.out.println("Wykonuję inicjalizację danych");
    List<Double> values = new ArrayList<>();
    values.add(1.0);
    values.add(2.0);
    values.add(3.0);
    values.add(4.0);
    values.add(5.0);
    calc.setValues(values);
  }

  @AfterEach
  void cleanUp(){
    System.out.println("Czyszczenie po każdym teście");
    calc.clear();
  }

  @Test
  @DisplayName("Very special adding test")
  @Tag("important")
  void checkAdding() {
    System.out.println("Testowanie dodawania");
    assertEquals(5, calc.sum(2, 3));
  }

  @Test
  @Tag("important")
  void checkStd() {
    System.out.println("Testowanie odchylenia");
    assertEquals(1.5811388300841898, calc.std(), "Błąd w oblczaniu odchylenia " + calc.std());
  }

  @ParameterizedTest
  @CsvSource({"1, 2, 1.5", "2, 2, 2"})
  void checkMean(double l1, double l2, double result) {
    List<Double> values = new ArrayList<>();
    values.add(l1);
    values.add(l2);
    calc.setValues(values);
    assertEquals(result, calc.mean(), () -> "Błąd w obliczaniu średniej");
  }

  @Test
  void checkSmthing(){
    assertThat("Bolek").startsWith("Bo").endsWith("ek");
  }

  @ParameterizedTest
  @ValueSource(ints = { 2, 4, 22, 122, 88 })
  void checkIsEven(int l) {
    assertTrue(calc.isEven(l));
  }

  @ParameterizedTest
  @ValueSource(ints = { 3, 7, 8, 121, 89 })
  void checkIsOdd(int l) {
    assertFalse(calc.isEven(l));
  }

  @ParameterizedTest
  @CsvSource({"2, 3, 5", "3, 4, 8", "2, 6, 8"})
  void checkAdding(int l1, int l2, int result) {
    assertEquals(result, calc.sum(l1, l2));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/numbers.csv")
  void checkAddingFromFile(int l1, int l2, int result) {
    assertEquals(result, calc.sum(l1, l2));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/even_odd_numbers.csv")
  void checkAddingFromFile(int l1, boolean result) {
    assertEquals(result, calc.isEven(l1));
  }

  @Test
  void checkTimeout() {
    assertTimeoutPreemptively(Duration.ofMillis(10), ()-> {

      Thread.sleep(4000);
      //calc.mean();
    });
  }

  @Test
  void groupedAssertions() {
    // In a grouped assertion all assertions are executed, and all
    // failures will be reported together.
    assertAll("True or false - adding",
        () ->  assertEquals(2, calc.sum(1, 1)),
        () ->  assertEquals(3, calc.sum(2, 1)),
        () ->  assertEquals(3, calc.sum(2, 1))
    );
  }

  @Test
  void dependentAssertions() {
    // Within a code block, if an assertion fails the
    // subsequent code in the same block will be skipped.
    assertAll("properties",
        () -> {
          assertNotNull(calc);

          // Executed only if the previous assertion is valid.
          assertAll("True of False 1",
              () -> assertTrue(2 < 3),
              () -> assertTrue( 3 > 2)
          );

          assertAll("True or False 3",
              () -> assertTrue(2 < 3 ),
              () -> assertTrue(3 < 2)
          );
        },
        () -> {
          // Grouped assertion, so processed independently
          // of results of first name assertions.
          assertNotNull(calc);

          // Executed only if the previous assertion is valid.
          assertAll("True or False 2",
              () -> assertTrue(2 < 3 ),
              () -> assertTrue(3 < 2)
          );
        }
    );
  }




}
