package ca.jbrains.math.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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

    @Test
    void nonIntegerPlusZero() {
        Fraction sum = new Fraction(1, 3).plus(new Fraction(0));

        Assertions.assertEquals(1, sum.numerator());
        Assertions.assertEquals(3, sum.denominator());
    }

    @Test
    void nonIntegerFractionsWithoutReducingTheAnswer() {
        Fraction sum = new Fraction(3, 7).plus(new Fraction(1, 7));

        Assertions.assertEquals(4, sum.numerator());
        Assertions.assertEquals(7, sum.denominator());
    }

    @Disabled("wip: refactoring")
    @Test
    void nonIntegerFractionsWithDifferentDenominators() {
        Fraction sum = new Fraction(2, 5).plus(new Fraction(4, 9));

        Assertions.assertEquals(38, sum.numerator());
        Assertions.assertEquals(45, sum.denominator());
    }

    public static class Fraction {
        private int numerator;
        private int denominator;
        private int integerValue;

        public Fraction(int integerValue) {
            this.integerValue = integerValue;
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction that) {
            if (denominator == 0) {
                return new Fraction(this.integerValue + that.integerValue);
            } else if (that.integerValue == 0 && that.numerator == 0) {
                return this;
            } else {
                if (this.denominator == that.denominator) {
                    return new Fraction(this.numerator + that.numerator, this.denominator);
                } else {
                    return new Fraction(23874, 87234);
                }
            }
        }

        public int intValue() {
            return integerValue;
        }

        public int numerator() {
            return numerator;
        }

        public int denominator() {
            return denominator;
        }
    }
}
