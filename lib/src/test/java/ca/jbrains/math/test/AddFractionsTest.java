package ca.jbrains.math.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AddFractionsTest {
    @Test
    void zeroPlusZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(0));

        Assertions.assertEquals(new Fraction(0), sum);
    }

    @Test
    void notZeroPlusZero() {
        Fraction sum = new Fraction(4).plus(new Fraction(0));

        Assertions.assertEquals(new Fraction(4), sum);
    }

    @Test
    void zeroPlusNotZero() {
        Fraction sum = new Fraction(0).plus(new Fraction(7));

        Assertions.assertEquals(new Fraction(7), sum);
    }

    @Test
    void notZeroPlusNotZero() {
        Fraction sum = new Fraction(3).plus(new Fraction(6));

        Assertions.assertEquals(new Fraction(9), sum);
    }

    @Test
    void nonIntegerPlusZero() {
        Fraction sum = new Fraction(1, 3).plus(new Fraction(0));

        Assertions.assertEquals(new Fraction(1, 3), sum);
    }

    @Test
    void nonIntegerFractionsWithoutReducingTheAnswer() {
        Fraction sum = new Fraction(3, 7).plus(new Fraction(1, 7));

        Assertions.assertEquals(new Fraction(4, 7), sum);
    }

    @Test
    void nonIntegerFractionsWithDifferentDenominators() {
        Fraction sum = new Fraction(2, 5).plus(new Fraction(4, 9));

        Assertions.assertEquals(new Fraction(38, 45), sum);
    }

    @Test
    void answerNotInLowestTerms() {
        Fraction sum = new Fraction(1, 8).plus(new Fraction(3, 8));

        Assertions.assertEquals(new Fraction(1, 2), sum);
    }

    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int integerValue) {
            this.numerator = integerValue;
            this.denominator = 1;
        }

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction plus(Fraction that) {
            return new Fraction(
                    this.numerator * that.denominator + this.denominator * that.numerator,
                    this.denominator * that.denominator);
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Fraction) {
                Fraction that = (Fraction) other;
                return this.numerator * that.denominator == that.numerator * this.denominator;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return -762;
        }
    }
}
