package io.vjattich.formatter;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CsvFormatterTest {

    @Test
    public void format() {

        //GIVEN
        CsvFormatter csvFormatter = new CsvFormatter()
                .setElements(IntStream.range(1, 13).mapToObj(Integer::toString).toList())
                .setNewLine(3L)
                .setSeparator(',');
        //WHEN
        var formatted = csvFormatter.format();

        //THEN
        assertThat(formatted).isEqualTo(
                "1,2,3" + System.lineSeparator() + "4,5,6" + System.lineSeparator() + "7,8,9" + System.lineSeparator() + "10,11,12" + System.lineSeparator()
        );
    }

}