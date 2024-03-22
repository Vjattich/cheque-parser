package io.vjattich.resolver;

import io.vjattich.parser.LentaChequeHtmlFileParser;
import io.vjattich.parser.LentaChequeUrlParser;
import io.vjattich.parser.Parser;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static io.vjattich.TestUtils.toUri;
import static org.assertj.core.api.Assertions.assertThat;

class ParserResolverTest {

    @Test
    void resolve_test_url() {
        //GIVEN
        var arg = "http:/1";

        //WHEN
        Parser parser = new ParserResolverImpl(arg).resolve();

        //THEN
        assertThat(parser).isInstanceOf(LentaChequeUrlParser.class);
    }

    @Test
    void resolve_test_html() throws URISyntaxException {
        //GIVEN
        var arg = Paths.get(toUri("cheques\\lenta 16.03.24.html")).toString();

        //WHEN
        Parser parser = new ParserResolverImpl(arg).resolve();

        //THEN
        assertThat(parser).isInstanceOf(LentaChequeHtmlFileParser.class);
    }

}
