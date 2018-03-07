package com.facebook.http.protocol;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fbot_orbot_signatures */
public class PartialJsonParser extends DepthCountingJsonParser {
    public PartialJsonParser(JsonParser jsonParser, boolean z) {
        super(jsonParser, z);
    }

    public void close() {
    }

    public final JsonToken mo894c() {
        if (this.f11948c < 0) {
            return null;
        }
        JsonToken c = this.f11950b.c();
        if (this.f11948c >= 0) {
            return c;
        }
        return null;
    }

    public final JsonParser mo895f() {
        if (this.f11948c < 0) {
            return null;
        }
        JsonParser f = this.f11950b.f();
        if (this.f11948c >= 0) {
            return f;
        }
        return null;
    }
}
