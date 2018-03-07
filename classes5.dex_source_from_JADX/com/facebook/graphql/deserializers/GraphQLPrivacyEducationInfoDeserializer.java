package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: netego_note */
public class GraphQLPrivacyEducationInfoDeserializer {
    public static int m5688a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[5];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("fullindex_education_info")) {
                    iArr[0] = GraphQLFullIndexEducationInfoDeserializer.m4969a(jsonParser, flatBufferBuilder);
                } else if (i.equals("post_edit_upsell_privacy")) {
                    iArr[1] = GraphQLPrivacyOptionDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("reshare_education_info")) {
                    iArr[2] = GraphQLReshareEducationInfoDeserializer.m5836a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tag_expansion_education")) {
                    iArr[3] = GraphQLTagExpansionEducationInfoDeserializer.m6026a(jsonParser, flatBufferBuilder);
                } else if (i.equals("group_mall_ads_education_info")) {
                    iArr[4] = GraphQLGroupMallAdsEducationInfoDeserializer.m5160a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5689a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5688a(jsonParser, flatBufferBuilder);
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

    public static void m5690a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("fullindex_education_info");
            GraphQLFullIndexEducationInfoDeserializer.m4971a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("post_edit_upsell_privacy");
            GraphQLPrivacyOptionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("reshare_education_info");
            GraphQLReshareEducationInfoDeserializer.m5838a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("tag_expansion_education");
            GraphQLTagExpansionEducationInfoDeserializer.m6028a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("group_mall_ads_education_info");
            GraphQLGroupMallAdsEducationInfoDeserializer.m5162a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }
}
