package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: netego_album */
public class GraphQLPrivacyScopeDeserializer {
    public static int m5705a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[11];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("can_viewer_edit")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("description")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("education_info")) {
                    iArr[2] = GraphQLPrivacyEducationInfoDeserializer.m5688a(jsonParser, flatBufferBuilder);
                } else if (i.equals("icon")) {
                    iArr[3] = GraphQLIconDeserializer.m5219a(jsonParser, flatBufferBuilder);
                } else if (i.equals("icon_image")) {
                    iArr[4] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("label")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("legacy_graph_api_privacy_json")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("privacy_options")) {
                    iArr[7] = GraphQLPrivacyOptionsContentConnectionDeserializer.m5697a(jsonParser, flatBufferBuilder);
                } else if (i.equals("selectedPrivacyOption")) {
                    iArr[8] = GraphQLPrivacyOptionsContentConnectionDeserializer.m5697a(jsonParser, flatBufferBuilder);
                } else if (i.equals("show_tag_expansion_options")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("type")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(11);
        if (zArr[0]) {
            flatBufferBuilder.a(0, zArr2[0]);
        }
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        if (zArr[1]) {
            flatBufferBuilder.a(9, zArr2[1]);
        }
        flatBufferBuilder.b(10, iArr[10]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5706a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5705a(jsonParser, flatBufferBuilder);
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

    public static void m5707a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(i, 0);
        if (a) {
            jsonGenerator.a("can_viewer_edit");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        int g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("education_info");
            GraphQLPrivacyEducationInfoDeserializer.m5690a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("icon");
            GraphQLIconDeserializer.m5221a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("icon_image");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("label");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("legacy_graph_api_privacy_json");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("privacy_options");
            GraphQLPrivacyOptionsContentConnectionDeserializer.m5699a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("selectedPrivacyOption");
            GraphQLPrivacyOptionsContentConnectionDeserializer.m5699a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 9);
        if (a) {
            jsonGenerator.a("show_tag_expansion_options");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("type");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        jsonGenerator.g();
    }
}
