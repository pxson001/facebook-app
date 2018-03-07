package com.facebook.backgroundlocation.reporting.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: id_override */
public final class BackgroundLocationReportingGraphQLParsers$LocationSharingParser {
    public static int m11066a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = new boolean[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("is_tracking_enabled")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(1);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        return flatBufferBuilder.d();
    }

    public static void m11067a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("is_tracking_enabled");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
