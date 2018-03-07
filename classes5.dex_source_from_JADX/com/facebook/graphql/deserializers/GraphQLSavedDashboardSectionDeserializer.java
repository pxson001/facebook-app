package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

/* compiled from: multiShareItemSquareImage */
public class GraphQLSavedDashboardSectionDeserializer {
    public static int m5859a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("section_type")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLSavedDashboardSectionType.fromString(jsonParser.o());
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

    public static MutableFlatBuffer m5860a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5859a(jsonParser, flatBufferBuilder);
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

    public static void m5861a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("section_type");
            jsonGenerator.b(((GraphQLSavedDashboardSectionType) mutableFlatBuffer.a(i, 0, GraphQLSavedDashboardSectionType.class)).name());
        }
        jsonGenerator.g();
    }
}
