package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: nux_title */
public class GraphQLPageCallToActionDeserializer {
    public static int m5498a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[15];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("ads_cta_type")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLCallToActionType.fromString(jsonParser.o());
                } else if (i.equals("android_deep_link")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("android_package_name")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("application")) {
                    iArr[3] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("cta_type")) {
                    zArr[1] = true;
                    enumArr[1] = GraphQLPageCallToActionType.fromString(jsonParser.o());
                } else if (i.equals("desktop_uri")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("email_address")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("fallback_uri")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_first_party")) {
                    zArr[2] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("label")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("phone_number")) {
                    iArr[11] = GraphQLPhoneNumberDeserializer.m5598a(jsonParser, flatBufferBuilder);
                } else if (i.equals("status")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("autofill_enabled_on_fallback")) {
                    zArr[3] = true;
                    zArr2[1] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(15);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, enumArr[1]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[2]) {
            flatBufferBuilder.a(9, zArr2[0]);
        }
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        if (zArr[3]) {
            flatBufferBuilder.a(14, zArr2[1]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5499a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5498a(jsonParser, flatBufferBuilder);
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

    public static void m5500a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("ads_cta_type");
            jsonGenerator.b(((GraphQLCallToActionType) mutableFlatBuffer.a(i, 0, GraphQLCallToActionType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("android_deep_link");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("android_package_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        int g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("application");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("cta_type");
            jsonGenerator.b(((GraphQLPageCallToActionType) mutableFlatBuffer.a(i, 4, GraphQLPageCallToActionType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("desktop_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("email_address");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("fallback_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        boolean a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("is_first_party");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("phone_number");
            GraphQLPhoneNumberDeserializer.m5600a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("status");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        a = mutableFlatBuffer.a(i, 14);
        if (a) {
            jsonGenerator.a("autofill_enabled_on_fallback");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
