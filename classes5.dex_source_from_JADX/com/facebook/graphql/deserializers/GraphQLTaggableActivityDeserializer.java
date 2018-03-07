package com.facebook.graphql.deserializers;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: mobile_game_uri */
public class GraphQLTaggableActivityDeserializer {
    public static int m6032a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        int[] iArr = new int[19];
        boolean[] zArr = new boolean[5];
        boolean[] zArr2 = new boolean[4];
        int[] iArr2 = new int[1];
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                if (i.equals("all_icons")) {
                    iArr[0] = GraphQLTaggableActivityAllIconsConnectionDeserializer.m6029a(jsonParser, flatBufferBuilder);
                } else if (i.equals("glyph")) {
                    iArr[1] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("iconImageLarge")) {
                    iArr[2] = GraphQLImageDeserializer.a(jsonParser, flatBufferBuilder);
                } else if (i.equals("id")) {
                    iArr[3] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("is_linking_verb")) {
                    zArr[0] = true;
                    zArr2[0] = jsonParser.H();
                } else if (i.equals("legacy_api_id")) {
                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("prefetch_priority")) {
                    zArr[1] = true;
                    iArr2[0] = jsonParser.E();
                } else if (i.equals("present_participle")) {
                    iArr[7] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("previewTemplateAtPlace")) {
                    iArr[8] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateNoTags")) {
                    iArr[9] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPeople")) {
                    iArr[10] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPeopleAtPlace")) {
                    iArr[11] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPerson")) {
                    iArr[12] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("previewTemplateWithPersonAtPlace")) {
                    iArr[13] = GraphQLTaggableActivityPreviewTemplateDeserializer.m6041a(jsonParser, flatBufferBuilder);
                } else if (i.equals("prompt")) {
                    iArr[14] = flatBufferBuilder.b(jsonParser.o());
                } else if (i.equals("supports_audio_suggestions")) {
                    zArr[2] = true;
                    zArr2[1] = jsonParser.H();
                } else if (i.equals("supports_freeform")) {
                    zArr[3] = true;
                    zArr2[2] = jsonParser.H();
                } else if (i.equals("supports_offline_posting")) {
                    zArr[4] = true;
                    zArr2[3] = jsonParser.H();
                } else if (i.equals("url")) {
                    iArr[18] = flatBufferBuilder.b(jsonParser.o());
                } else {
                    jsonParser.f();
                }
            }
        }
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, iArr[0]);
        flatBufferBuilder.b(1, iArr[1]);
        flatBufferBuilder.b(2, iArr[2]);
        flatBufferBuilder.b(3, iArr[3]);
        if (zArr[0]) {
            flatBufferBuilder.a(4, zArr2[0]);
        }
        flatBufferBuilder.b(5, iArr[5]);
        if (zArr[1]) {
            flatBufferBuilder.a(6, iArr2[0], 0);
        }
        flatBufferBuilder.b(7, iArr[7]);
        flatBufferBuilder.b(8, iArr[8]);
        flatBufferBuilder.b(9, iArr[9]);
        flatBufferBuilder.b(10, iArr[10]);
        flatBufferBuilder.b(11, iArr[11]);
        flatBufferBuilder.b(12, iArr[12]);
        flatBufferBuilder.b(13, iArr[13]);
        flatBufferBuilder.b(14, iArr[14]);
        if (zArr[2]) {
            flatBufferBuilder.a(15, zArr2[1]);
        }
        if (zArr[3]) {
            flatBufferBuilder.a(16, zArr2[2]);
        }
        if (zArr[4]) {
            flatBufferBuilder.a(17, zArr2[3]);
        }
        flatBufferBuilder.b(18, iArr[18]);
        return flatBufferBuilder.d();
    }

    public static int m6034b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
        ArrayList arrayList = new ArrayList();
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                arrayList.add(Integer.valueOf(m6032a(jsonParser, flatBufferBuilder)));
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

    public static MutableFlatBuffer m6033a(JsonParser jsonParser, short s) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m6032a(jsonParser, flatBufferBuilder);
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

    public static void m6035b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(i, 0);
        if (g != 0) {
            jsonGenerator.a("all_icons");
            GraphQLTaggableActivityAllIconsConnectionDeserializer.m6031a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 1);
        if (g != 0) {
            jsonGenerator.a("glyph");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(i, 2);
        if (g != 0) {
            jsonGenerator.a("iconImageLarge");
            GraphQLImageDeserializer.a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(i, 3) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 3));
        }
        boolean a = mutableFlatBuffer.a(i, 4);
        if (a) {
            jsonGenerator.a("is_linking_verb");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 5) != 0) {
            jsonGenerator.a("legacy_api_id");
            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
        }
        g = mutableFlatBuffer.a(i, 6, 0);
        if (g != 0) {
            jsonGenerator.a("prefetch_priority");
            jsonGenerator.b(g);
        }
        if (mutableFlatBuffer.g(i, 7) != 0) {
            jsonGenerator.a("present_participle");
            jsonGenerator.b(mutableFlatBuffer.c(i, 7));
        }
        g = mutableFlatBuffer.g(i, 8);
        if (g != 0) {
            jsonGenerator.a("previewTemplateAtPlace");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 9);
        if (g != 0) {
            jsonGenerator.a("previewTemplateNoTags");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 10);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPeople");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 11);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPeopleAtPlace");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 12);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPerson");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(i, 13);
        if (g != 0) {
            jsonGenerator.a("previewTemplateWithPersonAtPlace");
            GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(i, 14) != 0) {
            jsonGenerator.a("prompt");
            jsonGenerator.b(mutableFlatBuffer.c(i, 14));
        }
        a = mutableFlatBuffer.a(i, 15);
        if (a) {
            jsonGenerator.a("supports_audio_suggestions");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 16);
        if (a) {
            jsonGenerator.a("supports_freeform");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(i, 17);
        if (a) {
            jsonGenerator.a("supports_offline_posting");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(i, 18) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(i, 18));
        }
        jsonGenerator.g();
    }
}
