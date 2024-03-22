package io.vjattich;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class TestUtils {

    public static URI toUri(String name) throws URISyntaxException {
        return Objects.requireNonNull(TestUtils.class.getClassLoader().getResource(name)).toURI();
    }


}
