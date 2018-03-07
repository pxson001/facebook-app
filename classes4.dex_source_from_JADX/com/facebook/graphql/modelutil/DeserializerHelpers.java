package com.facebook.graphql.modelutil;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: sony */
public class DeserializerHelpers {
    public static int m2034a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        List arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(jsonParser.o());
            }
        }
        return flatBufferBuilder.c(arrayList);
    }

    public static int m2036b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        List arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(Integer.parseInt(jsonParser.o())));
            }
        }
        return flatBufferBuilder.a(arrayList);
    }

    public static int m2037c(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        List arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Long.valueOf(Long.parseLong(jsonParser.o())));
            }
        }
        return flatBufferBuilder.b(arrayList);
    }

    public static int m2035a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder, Class<? extends Enum> cls) {
        List arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                try {
                    arrayList.add(Enum.valueOf(cls, jsonParser.o().toUpperCase(Locale.US)));
                } catch (IllegalArgumentException e) {
                    arrayList.add(Enum.valueOf(cls, "UNSET_OR_UNRECOGNIZED_ENUM_VALUE"));
                }
            }
        }
        return flatBufferBuilder.e(arrayList);
    }
}
