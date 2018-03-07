package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: place_tag */
public class GraphQLAYMTTipDeserializer {
    public static int m4511a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[11];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("action_text")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("action_uri")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("body_text")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image")) {
                    iArr[3] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("native_action_name")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLAYMTNativeAction.fromString(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("title_text")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("image_uri")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_dismissible")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("secondary_action_text")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("secondary_action_uri")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, enumArr[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, zArr2[0]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4512a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4511a(jsonParser, flatBufferBuilder);
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

    public static void m4513b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("action_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("action_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("body_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        int g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("native_action_name");
            jsonGenerator.b(((GraphQLAYMTNativeAction) mutableFlatBuffer.a(i, 4, GraphQLAYMTNativeAction.class)).name());
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("title_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("image_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        boolean a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("is_dismissible");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("secondary_action_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("secondary_action_uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        jsonGenerator.g();
    }
}
