package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: phone_screenshots */
public class GraphQLCurrencyQuantityDeserializer {
    public static int m4700a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[6];
        boolean[] zArr = new boolean[3];
        int[] iArr2 = new int[2];
        double[] dArr = new double[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("amount")) {
                    zArr[0] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("amount_with_offset")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("currency")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("formatted")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("offset")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("offset_amount")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(6);
        if (zArr[0]) {
            flatBufferBuilder.a(0, dArr[0], 0.0d);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr2[0], 0);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[2]) {
            flatBufferBuilder.a(4, iArr2[1], 0);
        }
        flatBufferBuilder.b(5, iArr[5]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4701a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4700a(jsonParser, flatBufferBuilder);
        if (1 != 0) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, s, 0);
            flatBufferBuilder.b(1, a);
            a = flatBufferBuilder.d();
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        return mutableFlatBuffer;
    }

    public static void m4702a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        double a = mutableFlatBuffer.a(i, 0, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("amount");
            jsonGenerator.a(a);
        }
        int a2 = mutableFlatBuffer.a(i, 1, 0);
        if (a2 != 0) {
            jsonGenerator.a("amount_with_offset");
            jsonGenerator.b(a2);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("currency");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("formatted");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        a2 = mutableFlatBuffer.a(i, 4, 0);
        if (a2 != 0) {
            jsonGenerator.a("offset");
            jsonGenerator.b(a2);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("offset_amount");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        jsonGenerator.g();
    }
}
