package ca.jbrains.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SellOneItemEndToEndTest {
    @Test
    void oneCommand_oneBarcode_productFound() {
        String actualTextOutput = consumeTextCommands(
                """
                        12345
                        """
        );

        final String expectedTextOutput = """
                $7.95""";
        Assertions.assertEquals(expectedTextOutput, actualTextOutput);
    }

    @Test
    void oneCommand_oneBarcode_anotherProductFound() {
        String actualTextOutput = consumeTextCommands(
                """
                        23456
                        """
        );

        final String expectedTextOutput = """
                $12.50""";
        Assertions.assertEquals(expectedTextOutput, actualTextOutput);
    }

    @Test
    void oneCommand_oneBarcode_productNotFound() {
        String actualTextOutput = consumeTextCommands(
                """
                        99999
                        """
        );

        final String expectedTextOutput = """
                Product not found: 99999""";
        Assertions.assertEquals(expectedTextOutput, actualTextOutput);
    }

    // SMELL Before adding the empty barcode case, do we _really_
    // need to keep paying attention to "one command, one barcode"?!

    private String consumeTextCommands(String rawText) {
        final List<String> commandsAsLines = linesOf(rawText);

        final String theOnlyCommand = commandsAsLines.get(0);

        final Map<String, String> pricesByBarcode = Map.of("12345", "$7.95",
                "23456", "$12.50");

        final String priceAsText = pricesByBarcode.get(theOnlyCommand);
        if (priceAsText == null)
            return String.format("Product not found: %s", theOnlyCommand);
        else
            return priceAsText;
    }

    // REFACTOR Move to Text utility library
    // REFACTOR Change tests to use this
    private static List<String> linesOf(String text) {
        return new BufferedReader(new StringReader(text))
                .lines()
                .collect(Collectors.toList());
    }
}
