package ca.jbrains.learning.java.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        return firstLineIsBlank.split(System.lineSeparator());
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
    void ignoreMultipleBlankLinesAtTheEnd() {
        final String endQuotesOnLineAfterLastLine = """
                first line
                second line
                last line, even though blank lines follow
                
                """;

        final String[] lines = linesOf(endQuotesOnLineAfterLastLine);
        Assertions.assertEquals(
                "last line, even though blank lines follow",
                lines[lines.length - 1]);
    }
}
