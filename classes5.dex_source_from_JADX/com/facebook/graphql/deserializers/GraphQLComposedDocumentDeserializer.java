package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_hash */
public class GraphQLComposedDocumentDeserializer {
    public static int m4668a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[5];
        long[] jArr = new long[3];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("creation_time")) {
                    zArr[0] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("document_owner")) {
                    iArr[1] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[2] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback_options")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLDocumentFeedbackOptions.fromString(jsonParser.o());
                } else if (i.equals("format_version")) {
                    zArr[2] = true;
                    enumArr[1] = GraphQLDocumentFormatVersion.fromString(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("modified_timestamp")) {
                    zArr[3] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("publish_timestamp")) {
                    zArr[4] = true;
                    jArr[2] = jsonParser.F();
                } else if (i.equals("url")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(9);
        if (zArr[0]) {
            flatBufferBuilder.a(0, jArr[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[1]) {
            flatBufferBuilder.a(3, enumArr[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(4, enumArr[1]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[3]) {
            flatBufferBuilder.a(6, jArr[1], 0);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(7, jArr[2], 0);
        }
        flatBufferBuilder.b(8, iArr[8]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4669a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4668a(jsonParser, flatBufferBuilder);
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

    public static void m4670a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        long a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("creation_time");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("document_owner");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("feedback_options");
            jsonGenerator.b(((GraphQLDocumentFeedbackOptions) mutableFlatBuffer.a(i, 3, GraphQLDocumentFeedbackOptions.class)).name());
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("format_version");
            jsonGenerator.b(((GraphQLDocumentFormatVersion) mutableFlatBuffer.a(i, 4, GraphQLDocumentFormatVersion.class)).name());
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        a = mutableFlatBuffer.a(i, 6, 0);
        if (a != 0) {
            jsonGenerator.a("modified_timestamp");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7, 0);
        if (a != 0) {
            jsonGenerator.a("publish_timestamp");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        jsonGenerator.g();
    }
}
