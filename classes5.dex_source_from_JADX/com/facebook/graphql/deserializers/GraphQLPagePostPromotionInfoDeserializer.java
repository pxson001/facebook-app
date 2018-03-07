package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: number_of_keystrokes */
public class GraphQLPagePostPromotionInfoDeserializer {
    public static int m5518a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[13];
        boolean[] zArr = new boolean[6];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[2];
        long[] jArr = new long[1];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("ad_account")) {
                    iArr[0] = GraphQLAdAccountDeserializer.m4522a(jsonParser, flatBufferBuilder);
                } else if (i.equals("audience_option")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLBoostedPostAudienceOption.fromString(jsonParser.o());
                } else if (i.equals("budget")) {
                    iArr[2] = GraphQLCurrencyQuantityDeserializer.m4700a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feed_unit_preview")) {
                    iArr[3] = FeedUnitDeserializerResolver.m4503a(jsonParser, flatBufferBuilder);
                } else if (i.equals("has_ad_conversion_pixel_domain")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("ineligible_reason")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("paid_reach")) {
                    zArr[2] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("promotion_id")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("rejection_reason")) {
                    iArr[8] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("spent")) {
                    zArr[3] = true;
                    iArr2[1] = jsonParser.E();
                } else if (i.equals("status")) {
                    zArr[4] = true;
                    enumArr[1] = GraphQLBoostedPostStatus.fromString(jsonParser.o());
                } else if (i.equals("stop_time")) {
                    zArr[5] = true;
                    jArr[0] = jsonParser.F();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[2]) {
            flatBufferBuilder.a(6, iArr2[0], 0);
        }
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[3]) {
            flatBufferBuilder.a(9, iArr2[1], 0);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(10, enumArr[1]);
        }
        if (zArr[5]) {
            flatBufferBuilder.a(11, jArr[0], 0);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5519a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5518a(jsonParser, flatBufferBuilder);
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

    public static void m5520a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("ad_account");
            GraphQLAdAccountDeserializer.m4524a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("audience_option");
            jsonGenerator.b(((GraphQLBoostedPostAudienceOption) mutableFlatBuffer.a(i, 1, GraphQLBoostedPostAudienceOption.class)).name());
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("budget");
            GraphQLCurrencyQuantityDeserializer.m4702a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("feed_unit_preview");
            FeedUnitDeserializerResolver.m4504a(mutableFlatBuffer, g, 3, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("has_ad_conversion_pixel_domain");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("ineligible_reason");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.a(i, 6, 0);
        if (g != 0) {
            jsonGenerator.a("paid_reach");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("promotion_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("rejection_reason");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 9, 0);
        if (g != 0) {
            jsonGenerator.a("spent");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.a(i, 10, (short) 0) != (short) 0) {
            jsonGenerator.a("status");
            jsonGenerator.b(((GraphQLBoostedPostStatus) mutableFlatBuffer.a(i, 10, GraphQLBoostedPostStatus.class)).name());
        }
        long a2 = mutableFlatBuffer.a(i, 11, 0);
        if (a2 != 0) {
            jsonGenerator.a("stop_time");
            jsonGenerator.a(a2);
        }
        jsonGenerator.g();
    }
}
