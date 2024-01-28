package exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralTest {
    @Test
    void one_is_I() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        String romanNumeral = converter.toRomanNumeral(1);
        assertEquals("I", romanNumeral);
    }
}
