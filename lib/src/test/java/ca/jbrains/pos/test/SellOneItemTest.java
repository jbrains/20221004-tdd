package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SellOneItemTest {
    @Test
    void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(Map.of("12345", "$7.95",
                "23456", "$12.50"), display);

        sale.onBarcode("12345");

        Assertions.assertEquals("$7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(Map.of("12345", "$7.95",
                "23456", "$12.50"), display);

        sale.onBarcode("23456");

        Assertions.assertEquals("$12.50", display.getText());
    }

    @Test
    void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(Map.of(), display);

        sale.onBarcode("99999");

        Assertions.assertEquals("Product not found: 99999", display.getText());
    }

    @Test
    void emptyBarcode() {
        final Display display = new Display();
        final Sale sale = new Sale(null, display);

        sale.onBarcode("");

        Assertions.assertEquals("Scanning error: empty barcode", display.getText());
    }

    private static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void displayPrice(String price) {
            this.text = price;
        }

        public void displayProductNotFoundMessage(String barcode) {
            this.text = String.format("Product not found: %s", barcode);
        }

        public void displayScannedEmptyBarcodeMessage() {
            this.text = "Scanning error: empty barcode";
        }
    }

    private static class Sale {
        private final Map<String, String> pricesByBarcode;
        private final Display display;

        private Sale(Map<String, String> pricesByBarcode, Display display) {
            this.display = display;
            this.pricesByBarcode = pricesByBarcode;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode)) {
                display.displayScannedEmptyBarcodeMessage();
                return;
            }

            if (pricesByBarcode.containsKey(barcode))
                display.displayPrice(findPrice(barcode));
            else
                display.displayProductNotFoundMessage(barcode);
        }

        private String findPrice(String barcode) {
            return new Catalog(pricesByBarcode).findPrice(barcode);
        }

        private class Catalog {
            private Map<String, String> pricesByBarcode;

            public Catalog(Map<String, String> pricesByBarcode) {
                this.pricesByBarcode = pricesByBarcode;
            }

            public String findPrice(String barcode) {
                return this.pricesByBarcode.get(barcode);
            }
        }
    }
}
