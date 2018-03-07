package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: placeTag */
public class GraphQLAppStoreApplicationDeserializer {
    public static int m4573a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[18];
        boolean[] zArr = new boolean[3];
        int[] iArr2 = new int[1];
        Enum[] enumArr = new Enum[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("app_name")) {
                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("app_store_identifier")) {
                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("artifact_size_description")) {
                    iArr[2] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("banner_screenshots")) {
                    iArr[3] = GraphQLImageDeserializer.b(jsonParser, flatBufferBuilder);
                } else if (i.equals("description")) {
                    iArr[4] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("download_connectivity_policy")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLAppStoreDownloadConnectivityPolicy.fromString(jsonParser.o());
                } else if (i.equals("icon_url")) {
                    iArr[6] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("install_id")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("install_state")) {
                    zArr[1] = true;
                    enumArr[1] = GraphQLAppStoreApplicationInstallState.fromString(jsonParser.o());
                } else if (i.equals("likes_context_sentence")) {
                    iArr[9] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("permissions")) {
                    iArr[10] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("phone_screenshots")) {
                    iArr[11] = GraphQLImageDeserializer.b(jsonParser, flatBufferBuilder);
                } else if (i.equals("platform_application")) {
                    iArr[12] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("publisher")) {
                    iArr[13] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("supported_app_stores")) {
                    iArr[14] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLDigitalGoodStoreType.class);
                } else if (i.equals("usage_context_sentence")) {
                    iArr[15] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("version_code")) {
                    zArr[2] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("version_name")) {
                    iArr[17] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(18);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        if (zArr[0]) {
            flatBufferBuilder.a(5, enumArr[0]);
        }
        flatBufferBuilder.b(6, iArr[6]);
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[1]) {
            flatBufferBuilder.a(8, enumArr[1]);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[2]) {
            flatBufferBuilder.a(16, iArr2[0], 0);
        }
        flatBufferBuilder.b(17, iArr[17]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4574a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4573a(jsonParser, flatBufferBuilder);
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

    public static void m4575a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        if (mutableFlatBuffer.g(i, 0) != 0) {
            jsonGenerator.a("app_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
        }
        if (mutableFlatBuffer.g(i, 1) != 0) {
            jsonGenerator.a("app_store_identifier");
            jsonGenerator.b(mutableFlatBuffer.c(i, 1));
        }
        if (mutableFlatBuffer.g(i, 2) != 0) {
            jsonGenerator.a("artifact_size_description");
            jsonGenerator.b(mutableFlatBuffer.c(i, 2));
        }
        int g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("banner_screenshots");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 5, (short) 0) != (short) 0) {
            jsonGenerator.a("download_connectivity_policy");
            jsonGenerator.b(((GraphQLAppStoreDownloadConnectivityPolicy) mutableFlatBuffer.a(i, 5, GraphQLAppStoreDownloadConnectivityPolicy.class)).name());
        }
        if (mutableFlatBuffer.g(i, 6) != 0) {
            jsonGenerator.a("icon_url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 6));
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("install_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        if (mutableFlatBuffer.a(i, 8, (short) 0) != (short) 0) {
            jsonGenerator.a("install_state");
            jsonGenerator.b(((GraphQLAppStoreApplicationInstallState) mutableFlatBuffer.a(i, 8, GraphQLAppStoreApplicationInstallState.class)).name());
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("likes_context_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("permissions");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 10), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("phone_screenshots");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("platform_application");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("publisher");
            jsonGenerator.b(mutableFlatBuffer.c(i, 13));
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("supported_app_stores");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 14), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("usage_context_sentence");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.a(i, 16, 0);
        if (g != 0) {
            jsonGenerator.a("version_code");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 17) != 0) {
            jsonGenerator.a("version_name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 17));
        }
        jsonGenerator.g();
    }
}
