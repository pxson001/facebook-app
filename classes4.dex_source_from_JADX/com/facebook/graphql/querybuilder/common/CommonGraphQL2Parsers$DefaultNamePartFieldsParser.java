package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.ArrayList;

/* compiled from: soft error */
public final class CommonGraphQL2Parsers$DefaultNamePartFieldsParser {
    public static int m2048b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        boolean[] zArr = new boolean[2];
        int[] iArr2 = new int[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("length")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("offset")) {
                    zArr[1] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("part")) {
                    iArr[2] = flatBufferBuilder.a(GraphQLStructuredNamePart.fromString(jsonParser.o()));
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr2[1], 0);
        }
        flatBufferBuilder.b(2, iArr[2]);
        return flatBufferBuilder.d();
    }

    public static int m2045a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m2048b(jsonParser, flatBufferBuilder)));
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

    public static void m2047a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m2046a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
        }
        jsonGenerator.e();
    }

    public static void m2046a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("length");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("offset");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("part");
            jsonGenerator.b(mutableFlatBuffer.b(i, 2));
        }
        jsonGenerator.g();
    }
}
