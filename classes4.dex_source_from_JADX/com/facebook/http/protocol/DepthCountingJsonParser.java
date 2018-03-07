package com.facebook.http.protocol;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.util.Iterator;

/* compiled from: fbpushnotif */
public class DepthCountingJsonParser extends JsonParserDelegate {
    public int f11948c;
    private final boolean f11949d;

    public DepthCountingJsonParser(JsonParser jsonParser, boolean z) {
        super(jsonParser);
        this.f11949d = z;
        if (!this.f11949d) {
            this.f11948c = 0;
        } else if (jsonParser instanceof DepthCountingJsonParser) {
            this.f11948c = ((DepthCountingJsonParser) jsonParser).f11948c;
        } else {
            this.f11948c = 0;
        }
    }

    public JsonToken mo894c() {
        JsonToken c = this.f11950b.c();
        if (c == JsonToken.START_ARRAY || c == JsonToken.START_OBJECT) {
            this.f11948c++;
        }
        if (c == JsonToken.END_ARRAY || c == JsonToken.END_OBJECT) {
            this.f11948c--;
        }
        return c;
    }

    private void mo892K() {
        if (g() == JsonToken.START_ARRAY || g() == JsonToken.START_OBJECT) {
            this.f11948c--;
        }
    }

    public final <T> T m12561a(Class<T> cls) {
        mo892K();
        return this.f11950b.a(cls);
    }

    public final <T> T m12560a(TypeReference<?> typeReference) {
        mo892K();
        return this.f11950b.a(typeReference);
    }

    public final <T> Iterator<T> m12562b(Class<T> cls) {
        mo892K();
        return this.f11950b.b(cls);
    }

    public final <T extends TreeNode> T m12559J() {
        mo892K();
        return this.f11950b.J();
    }

    public JsonParser mo895f() {
        if (!this.f11949d) {
            return super.mo895f();
        }
        long j = l()._totalChars;
        JsonParser f = super.mo895f();
        if (j >= l()._totalChars) {
            return f;
        }
        this.f11948c--;
        return f;
    }
}
