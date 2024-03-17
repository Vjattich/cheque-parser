package io.vjattich.parser;

import java.io.IOException;
import java.util.List;

public interface Parser {
    List<String> parse() throws IOException;
}
