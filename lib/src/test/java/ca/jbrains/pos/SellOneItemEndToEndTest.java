package ca.jbrains.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SellOneItemEndToEndTest {
    @Disabled("WIP: Exploring the Contract of multiline strings and String.split() in Java.")
    @Test
    void happyPath() {
        String actualTextOutput = consumeTextCommands(
                """
                12345        
                """
        );

        final String expectedTextOutput = """
                $7.95
                """;
        Assertions.assertEquals(expectedTextOutput, actualTextOutput);
    }

    private String consumeTextCommands(String rawText) {
        return "obviously wrong";
    }
}
