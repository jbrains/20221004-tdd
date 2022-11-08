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
}
