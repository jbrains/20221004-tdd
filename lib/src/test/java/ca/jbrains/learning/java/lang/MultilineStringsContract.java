package ca.jbrains.learning.java.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Collectors;

public class MultilineStringsContract {
    @Test
    void allLinesIndentedTheSame() {
        final String allLinesIndentedTheSame = """
                first line
                second line
                third line""";

        Assertions.assertEquals(
                "first line",
                linesOf(allLinesIndentedTheSame)[0]);
    }

    private static String[] linesOf(String firstLineIsBlank) {
        // I couldn't make String.split() do what I wanted, so I chose this solution.
        // This solution preserves blank lines and ensures that no line ends
        // in a newline character.
        return new BufferedReader(new StringReader(firstLineIsBlank))
                .lines()
                .collect(Collectors.toList())
                .toArray(new String[0]);
    }

    @Test
    void firstLineIndentedMore() {
        final String firstLineIsBlank = """
                    first line
                second line
                third line""";

        Assertions.assertEquals(
                "    first line",
                linesOf(firstLineIsBlank)[0]);
    }

    @Test
    void ignoreApparentBlankLineAtTheEnd() {
        final String endQuotesOnLineAfterLastLine = """
                first line
                second line
                last line
                """;

        final String[] lines = linesOf(endQuotesOnLineAfterLastLine);
        Assertions.assertEquals(
                "last line",
                lines[lines.length - 1]);
    }

    @Test
    void respectMultipleBlankLinesAtTheEnd() {
        final String endQuotesOnLineAfterLastLine = """
                first line
                second line
                third-last line
                
                
                """;

        final String[] lines = linesOf(endQuotesOnLineAfterLastLine);
        Assertions.assertEquals(
                "third-last line",
                lines[lines.length - 3]);
        Assertions.assertEquals(
                "",
                lines[lines.length - 2]);
        Assertions.assertEquals(
                "",
                lines[lines.length - 1]);
    }
}
