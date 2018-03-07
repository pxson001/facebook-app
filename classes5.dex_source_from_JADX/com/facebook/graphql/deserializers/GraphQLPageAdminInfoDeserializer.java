package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: obfuscatedIdentifier */
public class GraphQLPageAdminInfoDeserializer {
    public static int m5492a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[19];
        boolean[] zArr = new boolean[13];
        boolean[] zArr2 = new boolean[10];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("all_scheduled_posts")) {
                    iArr[0] = GraphQLAllScheduledPostsConnectionDeserializer.m4555a(jsonParser, flatBufferBuilder);
                } else if (i.equals("boosted_local_awareness_promotion_status_description")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("boosted_page_like_promotion_status_description")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("boosted_post_default_audience")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLBoostedPostAudienceOption.fromString(jsonParser.o());
                } else if (i.equals("budget_recommendations")) {
                    iArr[4] = GraphQLBudgetRecommendationsConnectionDeserializer.m4621a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_promote")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("can_viewer_promote_for_page_likes")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_viewer_promote_local_awareness")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_promote_website")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("default_duration_for_boosted_post")) {
                    zArr[5] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("does_viewer_pin")) {
                    zArr[6] = true;
                    zArr2[4] = jsonParser.H();
                } else if (i.equals("has_boosted_posts")) {
                    zArr[7] = true;
                    zArr2[5] = jsonParser.H();
                } else if (i.equals("is_likely_to_advertise")) {
                    zArr[8] = true;
                    zArr2[6] = jsonParser.H();
                } else if (i.equals("is_viewer_business_manager_admin")) {
                    zArr[9] = true;
                    zArr2[7] = jsonParser.H();
                } else if (i.equals("messaging_enabled")) {
                    zArr[10] = true;
                    zArr2[8] = jsonParser.H();
                } else if (i.equals("page_scheduled_deletion_time")) {
                    zArr[11] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("viewer")) {
                    iArr[17] = GraphQLViewerDeserializer.m6199a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_viewer_promote_cta")) {
                    zArr[12] = true;
                    zArr2[9] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, enumArr[0]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[1]) {
            flatBufferBuilder.a(5, zArr2[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(6, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(7, zArr2[2]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(8, zArr2[3]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(9, iArr2[0], 0);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(10, zArr2[4]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(11, zArr2[5]);
        }
        if (zArr[8]) {
            flatBufferBuilder.a(12, zArr2[6]);
        }
        if (zArr[9]) {
            flatBufferBuilder.a(13, zArr2[7]);
        }
        if (zArr[10]) {
            flatBufferBuilder.a(15, zArr2[8]);
        }
        if (zArr[11]) {
            flatBufferBuilder.a(16, jArr[0], 0);
        }
        flatBufferBuilder.b(17, iArr[17]);
        if (zArr[12]) {
            flatBufferBuilder.a(18, zArr2[9]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5493a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5492a(jsonParser, flatBufferBuilder);
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

    public static void m5494a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("all_scheduled_posts");
            GraphQLAllScheduledPostsConnectionDeserializer.m4557a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("boosted_local_awareness_promotion_status_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("boosted_page_like_promotion_status_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("boosted_post_default_audience");
            jsonGenerator.b(((GraphQLBoostedPostAudienceOption) mutableFlatBuffer.a(i, 3, GraphQLBoostedPostAudienceOption.class)).name());
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("budget_recommendations");
            GraphQLBudgetRecommendationsConnectionDeserializer.m4623a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("can_viewer_promote");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("can_viewer_promote_for_page_likes");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("can_viewer_promote_local_awareness");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("can_viewer_promote_website");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.a(i, 9, 0);
        if (g != 0) {
            jsonGenerator.a("default_duration_for_boosted_post");
            jsonGenerator.b(g);
        }
        a = mutableFlatBuffer.a(i, 10);
        if (a) {
            jsonGenerator.a("does_viewer_pin");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 11);
        if (a) {
            jsonGenerator.a("has_boosted_posts");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 12);
        if (a) {
            jsonGenerator.a("is_likely_to_advertise");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 13);
        if (a) {
            jsonGenerator.a("is_viewer_business_manager_admin");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("messaging_enabled");
            jsonGenerator.a(a);
        }
        long a2 = mutableFlatBuffer.a(i, 16, 0);
        if (a2 != 0) {
            jsonGenerator.a("page_scheduled_deletion_time");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 17);
        if (g != 0) {
            jsonGenerator.a("viewer");
            GraphQLViewerDeserializer.m6201a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 18);
        if (a) {
            jsonGenerator.a("can_viewer_promote_cta");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
