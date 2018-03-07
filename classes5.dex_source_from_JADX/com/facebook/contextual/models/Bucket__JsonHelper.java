package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: action_url */
public final class Bucket__JsonHelper {
    public static Bucket m19730a(JsonParser jsonParser) {
        Bucket bucket = new Bucket();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            String o;
            int i2;
            if ("name".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    o = jsonParser.o();
                }
                bucket.f11602a = o;
                i2 = 1;
            } else if ("strategy".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    o = jsonParser.o();
                }
                bucket.f11603b = o;
                i2 = 1;
            } else if ("values".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    list = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        Double valueOf = Double.valueOf(jsonParser.G());
                        if (valueOf != null) {
                            list.add(valueOf);
                        }
                    }
                }
                bucket.f11604c = list;
                i2 = 1;
            }
            jsonParser.f();
        }
        return bucket;
    }
}
