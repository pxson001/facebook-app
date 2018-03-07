package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredSurveyCustomQuestionType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: mobile_jewel */
public class GraphQLStructuredSurveyConfiguredQuestionDeserializer {
    public static int m5997a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("allow_write_in_response")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("body")) {
                    iArr[1] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("custom_question_type")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLStructuredSurveyCustomQuestionType.fromString(jsonParser.o());
                } else if (i.equals("is_required")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("message")) {
                    iArr[4] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("question_class")) {
                    zArr[3] = true;
                    enumArr[1] = GraphQLStructuredSurveyQuestionType.fromString(jsonParser.o());
                } else if (i.equals("question_id")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("response_options")) {
                    iArr[7] = GraphQLStructuredSurveyResponseOptionDeserializer.m6012b(jsonParser, flatBufferBuilder);
                } else if (i.equals("subquestion_labels")) {
                    iArr[8] = GraphQLTextWithEntitiesDeserializer.m6059b(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(9);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[1]) {
            flatBufferBuilder.a(2, enumArr[0]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(3, zArr2[1]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[3]) {
            flatBufferBuilder.a(5, enumArr[1]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5998a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5997a(jsonParser, flatBufferBuilder);
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

    public static void m5999a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("allow_write_in_response");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("body");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 2, (short) 0) != (short) 0) {
            jsonGenerator.a("custom_question_type");
            jsonGenerator.b(((GraphQLStructuredSurveyCustomQuestionType) mutableFlatBuffer.a(i, 2, GraphQLStructuredSurveyCustomQuestionType.class)).name());
        }
        a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("is_required");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 5, (short) 0) != (short) 0) {
            jsonGenerator.a("question_class");
            jsonGenerator.b(((GraphQLStructuredSurveyQuestionType) mutableFlatBuffer.a(i, 5, GraphQLStructuredSurveyQuestionType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("question_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("response_options");
            GraphQLStructuredSurveyResponseOptionDeserializer.m6011a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("subquestion_labels");
            GraphQLTextWithEntitiesDeserializer.m6058a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
