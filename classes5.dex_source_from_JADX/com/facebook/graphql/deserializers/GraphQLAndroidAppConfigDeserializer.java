package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: place_entities */
public class GraphQLAndroidAppConfigDeserializer {
    public static int m4561a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[4];
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("can_deeplink")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("class_name")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("key_hashes")) {
                    iArr[2] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("package_name")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(4);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4562a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4561a(jsonParser, flatBufferBuilder);
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

    public static void m4563a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("can_deeplink");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("class_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("key_hashes");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 2), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("package_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        jsonGenerator.g();
    }
}
