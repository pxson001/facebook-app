package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photoForLauncherShortcut */
public class GraphQLCouponDeserializer {
    public static int m4686a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[20];
        boolean[] zArr = new boolean[9];
        boolean[] zArr2 = new boolean[4];
        int[] iArr2 = new int[2];
        long[] jArr = new long[2];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("claim_count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("coupon_claim_location")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLCouponClaimLocation.fromString(jsonParser.o());
                } else if (i.equals("creation_story")) {
                    iArr[2] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("expiration_date")) {
                    zArr[2] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("filtered_claim_count")) {
                    zArr[3] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("has_viewer_claimed")) {
                    zArr[4] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("id")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_active")) {
                    zArr[5] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("is_expired")) {
                    zArr[6] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("is_stopped")) {
                    zArr[7] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("message")) {
                    iArr[10] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("mobile_post_claim_message")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("owning_page")) {
                    iArr[13] = GraphQLPageDeserializer.m5501a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photo")) {
                    iArr[14] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("redemption_code")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("redemption_url")) {
                    iArr[16] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("reminder_time")) {
                    zArr[8] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("terms")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(20);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[2]) {
            flatBufferBuilder.a(3, jArr[0], 0);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(4, iArr2[1], 0);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(5, zArr2[0]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        if (zArr[5]) {
            flatBufferBuilder.a(7, zArr2[1]);
        }
        if (zArr[6]) {
            flatBufferBuilder.a(8, zArr2[2]);
        }
        if (zArr[7]) {
            flatBufferBuilder.a(9, zArr2[3]);
        }
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        if (zArr[8]) {
            flatBufferBuilder.a(17, jArr[1], 0);
        }
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4687a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4686a(jsonParser, flatBufferBuilder);
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

    public static void m4688a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("claim_count");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("coupon_claim_location");
            jsonGenerator.b(((GraphQLCouponClaimLocation) mutableFlatBuffer.a(i, 1, GraphQLCouponClaimLocation.class)).name());
        }
        a = mutableFlatBuffer.g(i, 2);
        if (a != 0) {
            jsonGenerator.a("creation_story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        long a2 = mutableFlatBuffer.a(i, 3, 0);
        if (a2 != 0) {
            jsonGenerator.a("expiration_date");
            jsonGenerator.a(a2);
        }
        a = mutableFlatBuffer.a(i, 4, 0);
        if (a != 0) {
            jsonGenerator.a("filtered_claim_count");
            jsonGenerator.b(a);
        }
        boolean a3 = mutableFlatBuffer.a(i, 5);
        if (a3) {
            jsonGenerator.a("has_viewer_claimed");
            jsonGenerator.a(a3);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        a3 = mutableFlatBuffer.a(i, 7);
        if (a3) {
            jsonGenerator.a("is_active");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 8);
        if (a3) {
            jsonGenerator.a("is_expired");
            jsonGenerator.a(a3);
        }
        a3 = mutableFlatBuffer.a(i, 9);
        if (a3) {
            jsonGenerator.a("is_stopped");
            jsonGenerator.a(a3);
        }
        a = mutableFlatBuffer.g(i, 10);
        if (a != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("mobile_post_claim_message");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        a = mutableFlatBuffer.g(i, 13);
        if (a != 0) {
            jsonGenerator.a("owning_page");
            GraphQLPageDeserializer.m5505b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 14);
        if (a != 0) {
            jsonGenerator.a("photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("redemption_code");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        if (mutableFlatBuffer.g(i, 16) != 0) {
            jsonGenerator.a("redemption_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 16));
        }
        a2 = mutableFlatBuffer.a(i, 17, 0);
        if (a2 != 0) {
            jsonGenerator.a("reminder_time");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("terms");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        jsonGenerator.g();
    }
}
