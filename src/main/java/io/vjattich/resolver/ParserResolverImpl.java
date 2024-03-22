package io.vjattich.resolver;

import io.vjattich.connect.DocumentConnect;
import io.vjattich.parser.LentaChequeHtmlFileParser;
import io.vjattich.parser.LentaChequeUrlParser;
import io.vjattich.parser.Parser;

import java.nio.file.Paths;

public class ParserResolverImpl implements ParserResolver {

    private final String arg;

    public ParserResolverImpl(String arg) {
        this.arg = arg;
    }

    @Override
    public Parser resolve() {
        try {

            if (arg.startsWith("http")) {
                return new LentaChequeUrlParser(new DocumentConnect(arg));
            }

            var file = Paths.get(arg).toFile();
            if (file.exists()) {
                return new LentaChequeHtmlFileParser(file);
            }

            throw new IllegalArgumentException("Url or file do not exists");
        } catch (Exception e) {
            throw new IllegalArgumentException("Url or file do not exists");
        }
    }
}
