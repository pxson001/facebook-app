package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_tag_dialog */
public class GraphQLFeedbackReactionInfoDeserializer {
    public static int m4901a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[1];
        int[] iArr2 = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("color")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_deprecated")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("key")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("largeFaceImage")) {
                    iArr[4] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("localized_name")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("smallFaceImage")) {
                    iArr[6] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tabIconImage")) {
                    iArr[7] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
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
            flatBufferBuilder.a(2, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(3, iArr2[0], 0);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4902a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4901a(jsonParser, flatBufferBuilder);
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

    public static void m4903a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        boolean a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("is_deprecated");
            jsonGenerator.a(a);
        }
        int a2 = mutableFlatBuffer.a(i, 3, 0);
        if (a2 != 0) {
            jsonGenerator.a("key");
            jsonGenerator.b(a2);
        }
        a2 = mutableFlatBuffer.g(i, 4);
        if (a2 != 0) {
            jsonGenerator.a("largeFaceImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("localized_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        a2 = mutableFlatBuffer.g(i, 6);
        if (a2 != 0) {
            jsonGenerator.a("smallFaceImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        a2 = mutableFlatBuffer.g(i, 7);
        if (a2 != 0) {
            jsonGenerator.a("tabIconImage");
            GraphQLImageDeserializer.a(mutableFlatBuffer, a2, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        jsonGenerator.g();
    }
}
