package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: msite_timeline_action_menu_report_page */
public class GraphQLSeenByConnectionDeserializer {
    public static int m5877a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        boolean[] zArr = new boolean[1];
        int[] iArr2 = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("count")) {
                    zArr[0] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("nodes")) {
                    iArr[1] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("page_info")) {
                    iArr[2] = GraphQLPageInfoDeserializer.m5506a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr2[0], 0);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5878a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5877a(jsonParser, flatBufferBuilder);
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

    public static void m5879a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.g(i, 1);
        if (a != 0) {
            jsonGenerator.a("nodes");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.g(i, 2);
        if (a != 0) {
            jsonGenerator.a("page_info");
            GraphQLPageInfoDeserializer.m5508a(mutableFlatBuffer, a, jsonGenerator);
        }
        jsonGenerator.g();
    }
}
