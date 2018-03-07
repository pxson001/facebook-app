package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: actionIntent */
public final class Output__JsonHelper {
    public static Output m19735a(JsonParser jsonParser) {
        Output output = new Output();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String str = null;
            int i2;
            if ("name".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                output.f11625a = str;
                i2 = 1;
            } else if ("type".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                output.f11626b = str;
                i2 = 1;
            }
            jsonParser.f();
        }
        return output;
    }
}
