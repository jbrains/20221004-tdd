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

    @Test
    void notZeroPlusNotZero() {
        Fraction sum = new Fraction(3).plus(new Fraction(6));

        Assertions.assertEquals(9, sum.intValue());
    }

    public static class Fraction {
        private final int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction plus(Fraction that) {
            if (this.integerValue != 0 && that.integerValue != 0) {
                return new Fraction(this.integerValue + that.integerValue);
            } else {
                if (that.integerValue == 0)
                    return new Fraction(this.integerValue + that.integerValue);
                else
                    return new Fraction(this.integerValue + that.integerValue);
            }
        }

        public int intValue() {
            return integerValue;
        }
    }
}
