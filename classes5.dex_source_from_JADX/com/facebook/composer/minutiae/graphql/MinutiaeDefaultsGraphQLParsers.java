package com.facebook.composer.minutiae.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLActivityTemplateTokenType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: addressee */
public class MinutiaeDefaultsGraphQLParsers {

    /* compiled from: addressee */
    public final class MinutiaeIconParser {
        public static int m19513b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("imageLarge")) {
                        iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            return flatBufferBuilder.d();
        }

        public static int m19511a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m19513b(jsonParser, flatBufferBuilder)));
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

        public static void m19512a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m19514b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m19514b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("imageLarge");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: addressee */
    public final class MinutiaePreviewTemplateParser {

        /* compiled from: addressee */
        public final class TemplateTokensParser {
            public static int m19516b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("token_position")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("token_type")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLActivityTemplateTokenType.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m19515a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("token_position");
                    jsonGenerator.b(a);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("token_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m19517a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("template_string")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("template_tokens")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(TemplateTokensParser.m19516b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[1] = i2;
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            return flatBufferBuilder.d();
        }

        public static void m19518a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("template_string");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("template_tokens");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    TemplateTokensParser.m19515a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: addressee */
    public final class MinutiaeTaggableActivityFieldsParser {

        /* compiled from: addressee */
        public final class GlyphParser {
            public static int m19519a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("uri")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m19520a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: addressee */
        public final class IconImageLargeParser {
            public static int m19521a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("uri")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m19522a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m19523a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[11];
            boolean[] zArr = new boolean[5];
            boolean[] zArr2 = new boolean[4];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("glyph")) {
                        iArr[0] = GlyphParser.m19519a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("iconImageLarge")) {
                        iArr[1] = IconImageLargeParser.m19521a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_linking_verb")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("legacy_api_id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prefetch_priority")) {
                        zArr[1] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("present_participle")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("prompt")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("supports_audio_suggestions")) {
                        zArr[2] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("supports_freeform")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("supports_offline_posting")) {
                        zArr[4] = true;
                        zArr2[3] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[0]) {
                flatBufferBuilder.a(3, zArr2[0]);
            }
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            if (zArr[2]) {
                flatBufferBuilder.a(8, zArr2[1]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(9, zArr2[2]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(10, zArr2[3]);
            }
            return flatBufferBuilder.d();
        }

        public static void m19524a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("glyph");
                GlyphParser.m19520a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("iconImageLarge");
                IconImageLargeParser.m19522a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            boolean a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("is_linking_verb");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("legacy_api_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.a(i, 5, 0);
            if (g != 0) {
                jsonGenerator.a("prefetch_priority");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("present_participle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("prompt");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("supports_audio_suggestions");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("supports_freeform");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("supports_offline_posting");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: addressee */
    public final class MinutiaeTaggableActivityIconsParser {

        /* compiled from: addressee */
        public final class AllIconsParser {
            public static int m19525a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("nodes")) {
                            iArr[1] = MinutiaeIconParser.m19511a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m19526a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("nodes");
                    MinutiaeIconParser.m19512a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m19527a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("all_icons")) {
                        iArr[0] = AllIconsParser.m19525a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: addressee */
    public final class MinutiaeTaggableActivityParser {

        /* compiled from: addressee */
        public final class AllIconsParser {
            public static int m19528a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[1];
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m19529a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m19530a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[18];
            boolean[] zArr = new boolean[5];
            boolean[] zArr2 = new boolean[4];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("all_icons")) {
                        iArr[0] = AllIconsParser.m19528a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("glyph")) {
                        iArr[1] = GlyphParser.m19519a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("iconImageLarge")) {
                        iArr[2] = IconImageLargeParser.m19521a(jsonParser, flatBufferBuilder);
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
                        iArr[8] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateNoTags")) {
                        iArr[9] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPeople")) {
                        iArr[10] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPeopleAtPlace")) {
                        iArr[11] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPerson")) {
                        iArr[12] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPersonAtPlace")) {
                        iArr[13] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
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
            return flatBufferBuilder.d();
        }

        public static void m19531b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("all_icons");
                AllIconsParser.m19529a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("glyph");
                GlyphParser.m19520a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("iconImageLarge");
                IconImageLargeParser.m19522a(mutableFlatBuffer, g, jsonGenerator);
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
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("previewTemplateNoTags");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPeople");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPeopleAtPlace");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPerson");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPersonAtPlace");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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
            jsonGenerator.g();
        }
    }

    /* compiled from: addressee */
    public final class MinutiaeTaggableActivityPreviewTemplateFieldsParser {
        public static int m19532a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("previewTemplateAtPlace")) {
                        iArr[0] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateNoTags")) {
                        iArr[1] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPeople")) {
                        iArr[2] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPeopleAtPlace")) {
                        iArr[3] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPerson")) {
                        iArr[4] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPersonAtPlace")) {
                        iArr[5] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            return flatBufferBuilder.d();
        }

        public static void m19533a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("previewTemplateAtPlace");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("previewTemplateNoTags");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPeople");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPeopleAtPlace");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPerson");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("previewTemplateWithPersonAtPlace");
                MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: addressee */
    public final class MinutiaeTaggableObjectFieldsParser {

        /* compiled from: addressee */
        public final class OpenGraphComposerPreviewParser {
            public static int m19534a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("style_list")) {
                            iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m19535a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: addressee */
        public final class PageParser {
            public static int m19536a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("is_verified")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("name")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, zArr2[0]);
                }
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m19537a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m19538a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_verified")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("open_graph_composer_preview")) {
                        iArr[4] = OpenGraphComposerPreviewParser.m19534a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("page")) {
                        iArr[5] = PageParser.m19536a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture")) {
                        iArr[6] = ProfilePictureParser.m23566a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("taggable_object_profile_picture")) {
                        iArr[7] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("url")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[0]) {
                flatBufferBuilder.a(2, zArr2[0]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            return flatBufferBuilder.d();
        }

        public static void m19539a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            boolean a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("is_verified");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("open_graph_composer_preview");
                OpenGraphComposerPreviewParser.m19535a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("page");
                PageParser.m19537a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("profile_picture");
                ProfilePictureParser.m23567a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("taggable_object_profile_picture");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            jsonGenerator.g();
        }
    }
}
