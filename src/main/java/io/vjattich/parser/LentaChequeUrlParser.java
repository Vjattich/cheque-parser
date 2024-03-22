package io.vjattich.parser;

import io.vjattich.connect.DocumentConnect;
import org.jsoup.nodes.Element;

import java.util.List;

public class LentaChequeUrlParser implements Parser {

    private final DocumentConnect documentConnect;

    public LentaChequeUrlParser(DocumentConnect documentConnect) {
        this.documentConnect = documentConnect;
    }

    public List<String> parse() {
        return documentConnect
                .connect()
                .select("table[class='receipt-body']")
                .select("td[class='receipt-body']")
                .getLast()
                .select("div")
                .select("td")
                .stream()
                .filter((element) -> element.text().contains("x")
                        || element.child(0).attributes().get("class").equals("value receipt-value-1030")
                        || element.child(0).attributes().get("class").equals("value receipt-value-1043"))
                .map(Element::text)
                .toList();
    }

}