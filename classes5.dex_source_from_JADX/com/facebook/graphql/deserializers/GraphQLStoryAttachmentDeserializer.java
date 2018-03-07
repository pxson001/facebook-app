package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: mobile_top_of_feed */
public class GraphQLStoryAttachmentDeserializer {
    public static int m5953a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[20];
        boolean[] zArr = new boolean[2];
        boolean[] zArr2 = new boolean[2];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("action_links")) {
                    iArr[0] = GraphQLStoryActionLinkDeserializer.m5951b(jsonParser, flatBufferBuilder);
                } else if (i.equals("associated_application")) {
                    iArr[1] = GraphQLAppStoreApplicationDeserializer.m4573a(jsonParser, flatBufferBuilder);
                } else if (i.equals("attachment_properties")) {
                    iArr[2] = GraphQLAttachmentPropertyDeserializer.m4590b(jsonParser, flatBufferBuilder);
                } else if (i.equals("deduplication_key")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("description")) {
                    iArr[4] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("genie_message")) {
                    iArr[5] = GraphQLNodeDeserializer.m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("is_album_attachment")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("is_media_local")) {
                    zArr[1] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("media")) {
                    iArr[8] = GraphQLMediaDeserializer.m5338a(jsonParser, flatBufferBuilder);
                } else if (i.equals("media_owner_object_id")) {
                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("media_reference_token")) {
                    iArr[10] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("source")) {
                    iArr[11] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("style_infos")) {
                    iArr[12] = GraphQLStoryAttachmentStyleInfoDeserializer.m5960b(jsonParser, flatBufferBuilder);
                } else if (i.equals("style_list")) {
                    iArr[13] = DeserializerHelpers.a(jsonParser, flatBufferBuilder, GraphQLStoryAttachmentStyle.class);
                } else if (i.equals("subattachments")) {
                    iArr[14] = m5956b(jsonParser, flatBufferBuilder);
                } else if (i.equals("subtitle")) {
                    iArr[15] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("target")) {
                    iArr[16] = GraphQLNodeDeserializer.m5436a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[17] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("tracking")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("url")) {
                    iArr[19] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(20);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        flatBufferBuilder.b(4, iArr[4]);
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[0]) {
            flatBufferBuilder.a(6, zArr2[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(7, zArr2[1]);
        }
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        flatBufferBuilder.b(16, iArr[16]);
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        return flatBufferBuilder.d();
    }

    public static int m5956b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m5953a(jsonParser, flatBufferBuilder)));
            }
        }
        if (arrayList.isEmpty()) {
            return 0;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return flatBufferBuilder.a(iArr, true);
    }

    public static MutableFlatBuffer m5954a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m5953a(jsonParser, flatBufferBuilder);
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

    public static void m5955a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.d();
        for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
            m5957b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public static void m5957b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int i2;
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("action_links");
            GraphQLStoryActionLinkDeserializer.m5950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("associated_application");
            GraphQLAppStoreApplicationDeserializer.m4575a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("attachment_properties");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLAttachmentPropertyDeserializer.m4591b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("deduplication_key");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        g = mutableFlatBuffer.g(i, 4);
        if (g != 0) {
            jsonGenerator.a("description");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 5);
        if (g != 0) {
            jsonGenerator.a("genie_message");
            GraphQLNodeDeserializer.m5440b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("is_album_attachment");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 7);
        if (a) {
            jsonGenerator.a("is_media_local");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("media");
            GraphQLMediaDeserializer.m5342b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 9) != 0) {
            jsonGenerator.a("media_owner_object_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
        }
        if (mutableFlatBuffer.g(i, 10) != 0) {
            jsonGenerator.a("media_reference_token");
            jsonGenerator.b(mutableFlatBuffer.c(i, 10));
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("source");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("style_infos");
            jsonGenerator.d();
            for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                GraphQLStoryAttachmentStyleInfoDeserializer.m5961b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        if (mutableFlatBuffer.g(i, 13) != 0) {
            jsonGenerator.a("style_list");
            SerializerHelpers.a(mutableFlatBuffer.f(i, 13), jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("subattachments");
            m5955a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 15) != 0) {
            jsonGenerator.a("subtitle");
            jsonGenerator.b(mutableFlatBuffer.c(i, 15));
        }
        g = mutableFlatBuffer.g(i, 16);
        if (g != 0) {
            jsonGenerator.a("target");
            GraphQLNodeDeserializer.m5440b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 17) != 0) {
            jsonGenerator.a("title");
            jsonGenerator.b(mutableFlatBuffer.c(i, 17));
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("tracking");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        if (mutableFlatBuffer.g(i, 19) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 19));
        }
        jsonGenerator.g();
    }
}
