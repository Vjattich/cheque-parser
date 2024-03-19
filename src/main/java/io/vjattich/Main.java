package io.vjattich;

import io.vjattich.formatter.CsvFormatter;
import io.vjattich.parser.LentaChequeHtmlFileParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {

        //todo null param check
        //todo infos for cheques
        //todo parse links https://receipt.taxcom.ru/v01/show?id=46DBDD61-E7BC-45FC-9A30-E6C203832559&utm_source=ofd&utm_medium=receipt&utm_campaign=receipt_email
        var result = new CsvFormatter()
                .setElements(new LentaChequeHtmlFileParser(new File(args[0])).parse())
                .setNewLine(3L)
                .setSeparator(',')
                .format();

        Files.write(Paths.get("result.csv"), result.getBytes());
    }
}