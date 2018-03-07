package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: msgs */
public class GraphQLSouvenirMediaElementDeserializer {
    public static int m5912a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("id")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_highlighted")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("souvenir_media")) {
                    iArr[2] = GraphQLSouvenirMediaElementMediaConnectionDeserializer.m5915a(jsonParser, flatBufferBuilder);
                } else if (i.equals("souvenir_media_type")) {
                    zArr[1] = true;
                    enumArr[0] = GraphQLSouvenirMediaFieldType.fromString(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, zArr2[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[1]) {
            flatBufferBuilder.a(3, enumArr[0]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5913a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5912a(jsonParser, flatBufferBuilder);
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

    public static void m5914a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        boolean a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("is_highlighted");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("souvenir_media");
            GraphQLSouvenirMediaElementMediaConnectionDeserializer.m5917a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("souvenir_media_type");
            jsonGenerator.b(((GraphQLSouvenirMediaFieldType) mutableFlatBuffer.a(i, 3, GraphQLSouvenirMediaFieldType.class)).name());
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        jsonGenerator.g();
    }
}
