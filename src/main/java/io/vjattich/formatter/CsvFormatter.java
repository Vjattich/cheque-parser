package io.vjattich.formatter;

import java.util.List;

public class CsvFormatter implements Formatter {

    private final List<String> strings;
    private final long newLine;

    public CsvFormatter(List<String> strings) {
        this(strings, 1L);
    }

    public CsvFormatter(List<String> strings, Long newLine) {
        this.strings = strings;
        this.newLine = newLine;
    }

    public String format() {
        var nl = this.newLine;
        var multiplicator = 1;
        var csv = new StringBuilder();
        var i = 0;

        for (int resultSize = this.strings.size(); i < resultSize; ++i) {
            String text = this.strings.get(i);
            if (nl == (i + 1)) {
                csv.append(text).append(System.lineSeparator());
                nl = 3L;
                ++multiplicator;
                nl *= multiplicator;
            } else {
                csv.append(text).append(", ");
            }
        }

        return csv.toString();
    }
}