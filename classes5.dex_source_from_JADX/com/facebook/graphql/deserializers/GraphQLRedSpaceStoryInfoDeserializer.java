package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLRedSpaceVisibilityState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: native_app_url_segue */
public class GraphQLRedSpaceStoryInfoDeserializer {
    public static int m5796a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("visibility_state")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLRedSpaceVisibilityState.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(1);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5797a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5796a(jsonParser, flatBufferBuilder);
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

    public static void m5798a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("visibility_state");
            jsonGenerator.b(((GraphQLRedSpaceVisibilityState) mutableFlatBuffer.a(i, 0, GraphQLRedSpaceVisibilityState.class)).name());
        }
        jsonGenerator.g();
    }
}
