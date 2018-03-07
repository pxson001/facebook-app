package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLContactFieldLabelType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photoUrl */
public class GraphQLContactRecommendationFieldDeserializer {
    public static int m4683a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[16];
        boolean[] zArr = new boolean[3];
        int[] iArr2 = new int[1];
        long[] jArr = new long[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("creation_time")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("creator")) {
                    iArr[1] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[2] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[4] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("label")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("label_type")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLContactFieldLabelType.fromString(jsonParser.o());
                } else if (i.equals("page_rating")) {
                    zArr[2] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("photos")) {
                    iArr[8] = GraphQLPhotoDeserializer.m5604b(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[9] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageLarge")) {
                    iArr[10] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("profileImageSmall")) {
                    iArr[11] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("represented_profile")) {
                    iArr[12] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("story")) {
                    iArr[13] = GraphQLStoryDeserializer.m5962a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("value")) {
                    iArr[15] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(16);
        if (zArr[0]) {
            flatBufferBuilder.a(0, jArr[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, enumArr[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(7, iArr2[0], 0);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4684a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4683a(jsonParser, flatBufferBuilder);
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

    public static void m4685a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        long a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("creator");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.a(i, 6, (short) 0) != (short) 0) {
            jsonGenerator.a("label_type");
            jsonGenerator.b(((GraphQLContactFieldLabelType) mutableFlatBuffer.a(i, 6, GraphQLContactFieldLabelType.class)).name());
        }
        g = mutableFlatBuffer.a(i, 7, 0);
        if (g != 0) {
            jsonGenerator.a("page_rating");
            jsonGenerator.b(g);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("photos");
            GraphQLPhotoDeserializer.m5603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("represented_profile");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("story");
            GraphQLStoryDeserializer.m5966b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("value");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
