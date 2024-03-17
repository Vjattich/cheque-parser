package io.vjattich.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LentaChequeHtmlFileParser implements Parser {

    private final File file;

    public LentaChequeHtmlFileParser(File file) {
        this.file = file;
    }

    public List<String> parse() throws IOException {
        return Jsoup.parse(this.file)
                .select("table[style=line-height:1.57;color:#45545e;width:100%;min-width:100%;border-spacing:0;border-collapse:separate;background-color:#f0f3f5]")
                .getLast()
                .select("div")
                .select("td")
                .stream()
                .filter((element) -> element.text().contains("x")
                        || element.child(0).attributes().get("style").equals("color:#0069b3;font-size:16px;font-weight:bold;line-height:1.38")
                        || element.attributes().get("style").equals("vertical-align:middle;padding:0;text-align:left"))
                .map(Element::text)
                .toList();
    }
}