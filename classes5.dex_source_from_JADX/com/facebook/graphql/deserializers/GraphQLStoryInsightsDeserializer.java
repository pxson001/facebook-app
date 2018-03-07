package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: mobile_post_claim_message */
public class GraphQLStoryInsightsDeserializer {
    public static int m5973a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[10];
        int[] iArr = new int[10];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("best_post_reach")) {
                    zArr[0] = true;
                    iArr[0] = jsonParser.E();
                } else if (i.equals("engaged_user_count")) {
                    zArr[1] = true;
                    iArr[1] = jsonParser.E();
                } else if (i.equals("linkClicks")) {
                    zArr[2] = true;
                    iArr[2] = jsonParser.E();
                } else if (i.equals("organic_reach")) {
                    zArr[3] = true;
                    iArr[3] = jsonParser.E();
                } else if (i.equals("otherClicks")) {
                    zArr[4] = true;
                    iArr[4] = jsonParser.E();
                } else if (i.equals("paid_reach")) {
                    zArr[5] = true;
                    iArr[5] = jsonParser.E();
                } else if (i.equals("photoViews")) {
                    zArr[6] = true;
                    iArr[6] = jsonParser.E();
                } else if (i.equals("totalClicks")) {
                    zArr[7] = true;
                    iArr[7] = jsonParser.E();
                } else if (i.equals("total_reach")) {
                    zArr[8] = true;
                    iArr[8] = jsonParser.E();
                } else if (i.equals("videoPlays")) {
                    zArr[9] = true;
                    iArr[9] = jsonParser.E();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(10);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, iArr[2], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(3, iArr[3], 0);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(4, iArr[4], 0);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(5, iArr[5], 0);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(6, iArr[6], 0);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(7, iArr[7], 0);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(8, iArr[8], 0);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(9, iArr[9], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5974a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5973a(jsonParser, flatBufferBuilder);
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

    public static void m5975a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("best_post_reach");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("engaged_user_count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 2, 0);
        if (a != 0) {
            jsonGenerator.a("linkClicks");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 3, 0);
        if (a != 0) {
            jsonGenerator.a("organic_reach");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("otherClicks");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 5, 0);
        if (a != 0) {
            jsonGenerator.a("paid_reach");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 6, 0);
        if (a != 0) {
            jsonGenerator.a("photoViews");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 7, 0);
        if (a != 0) {
            jsonGenerator.a("totalClicks");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 8, 0);
        if (a != 0) {
            jsonGenerator.a("total_reach");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 9, 0);
        if (a != 0) {
            jsonGenerator.a("videoPlays");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }
}
