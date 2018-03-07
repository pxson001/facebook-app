package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: pending_place */
public class GraphQLEntityCardContextItemDeserializer {
    public static int m4750a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[8];
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("fallback_url")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("icon")) {
                    iArr[1] = GraphQLEntityCardContextItemIconDeserializer.m4753a(jsonParser, flatBufferBuilder);
                } else if (i.equals("item_links")) {
                    iArr[2] = GraphQLEntityCardContextItemLinkDeserializer.m4759b(jsonParser, flatBufferBuilder);
                } else if (i.equals("item_type")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLEntityCardContextItemType.fromString(jsonParser.o());
                } else if (i.equals("logging_param")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("subtitle")) {
                    iArr[5] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[6] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title_color")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[0]) {
            flatBufferBuilder.a(3, enumArr[0]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4751a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4750a(jsonParser, flatBufferBuilder);
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

    public static void m4752b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("fallback_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("icon");
            GraphQLEntityCardContextItemIconDeserializer.m4755a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("item_links");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLEntityCardContextItemLinkDeserializer.m4758a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("item_type");
            jsonGenerator.b(((GraphQLEntityCardContextItemType) mutableFlatBuffer.a(i, 3, GraphQLEntityCardContextItemType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("logging_param");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("title_color");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        jsonGenerator.g();
    }
}
