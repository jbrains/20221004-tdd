package ca.jbrains.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;
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

    private String consumeTextCommands(String rawText) {
        final List<String> commandsAsLines = linesOf(rawText);

        if ("12345".equals(commandsAsLines.get(0)))
            return "$7.95";
        else
            return "$12.50";
    }

    // REFACTOR Move to Text utility library
    // REFACTOR Change tests to use this
    private static List<String> linesOf(String text) {
        return new BufferedReader(new StringReader(text))
                .lines()
                .collect(Collectors.toList());
    }
}
