package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: oh_hide_attachment */
public class GraphQLMobilePageAdminPanelFeedUnitDeserializer {
    public static int m5370a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[1];
        long[] jArr = new long[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("cache_id")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("debug_info")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fetchTimeMs")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("hideable_token")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("items")) {
                    iArr[4] = GraphQLMobilePageAdminPanelFeedUnitItemDeserializer.m5375b(jsonParser, flatBufferBuilder);
                } else if (i.equals("negative_feedback_actions")) {
                    iArr[5] = GraphQLNegativeFeedbackActionsConnectionDeserializer.m5415a(jsonParser, flatBufferBuilder);
                } else if (i.equals("short_term_cache_key")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title")) {
                    iArr[7] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tracking")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, jArr[0], 0);
        }
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5371a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5370a(jsonParser, flatBufferBuilder);
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

    public static void m5372a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("cache_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("debug_info");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        long a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("fetchTimeMs");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("hideable_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        int g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("items");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLMobilePageAdminPanelFeedUnitItemDeserializer.m5376b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("short_term_cache_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        jsonGenerator.g();
    }
}
