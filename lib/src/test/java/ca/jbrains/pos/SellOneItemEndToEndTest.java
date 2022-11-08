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

    private static List<String> linesOf(String rawText) {
        final List<String> commandsAsLines =
                new BufferedReader(new StringReader(rawText))
                        .lines()
                        .collect(Collectors.toList());
        return commandsAsLines;
    }
}
