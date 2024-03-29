package io.vjattich.formatter;

import java.util.Collections;
import java.util.List;

public class CsvFormatter implements Formatter {

    private List<String> elements = Collections.emptyList();
    private long newLineStep = 3L;
    private char separator = ',';

    public CsvFormatter setElements(List<String> strings) {
        this.elements = strings;
        return this;
    }

    public CsvFormatter setNewLineStep(long newLineStep) {
        this.newLineStep = newLineStep;
        return this;
    }

    public CsvFormatter setSeparator(char separator) {
        this.separator = separator;
        return this;
    }

    public String format() {

        var nl = this.newLineStep;
        var multiplicator = 1;
        var sb = new StringBuilder();
        var resultSize = this.elements.size();

        for (var i = 0; i < resultSize; i++) {

            var text = this.elements.get(i);

            if (nl == (i + 1)) {
                sb.append(text).append(System.lineSeparator());
                multiplicator = multiplicator + 1;
                nl = this.newLineStep * multiplicator;
                continue;
            }

            sb.append(text).append(separator);
        }

        return sb.toString();
    }
}