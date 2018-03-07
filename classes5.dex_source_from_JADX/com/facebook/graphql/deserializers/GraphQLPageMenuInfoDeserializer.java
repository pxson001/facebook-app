package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: nuxLabel */
public class GraphQLPageMenuInfoDeserializer {
    public static int m5512a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("can_edit_menu")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("has_link_menus")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("has_photo_menus")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("has_structured_menu")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("url")) {
                    iArr[4] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(3, zArr2[3]);
        }
        flatBufferBuilder.b(4, iArr[4]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5513a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5512a(jsonParser, flatBufferBuilder);
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

    public static void m5514a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("can_edit_menu");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("has_link_menus");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("has_photo_menus");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("has_structured_menu");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 4) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 4));
        }
        jsonGenerator.g();
    }
}
