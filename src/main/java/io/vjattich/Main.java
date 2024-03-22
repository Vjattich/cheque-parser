package io.vjattich;

import io.vjattich.formatter.CsvFormatter;
import io.vjattich.resolver.ParserResolverImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {

        if (0 == args.length) {
            throw new IllegalArgumentException("You need pass some arguments");
        }

        //todo infos for cheques
        var result = new CsvFormatter()
                .setElements(
                        new ParserResolverImpl(args[0])
                                .resolve()
                                .parse()
                )
                .setNewLineStep(3L)
                .setSeparator(',')
                .format();

        Files.write(Paths.get("result.csv"), result.getBytes());
    }
}