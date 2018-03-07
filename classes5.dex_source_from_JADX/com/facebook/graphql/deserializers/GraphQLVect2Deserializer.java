package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: messenger_entry_profile */
public class GraphQLVect2Deserializer {
    public static int m6165a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[2];
        double[] dArr = new double[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("x")) {
                    zArr[0] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("y")) {
                    zArr[1] = true;
                    dArr[1] = jsonParser.G();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(2);
        if (zArr[0]) {
            flatBufferBuilder.a(0, dArr[0], 0.0d);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, dArr[1], 0.0d);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6166a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6165a(jsonParser, flatBufferBuilder);
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

    public static void m6167a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        double a = mutableFlatBuffer.a(i, 0, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("x");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("y");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
