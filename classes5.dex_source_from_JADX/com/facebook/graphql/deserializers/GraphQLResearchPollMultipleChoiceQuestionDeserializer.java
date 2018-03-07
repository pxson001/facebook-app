package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLResearchPollQuestionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: narrowPortraitImage */
public class GraphQLResearchPollMultipleChoiceQuestionDeserializer {
    public static int m5813a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[8];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("hide_responses")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("id")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("next_question")) {
                    iArr[2] = m5813a(jsonParser, flatBufferBuilder);
                } else if (i.equals("question_responders")) {
                    iArr[3] = GraphQLResearchPollQuestionRespondersConnectionDeserializer.m5821a(jsonParser, flatBufferBuilder);
                } else if (i.equals("question_type")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLResearchPollQuestionType.fromString(jsonParser.o());
                } else if (i.equals("research_poll_question")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("responses")) {
                    iArr[6] = GraphQLResearchPollQuestionResponsesConnectionDeserializer.m5824a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(8);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[1]) {
            flatBufferBuilder.a(4, enumArr[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        return flatBufferBuilder.d();
    }

    public static int m5816b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5813a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static MutableFlatBuffer m5814a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5813a(jsonParser, flatBufferBuilder);
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

    public static void m5815a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5817b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5817b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("hide_responses");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("next_question");
            m5817b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("question_responders");
            GraphQLResearchPollQuestionRespondersConnectionDeserializer.m5823a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("question_type");
            jsonGenerator.b(((GraphQLResearchPollQuestionType) mutableFlatBuffer.a(i, 4, GraphQLResearchPollQuestionType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("research_poll_question");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("responses");
            GraphQLResearchPollQuestionResponsesConnectionDeserializer.m5826a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        jsonGenerator.g();
    }
}
