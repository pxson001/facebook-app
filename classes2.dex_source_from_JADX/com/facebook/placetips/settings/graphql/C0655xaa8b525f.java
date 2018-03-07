package com.facebook.placetips.settings.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: marker_id */
public final class C0655xaa8b525f {
    public static int m21516a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[4];
        boolean[] zArr = new boolean[3];
        boolean[] zArr2 = new boolean[3];
        while (jsonParser.mo1766c() != JsonToken.END_OBJECT) {
            String i = jsonParser.mo1778i();
            jsonParser.mo1766c();
            if (!(jsonParser.mo1794g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("feature_enabled")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.m13249H();
                } else if (i.equals("gravity_learn_more_link")) {
                    iArr[1] = flatBufferBuilder.m21502b(jsonParser.mo1769o());
                } else if (i.equals("location_tracking_enabled")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.m13249H();
                } else if (i.equals("notifications_enabled")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.m13249H();
                } else {
                    jsonParser.mo1793f();
                }
            }
        }
        flatBufferBuilder.m21510c(4);
        if (zArr[0]) {
            flatBufferBuilder.m21498a(0, zArr2[0]);
        }
        flatBufferBuilder.m21507b(1, iArr[1]);
        if (zArr[1]) {
            flatBufferBuilder.m21498a(2, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.m21498a(3, zArr2[2]);
        }
        return flatBufferBuilder.m21511d();
    }

    public static void m21517a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
        jsonGenerator.mo1134f();
        boolean a = mutableFlatBuffer.m21540a(i, 0);
        if (a) {
            jsonGenerator.mo1115a("feature_enabled");
            jsonGenerator.mo1119a(a);
        }
        if (mutableFlatBuffer.m21560g(i, 1) != 0) {
            jsonGenerator.mo1115a("gravity_learn_more_link");
            jsonGenerator.mo1123b(mutableFlatBuffer.m21547c(i, 1));
        }
        a = mutableFlatBuffer.m21540a(i, 2);
        if (a) {
            jsonGenerator.mo1115a("location_tracking_enabled");
            jsonGenerator.mo1119a(a);
        }
        a = mutableFlatBuffer.m21540a(i, 3);
        if (a) {
            jsonGenerator.mo1115a("notifications_enabled");
            jsonGenerator.mo1119a(a);
        }
        jsonGenerator.mo1136g();
    }
}
