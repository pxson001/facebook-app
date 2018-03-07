package com.facebook.productionprompts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPromptConfidence;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: rules */
public final class C0142xd632f9b {
    public static int m3292b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[1];
        double[] dArr = new double[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("id")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("prompt_confidence")) {
                    iArr[1] = flatBufferBuilder.a(GraphQLPromptConfidence.fromString(jsonParser.o()));
                } else if (i.equals("prompt_type")) {
                    iArr[2] = flatBufferBuilder.a(GraphQLPromptType.fromString(jsonParser.o()));
                } else if (i.equals("ranking_score")) {
                    zArr[0] = true;
                    dArr[0] = jsonParser.G();
                } else if (i.equals("tracking_string")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, dArr[0], 0.0d);
        }
        flatBufferBuilder.b(4, iArr[4]);
        return flatBufferBuilder.d();
    }

    public static void m3291a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("prompt_confidence");
            jsonGenerator.b(mutableFlatBuffer.b(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("prompt_type");
            jsonGenerator.b(mutableFlatBuffer.b(i, 2));
        }
        double a = mutableFlatBuffer.a(i, 3, 0.0d);
        if (a != 0.0d) {
            jsonGenerator.a("ranking_score");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("tracking_string");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        jsonGenerator.g();
    }
}
