package com.facebook.feedback.reactions.api;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: selectedPrivacyOption */
public final class C0131xc2fb8d3 {
    public static int m3129a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[3];
        int[] iArr2 = new int[2];
        double[] dArr = new double[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("height")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("name")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("scale")) {
                    zArr[1] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("uri")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("width")) {
                    zArr[2] = true;
                    iArr2[1] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[1]) {
            flatBufferBuilder.a(2, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[2]) {
            flatBufferBuilder.a(4, iArr2[1], 0);
        }
        return flatBufferBuilder.d();
    }

    public static void m3130a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("height");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        double a2 = mutableFlatBuffer.a(i, 2, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("scale");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("width");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}
