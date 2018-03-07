package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: refetched_after */
public class GraphQLPrivacyRowInputDeserializer {
    public static int m3905a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[4];
        boolean[] zArr = new boolean[2];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("allow")) {
                    iArr[0] = DeserializerHelpers.m2034a(jsonParser, flatBufferBuilder);
                } else if (i.equals("base_state")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLPrivacyBaseState.fromString(jsonParser.o());
                } else if (i.equals("deny")) {
                    iArr[2] = DeserializerHelpers.m2034a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tag_expansion_state")) {
                    zArr[1] = true;
                    enumArr[1] = GraphQLPrivacyTagExpansionState.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        flatBufferBuilder.b(2, iArr[2]);
        if (zArr[1]) {
            flatBufferBuilder.a(3, enumArr[1]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m3906a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m3905a(jsonParser, flatBufferBuilder);
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

    public static void m3907a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("allow");
            SerializerHelpers.m4182a(mutableFlatBuffer.f(i, 0), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("base_state");
            jsonGenerator.b(((GraphQLPrivacyBaseState) mutableFlatBuffer.a(i, 1, GraphQLPrivacyBaseState.class)).name());
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("deny");
            SerializerHelpers.m4182a(mutableFlatBuffer.f(i, 2), jsonGenerator);
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("tag_expansion_state");
            jsonGenerator.b(((GraphQLPrivacyTagExpansionState) mutableFlatBuffer.a(i, 3, GraphQLPrivacyTagExpansionState.class)).name());
        }
        jsonGenerator.g();
    }
}
