package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: pickup_note */
public class GraphQLAudienceInfoDeserializer {
    public static int m4597a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        boolean[] zArr = new boolean[4];
        boolean[] zArr2 = new boolean[4];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("composer_privacy_guardrail_info")) {
                    iArr[0] = GraphQLComposerPrivacyGuardrailInfoDeserializer.m4671a(jsonParser, flatBufferBuilder);
                } else if (i.equals("eligible_for_audience_alignment_education")) {
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
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(2, zArr2[1]);
        }
        if (zArr[2]) {
            flatBufferBuilder.a(3, zArr2[2]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(4, zArr2[3]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4598a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4597a(jsonParser, flatBufferBuilder);
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

    public static void m4599a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("composer_privacy_guardrail_info");
            GraphQLComposerPrivacyGuardrailInfoDeserializer.m4673a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 1);
        if (a) {
            jsonGenerator.a("eligible_for_audience_alignment_education");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("eligible_for_audience_alignment_only_me_education");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 3);
        if (a) {
            jsonGenerator.a("eligible_for_newcomer_audience_selector");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("has_default_privacy");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
