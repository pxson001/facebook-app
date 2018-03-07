package com.facebook.contacts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: recent_unread */
public final class ContactGraphQLParsers$ContactsSyncFullParser$PageInfoParser {
    public static int m4000a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[3];
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("delta_cursor")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("end_cursor")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("has_next_page")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        if (zArr[0]) {
            flatBufferBuilder.a(2, zArr2[0]);
        }
        return flatBufferBuilder.d();
    }

    public static void m4001a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("delta_cursor");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("end_cursor");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        boolean a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("has_next_page");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
