package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_visits */
public class GraphQLFeedHomeStoriesDeserializer {
    public static int m4879a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[8];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("approximate_new_unit_count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("debug_info")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("edges")) {
                    iArr[2] = GraphQLFeedUnitEdgeDeserializer.m4887b(jsonParser, flatBufferBuilder);
                } else if (i.equals("low_engagement_deduplication_keys")) {
                    iArr[3] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("no_feed_polling")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("page_info")) {
                    iArr[5] = GraphQLPageInfoDeserializer.m5506a(jsonParser, flatBufferBuilder);
                } else if (i.equals("query_function")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("query_title")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(8);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4880a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4879a(jsonParser, flatBufferBuilder);
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

    public static void m4881a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("approximate_new_unit_count");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        a = mutableFlatBuffer.g(i, 2);
        if (a != 0) {
            jsonGenerator.a("edges");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                GraphQLFeedUnitEdgeDeserializer.m4888b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("low_engagement_deduplication_keys");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 3), jsonGenerator);
        }
        boolean a2 = mutableFlatBuffer.a(i, 4);
        if (a2) {
            jsonGenerator.a("no_feed_polling");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.g(i, 5);
        if (a != 0) {
            jsonGenerator.a("page_info");
            GraphQLPageInfoDeserializer.m5508a(mutableFlatBuffer, a, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("query_function");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("query_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        jsonGenerator.g();
    }
}
