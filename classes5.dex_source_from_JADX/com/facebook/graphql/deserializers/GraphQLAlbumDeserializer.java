package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: place_ids */
public class GraphQLAlbumDeserializer {
    public static int m4549a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[26];
        boolean[] zArr = new boolean[7];
        boolean[] zArr2 = new boolean[4];
        long[] jArr = new long[2];
        Enum[] enumArr = new Enum[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("album_cover_photo")) {
                    iArr[0] = GraphQLPhotoDeserializer.m5601a(jsonParser, flatBufferBuilder);
                } else if (i.equals("album_type")) {
                    zArr[0] = true;
                    enumArr[0] = GraphQLPhotosAlbumAPIType.fromString(jsonParser.o());
                } else if (i.equals("allow_contributors")) {
                    zArr[1] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("application")) {
                    iArr[3] = GraphQLApplicationDeserializer.m4579a(jsonParser, flatBufferBuilder);
                } else if (i.equals("can_edit_caption")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("can_upload")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("can_viewer_delete")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("contributors")) {
                    iArr[7] = GraphQLActorDeserializer.m4520b(jsonParser, flatBufferBuilder);
                } else if (i.equals("created_time")) {
                    zArr[5] = true;
                    jArr[0] = jsonParser.F();
                } else if (i.equals("explicit_place")) {
                    iArr[9] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("feedback")) {
                    iArr[10] = GraphQLFeedbackDeserializer.m4892a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("implicit_place")) {
                    iArr[12] = GraphQLPlaceDeserializer.m5638a(jsonParser, flatBufferBuilder);
                } else if (i.equals("media")) {
                    iArr[13] = GraphQLMediaSetMediaConnectionDeserializer.m5358a(jsonParser, flatBufferBuilder);
                } else if (i.equals("media_owner_object")) {
                    iArr[14] = GraphQLProfileDeserializer.m5717a(jsonParser, flatBufferBuilder);
                } else if (i.equals("message")) {
                    iArr[15] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("modified_time")) {
                    zArr[6] = true;
                    jArr[1] = jsonParser.F();
                } else if (i.equals("name")) {
                    iArr[17] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("owner")) {
                    iArr[18] = GraphQLActorDeserializer.m4517a(jsonParser, flatBufferBuilder);
                } else if (i.equals("photo_items")) {
                    iArr[19] = GraphQLMediaSetMediaConnectionDeserializer.m5358a(jsonParser, flatBufferBuilder);
                } else if (i.equals("privacy_scope")) {
                    iArr[20] = GraphQLPrivacyScopeDeserializer.m5705a(jsonParser, flatBufferBuilder);
                } else if (i.equals("title")) {
                    iArr[22] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("titleForSummary")) {
                    iArr[23] = GraphQLTextWithEntitiesDeserializer.m6056a(jsonParser, flatBufferBuilder);
                } else if (i.equals("url")) {
                    iArr[24] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("media_list")) {
                    iArr[25] = GraphQLMediaSetMediaConnectionDeserializer.m5358a(jsonParser, flatBufferBuilder);
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(26);
        flatBufferBuilder.b(0, iArr[0]);
        if (zArr[0]) {
            flatBufferBuilder.a(1, enumArr[0]);
        }
        if (zArr[1]) {
            flatBufferBuilder.a(2, zArr2[0]);
        }
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[2]) {
            flatBufferBuilder.a(4, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(5, zArr2[2]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(6, zArr2[3]);
        }
        flatBufferBuilder.b(7, iArr[7]);
        if (zArr[5]) {
            flatBufferBuilder.a(8, jArr[0], 0);
        }
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        flatBufferBuilder.b(15, iArr[15]);
        if (zArr[6]) {
            flatBufferBuilder.a(16, jArr[1], 0);
        }
        flatBufferBuilder.b(17, iArr[17]);
        flatBufferBuilder.b(18, iArr[18]);
        flatBufferBuilder.b(19, iArr[19]);
        flatBufferBuilder.b(20, iArr[20]);
        flatBufferBuilder.b(22, iArr[22]);
        flatBufferBuilder.b(23, iArr[23]);
        flatBufferBuilder.b(24, iArr[24]);
        flatBufferBuilder.b(25, iArr[25]);
        return flatBufferBuilder.d();
    }

    public static MutableFlatBuffer m4550a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m4549a(jsonParser, flatBufferBuilder);
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

    public static void m4551b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("album_cover_photo");
            GraphQLPhotoDeserializer.m5605b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.a(i, 1, (short) 0) != (short) 0) {
            jsonGenerator.a("album_type");
            jsonGenerator.b(((GraphQLPhotosAlbumAPIType) mutableFlatBuffer.a(i, 1, GraphQLPhotosAlbumAPIType.class)).name());
        }
        boolean a = mutableFlatBuffer.a(i, 2);
        if (a) {
            jsonGenerator.a("allow_contributors");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 3);
        if (g != 0) {
            jsonGenerator.a("application");
            GraphQLApplicationDeserializer.m4581a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("can_edit_caption");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 5);
        if (a) {
            jsonGenerator.a("can_upload");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 6);
        if (a) {
            jsonGenerator.a("can_viewer_delete");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(i, 7);
        if (g != 0) {
            jsonGenerator.a("contributors");
            GraphQLActorDeserializer.m4519a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        long a2 = mutableFlatBuffer.a(i, 8, 0);
        if (a2 != 0) {
            jsonGenerator.a("created_time");
            jsonGenerator.a(a2);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("explicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("feedback");
            GraphQLFeedbackDeserializer.m4895b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 11) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("implicit_place");
            GraphQLPlaceDeserializer.m5640a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("media");
            GraphQLMediaSetMediaConnectionDeserializer.m5360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 14);
        if (g != 0) {
            jsonGenerator.a("media_owner_object");
            GraphQLProfileDeserializer.m5721b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 15);
        if (g != 0) {
            jsonGenerator.a("message");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        a2 = mutableFlatBuffer.a(i, 16, 0);
        if (a2 != 0) {
            jsonGenerator.a("modified_time");
            jsonGenerator.a(a2);
        }
        if (mutableFlatBuffer.g(i, 17) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(i, 17));
        }
        g = mutableFlatBuffer.g(i, 18);
        if (g != 0) {
            jsonGenerator.a("owner");
            GraphQLActorDeserializer.m4521b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 19);
        if (g != 0) {
            jsonGenerator.a("photo_items");
            GraphQLMediaSetMediaConnectionDeserializer.m5360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 20);
        if (g != 0) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScopeDeserializer.m5707a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 22);
        if (g != 0) {
            jsonGenerator.a("title");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 23);
        if (g != 0) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntitiesDeserializer.m6060b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 24) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 24));
        }
        g = mutableFlatBuffer.g(i, 25);
        if (g != 0) {
            jsonGenerator.a("media_list");
            GraphQLMediaSetMediaConnectionDeserializer.m5360a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }
}
