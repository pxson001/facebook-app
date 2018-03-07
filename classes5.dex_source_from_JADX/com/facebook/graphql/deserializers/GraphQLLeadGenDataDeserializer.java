package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: optin_decline_confirm_text */
public class GraphQLLeadGenDataDeserializer {
    public static int m5283a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("context_page")) {
                    iArr[0] = GraphQLLeadGenContextPageDeserializer.m5280a(jsonParser, flatBufferBuilder);
                } else if (i.equals("follow_up_title")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("info_fields_data")) {
                    iArr[2] = GraphQLLeadGenInfoFieldDataDeserializer.m5298b(jsonParser, flatBufferBuilder);
                } else if (i.equals("legal_content")) {
                    iArr[3] = GraphQLLeadGenLegalContentDeserializer.m5302a(jsonParser, flatBufferBuilder);
                } else if (i.equals("need_split_flow")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("pages")) {
                    iArr[5] = GraphQLLeadGenPageDeserializer.m5307b(jsonParser, flatBufferBuilder);
                } else if (i.equals("policy_url")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("split_flow_request_method")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("split_flow_use_post")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, zArr2[1]);
        }
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m5284a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5283a(jsonParser, flatBufferBuilder);
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

    public static void m5285a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("context_page");
            GraphQLLeadGenContextPageDeserializer.m5282a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("follow_up_title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("info_fields_data");
            GraphQLLeadGenInfoFieldDataDeserializer.m5297a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("legal_content");
            GraphQLLeadGenLegalContentDeserializer.m5304a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("need_split_flow");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("pages");
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLLeadGenPageDeserializer.m5308b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("policy_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("split_flow_request_method");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        a = mutableFlatBuffer.a(i, 8);
        if (a) {
            jsonGenerator.a("split_flow_use_post");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }
}
