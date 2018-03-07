package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: mobile_ios_place_creation */
public class GraphQLStructuredSurveyQuestionDeserializer {
    public static int m6003a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[7];
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("body")) {
                    iArr[0] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("message")) {
                    iArr[2] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("name")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("question_class")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLStructuredSurveyQuestionType.fromString(jsonParser.o());
                } else if (i.equals("response_options")) {
                    iArr[5] = GraphQLStructuredSurveyResponseOptionDeserializer.m6012b(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, enumArr[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m6004a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6003a(jsonParser, flatBufferBuilder);
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

    public static void m6005b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("body");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("question_class");
            jsonGenerator.b(((GraphQLStructuredSurveyQuestionType) mutableFlatBuffer.a(i, 4, GraphQLStructuredSurveyQuestionType.class)).name());
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("response_options");
            GraphQLStructuredSurveyResponseOptionDeserializer.m6011a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        jsonGenerator.g();
    }
}
