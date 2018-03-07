package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: closed */
public class JsonParserSequence extends JsonParserDelegate {
    protected final JsonParser[] f5966c;
    protected int f5967d = 1;

    private JsonParserSequence(JsonParser[] jsonParserArr) {
        super(jsonParserArr[0]);
        this.f5966c = jsonParserArr;
    }

    public static JsonParserSequence m10764a(JsonParser jsonParser, JsonParser jsonParser2) {
        if ((jsonParser instanceof JsonParserSequence) || (jsonParser2 instanceof JsonParserSequence)) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser instanceof JsonParserSequence) {
                ((JsonParserSequence) jsonParser).m10765a(arrayList);
            } else {
                arrayList.add(jsonParser);
            }
            if (jsonParser2 instanceof JsonParserSequence) {
                ((JsonParserSequence) jsonParser2).m10765a(arrayList);
            } else {
                arrayList.add(jsonParser2);
            }
            return new JsonParserSequence((JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
        }
        return new JsonParserSequence(new JsonParser[]{jsonParser, jsonParser2});
    }

    private void m10765a(List<JsonParser> list) {
        int i = this.f5967d - 1;
        int length = this.f5966c.length;
        for (int i2 = i; i2 < length; i2++) {
            Object obj = this.f5966c[i2];
            if (obj instanceof JsonParserSequence) {
                ((JsonParserSequence) obj).m10765a(list);
            } else {
                list.add(obj);
            }
        }
    }

    public void close() {
        do {
            this.b.close();
        } while (m10763K());
    }

    public final JsonToken m10766c() {
        JsonToken c = this.b.c();
        if (c != null) {
            return c;
        }
        while (m10763K()) {
            c = this.b.c();
            if (c != null) {
                return c;
            }
        }
        return null;
    }

    private boolean m10763K() {
        if (this.f5967d >= this.f5966c.length) {
            return false;
        }
        JsonParser[] jsonParserArr = this.f5966c;
        int i = this.f5967d;
        this.f5967d = i + 1;
        this.b = jsonParserArr[i];
        return true;
    }
}
