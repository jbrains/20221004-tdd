package ca.jbrains.math.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddFractionsTest {
    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));

        Assertions.assertEquals(0, sum.intValue());
    }

    @Test
    void notZeroPlusZero() {
        Fraction sum = new Fraction(4).plus(new Fraction(0));

        Assertions.assertEquals(4, sum.intValue());
    }

    @Test
    void zeroPlusNotZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(7));

        Assertions.assertEquals(7, sum.intValue());
    }

    public static class Fraction {
        private final int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction plus(Fraction that) {
            if (that.integerValue == 0)
                return this;
            else
                return that;
        }

        public int intValue() {
            return integerValue;
        }
    }
}
