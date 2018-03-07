package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: soft_error_category */
public final class CommonGraphQLParsers$DefaultImageFieldsParser {
    public static int m2039a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        boolean[] zArr = new boolean[2];
        int[] iArr2 = new int[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("height")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("uri")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("width")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[1]) {
            flatBufferBuilder.a(2, iArr2[1], 0);
        }
        return flatBufferBuilder.d();
    }

    public static int m2042b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m2039a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static void m2041a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m2040a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
        }
        jsonGenerator.e();
    }

    public static void m2040a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("height");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("width");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}
