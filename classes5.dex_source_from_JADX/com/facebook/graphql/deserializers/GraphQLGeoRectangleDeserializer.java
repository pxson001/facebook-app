package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: page_migration */
public class GraphQLGeoRectangleDeserializer {
    public static int m4993a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[4];
        double[] dArr = new double[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("east")) {
                    zArr[0] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("north")) {
                    zArr[1] = true;
                    dArr[1] = jsonParser.G();
                } else if (i.equals("south")) {
                    zArr[2] = true;
                    dArr[2] = jsonParser.G();
                } else if (i.equals("west")) {
                    zArr[3] = true;
                    dArr[3] = jsonParser.G();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(4);
        if (zArr[0]) {
            flatBufferBuilder.a(0, dArr[0], 0.0d);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, dArr[1], 0.0d);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, dArr[2], 0.0d);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(3, dArr[3], 0.0d);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4994a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4993a(jsonParser, flatBufferBuilder);
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

    public static void m4995a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        double a = mutableFlatBuffer.a(i, 0, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("east");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("north");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 2, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("south");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 3, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("west");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
