package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: actionTitle */
public final class OutputValue__JsonHelper {
    public static OutputValue m19734a(JsonParser jsonParser) {
        OutputValue outputValue = new OutputValue();
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
                outputValue.f11627a = str;
                i2 = 1;
            } else if ("value".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    str = jsonParser.o();
                }
                outputValue.f11628b = str;
                i2 = 1;
            }
            jsonParser.f();
        }
        return outputValue;
    }
}
