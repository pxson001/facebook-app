package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* compiled from: profile/%s */
public class FbJsonChecker {
    public static final JsonToken m13811a(JsonParser jsonParser) {
        JsonToken c = jsonParser.mo1766c();
        m13812a(c);
        return c;
    }

    private static void m13812a(JsonToken jsonToken) {
        if (jsonToken == null) {
            throw new IOException("Unexpected end of json input");
        }
    }
}
