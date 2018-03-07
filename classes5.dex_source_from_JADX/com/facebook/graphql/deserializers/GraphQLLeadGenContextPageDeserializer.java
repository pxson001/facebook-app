package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLeadGenContextPageContentStyle;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: optin_decline_title */
public class GraphQLLeadGenContextPageDeserializer {
    public static int m5280a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[6];
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("context_content")) {
                    iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("context_content_style")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLLeadGenContextPageContentStyle.fromString(jsonParser.o());
                } else if (i.equals("context_cta")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("context_image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("context_title")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("context_card_photo")) {
                    iArr[5] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5281a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5280a(jsonParser, flatBufferBuilder);
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

    public static void m5282a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("context_content");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("context_content_style");
            jsonGenerator.b(((GraphQLLeadGenContextPageContentStyle) mutableFlatBuffer.a(i, 1, GraphQLLeadGenContextPageContentStyle.class)).name());
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("context_cta");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        int g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("context_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("context_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("context_card_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
