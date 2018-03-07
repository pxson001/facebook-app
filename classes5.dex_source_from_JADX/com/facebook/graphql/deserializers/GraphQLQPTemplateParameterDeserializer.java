package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: needy_page_suggestion_megaphone */
public class GraphQLQPTemplateParameterDeserializer {
    public static int m5728a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[4];
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("__type__")) {
                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser).e());
                } else if (i.equals("name")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("required")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("string_value")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, zArr2[0]);
        }
        flatBufferBuilder.b(3, iArr[3]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5729a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5728a(jsonParser, flatBufferBuilder);
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

    public static void m5730a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.a(mutableFlatBuffer, i, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        boolean a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("required");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("string_value");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        jsonGenerator.g();
    }
}
