package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBumpReason;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: og-tagger-click */
public class GraphQLNewsFeedEdgeDeserializer {
    public static int m5424a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[2];
        double[] dArr = new double[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("bump_reason")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLBumpReason.fromString(jsonParser.o());
                } else if (i.equals("cursor")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("deduplication_key")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("disallow_first_position")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("features_meta")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_in_low_engagement_block")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("node")) {
                    iArr[6] = FeedUnitDeserializerResolver.m4503a(jsonParser, flatBufferBuilder);
                } else if (i.equals("ranking_weight")) {
                    zArr[3] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("sort_key")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(9);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[1]) {
            flatBufferBuilder.a(3, zArr2[0]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[2]) {
            flatBufferBuilder.a(5, zArr2[1]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        if (zArr[3]) {
            flatBufferBuilder.a(7, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(8, iArr[8]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5425a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5424a(jsonParser, flatBufferBuilder);
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

    public static void m5426b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("bump_reason");
            jsonGenerator.b(((GraphQLBumpReason) mutableFlatBuffer.a(i, 0, GraphQLBumpReason.class)).name());
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("cursor");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("deduplication_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        boolean a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("disallow_first_position");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("features_meta");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("is_in_low_engagement_block");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("node");
            FeedUnitDeserializerResolver.m4504a(mutableFlatBuffer, g, 6, jsonGenerator, serializerProvider);
        }
        double a2 = mutableFlatBuffer.a(i, 7, 0.0d);
        if (a2 != 0.0d) {
            jsonGenerator.a("ranking_weight");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("sort_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        jsonGenerator.g();
    }
}
