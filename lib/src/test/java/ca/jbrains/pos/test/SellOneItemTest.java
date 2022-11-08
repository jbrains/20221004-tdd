package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SellOneItemTest {
    @Test
    void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("12345");

        Assertions.assertEquals("$7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("23456");

        Assertions.assertEquals("$12.50", display.getText());
    }

    @Test
    void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("99999");

        Assertions.assertEquals("Product not found: 99999", display.getText());
    }

    @Test
    void emptyBarcode() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("");

        Assertions.assertEquals("Scanning error: empty barcode", display.getText());
    }

    private static class Display {
        public void setText(String text) {
            this.text = text;
        }

        private String text;

        public String getText() {
            return text;
        }
    }

    private static class Sale {
        private Display display;

        private Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode) {
            final Map<String, String> pricesByBarcode = Map.of("12345", "$7.95",
                    "23456", "$12.50");

            if ("".equals(barcode))
                display.setText("Scanning error: empty barcode");
            else if ("12345".equals(barcode))
                display.setText(pricesByBarcode.get(barcode));
            else if ("23456".equals(barcode))
                display.setText(pricesByBarcode.get(barcode));
            else
                display.setText(String.format("Product not found: %s", barcode));
        }
    }
}
