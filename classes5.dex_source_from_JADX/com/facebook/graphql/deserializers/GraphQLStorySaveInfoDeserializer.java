package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveNuxType;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: mobile_platform_native_like_button */
public class GraphQLStorySaveInfoDeserializer {
    public static int m5976a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[5];
        int[] iArr = new int[2];
        Enum[] enumArr = new Enum[3];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("story_save_nux_max_consume_duration")) {
                    zArr[0] = true;
                    iArr[0] = jsonParser.E();
                } else if (i.equals("story_save_nux_min_consume_duration")) {
                    zArr[1] = true;
                    iArr[1] = jsonParser.E();
                } else if (i.equals("story_save_nux_type")) {
                    zArr[2] = true;
                    enumArr[0] = GraphQLStorySaveNuxType.fromString(jsonParser.o());
                } else if (i.equals("story_save_type")) {
                    zArr[3] = true;
                    enumArr[1] = GraphQLStorySaveType.fromString(jsonParser.o());
                } else if (i.equals("viewer_save_state")) {
                    zArr[4] = true;
                    enumArr[2] = GraphQLSavedState.fromString(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        if (zArr[0]) {
            flatBufferBuilder.a(0, iArr[0], 0);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(1, iArr[1], 0);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(2, enumArr[0]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(3, enumArr[1]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(4, enumArr[2]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5977a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5976a(jsonParser, flatBufferBuilder);
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

    public static void m5978a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(i, 0, 0);
        if (a != 0) {
            jsonGenerator.a("story_save_nux_max_consume_duration");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(i, 1, 0);
        if (a != 0) {
            jsonGenerator.a("story_save_nux_min_consume_duration");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.a(i, 2, (short) 0) != (short) 0) {
            jsonGenerator.a("story_save_nux_type");
            jsonGenerator.b(((GraphQLStorySaveNuxType) mutableFlatBuffer.a(i, 2, GraphQLStorySaveNuxType.class)).name());
        }
        if (mutableFlatBuffer.a(i, 3, (short) 0) != (short) 0) {
            jsonGenerator.a("story_save_type");
            jsonGenerator.b(((GraphQLStorySaveType) mutableFlatBuffer.a(i, 3, GraphQLStorySaveType.class)).name());
        }
        if (mutableFlatBuffer.a(i, 4, (short) 0) != (short) 0) {
            jsonGenerator.a("viewer_save_state");
            jsonGenerator.b(((GraphQLSavedState) mutableFlatBuffer.a(i, 4, GraphQLSavedState.class)).name());
        }
        jsonGenerator.g();
    }
}
