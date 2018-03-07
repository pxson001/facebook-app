package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: page_admin_overview_promotions_card */
public class GraphQLGraphSearchQueryFilterDeserializer {
    public static int m5089a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[10];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("current_value")) {
                    iArr[0] = GraphQLGraphSearchQueryFilterValueDeserializer.m5097a(jsonParser, flatBufferBuilder);
                } else if (i.equals("custom_value")) {
                    iArr[1] = GraphQLGraphSearchQueryFilterCustomValueDeserializer.m5086a(jsonParser, flatBufferBuilder);
                } else if (i.equals("default_option_text")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("filter_values")) {
                    iArr[4] = GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5100a(jsonParser, flatBufferBuilder);
                } else if (i.equals("handle")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("id")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("text")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("search_place_holder")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5090a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5089a(jsonParser, flatBufferBuilder);
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

    public static void m5091a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("current_value");
            GraphQLGraphSearchQueryFilterValueDeserializer.m5099b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("custom_value");
            GraphQLGraphSearchQueryFilterCustomValueDeserializer.m5088a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("default_option_text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("filter_values");
            GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5102a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("handle");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("text");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("search_place_holder");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        jsonGenerator.g();
    }
}
