package io.vjattich.connect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DocumentConnect {

    public final String url;

    public DocumentConnect(String url) {
        this.url = url;
    }

    public Document connect() {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException("Cant connect to url");
        }
    }


}
