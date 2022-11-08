package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellOneItemTest {
    @Test
    void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale();

        sale.onBarcode("12345");

        Assertions.assertEquals("$7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale();

        sale.onBarcode("23456");

        Assertions.assertEquals("$12.50", display.getText());
    }

    private static class Display {
        public String getText() {
            return "$7.95";
        }
    }

    private static class Sale {
        public void onBarcode(String barcode) {
        }
    }
}
