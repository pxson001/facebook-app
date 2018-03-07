package com.facebook.privacy.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: sms_anonymous_promo_row_seen_today */
public final class FetchAudienceInfoParsers$AudienceInfoFieldsParser {
    public static int m2229a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("eligible_for_audience_alignment_education")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("eligible_for_audience_alignment_only_me_education")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("eligible_for_newcomer_audience_selector")) {
                    zArr[2] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("has_default_privacy")) {
                    zArr[3] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("post_privacy_followup_info")) {
                    iArr[4] = C0159xa9fcfe29.m3895a(jsonParser, flatBufferBuilder);
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

    public static void m2230a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("eligible_for_audience_alignment_education");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("eligible_for_audience_alignment_only_me_education");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("eligible_for_newcomer_audience_selector");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("has_default_privacy");
            jsonGenerator.a(a);
        }
        int g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("post_privacy_followup_info");
            C0159xa9fcfe29.m3896a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
