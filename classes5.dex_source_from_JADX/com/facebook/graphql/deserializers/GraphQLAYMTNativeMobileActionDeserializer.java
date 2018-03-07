package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: place_to_suggested_activity */
public class GraphQLAYMTNativeMobileActionDeserializer {
    public static int m4508a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("display_text")) {
                    iArr[1] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("uri")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4509a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4508a(jsonParser, flatBufferBuilder);
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

    public static void m4510a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("display_text");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("uri");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        jsonGenerator.g();
    }
}
