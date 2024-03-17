package io.vjattich;

import io.vjattich.formatter.CsvFormatter;
import io.vjattich.parser.LentaChequeHtmlFileParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {

        String result = new CsvFormatter(
                new LentaChequeHtmlFileParser(new File(args[0])).parse(),
                3L
        ).format();

        Files.write(Paths.get("result.csv"), result.getBytes());
    }
}