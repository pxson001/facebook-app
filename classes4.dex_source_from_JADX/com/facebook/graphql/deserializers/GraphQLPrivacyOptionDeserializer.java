package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: reg/ */
public class GraphQLPrivacyOptionDeserializer {
    public static int m3897a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[13];
        boolean[] zArr = new boolean[1];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("current_tag_expansion")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLPrivacyOptionTagExpansionType.fromString(jsonParser.o());
                } else if (i.equals("excluded_members")) {
                    iArr[1] = GraphQLPrivacyAudienceMemberDeserializer.m3904b(jsonParser, flatBufferBuilder);
                } else if (i.equals("explanation")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("icon_image")) {
                    iArr[4] = GraphQLImageDeserializer.m3908a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("included_members")) {
                    iArr[6] = GraphQLPrivacyAudienceMemberDeserializer.m3904b(jsonParser, flatBufferBuilder);
                } else if (i.equals("legacy_graph_api_privacy_json")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("name")) {
                    iArr[8] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_row_input")) {
                    iArr[9] = GraphQLPrivacyRowInputDeserializer.m3905a(jsonParser, flatBufferBuilder);
                } else if (i.equals("tag_expansion_options")) {
                    iArr[10] = DeserializerHelpers.m2035a(jsonParser, flatBufferBuilder, GraphQLPrivacyOptionTagExpansionType.class);
                } else if (i.equals("type")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(13);
        if (zArr[0]) {
            flatBufferBuilder.a(0, enumArr[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m3898a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m3897a(jsonParser, flatBufferBuilder);
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

    public static void m3899a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.a(i, 0, (short) 0) != (short) 0) {
            jsonGenerator.a("current_tag_expansion");
            jsonGenerator.b(((GraphQLPrivacyOptionTagExpansionType) mutableFlatBuffer.a(i, 0, GraphQLPrivacyOptionTagExpansionType.class)).name());
        }
        int g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("excluded_members");
            GraphQLPrivacyAudienceMemberDeserializer.m3903a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("explanation");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("icon_image");
            GraphQLImageDeserializer.m3910a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.g(i, 6);
        if (g != 0) {
            jsonGenerator.a("included_members");
            GraphQLPrivacyAudienceMemberDeserializer.m3903a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("legacy_graph_api_privacy_json");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.g(i, 8) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 8));
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("privacy_row_input");
            GraphQLPrivacyRowInputDeserializer.m3907a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("tag_expansion_options");
            SerializerHelpers.m4182a(mutableFlatBuffer.f(i, 10), jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        if (mutableFlatBuffer.g(i, 12) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
        }
        jsonGenerator.g();
    }
}
