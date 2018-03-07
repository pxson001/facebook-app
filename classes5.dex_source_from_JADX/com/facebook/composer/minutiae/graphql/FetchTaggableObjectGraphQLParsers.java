package com.facebook.composer.minutiae.graphql;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeIconParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaePreviewTemplateParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityFieldsParser.GlyphParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityFieldsParser.IconImageLargeParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityParser.AllIconsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableObjectFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCheckinPlaceResultsContext;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoTailFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: admin */
public class FetchTaggableObjectGraphQLParsers {

    /* compiled from: admin */
    public final class FetchSingleTaggableSuggestionQueryParser {
        public static int m19339a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[19];
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
                    } else if (i.equals("taggable_activity_suggestions")) {
                        iArr[18] = MinutiaeTaggableObjectsParser.m19344a(jsonParser, flatBufferBuilder);
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

        public static void m19340a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("taggable_activity_suggestions");
                MinutiaeTaggableObjectsParser.m19345a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: admin */
    public final class FetchTaggableObjectsQueryParser {
        public static MutableFlatBuffer m19341a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[9];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("iconImageLarge")) {
                        iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateAtPlace")) {
                        iArr[2] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateNoTags")) {
                        iArr[3] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPeople")) {
                        iArr[4] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPeopleAtPlace")) {
                        iArr[5] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPerson")) {
                        iArr[6] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("previewTemplateWithPersonAtPlace")) {
                        iArr[7] = MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("taggable_activity_suggestions")) {
                        iArr[8] = MinutiaeTaggableObjectsParser.m19344a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: admin */
    public final class FetchTaggableSuggestionsAtPlaceQueryParser {
        public static int m19342a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[19];
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
                    } else if (i.equals("taggable_activity_suggestions")) {
                        iArr[18] = MinutiaeTaggableObjectsParser.m19344a(jsonParser, flatBufferBuilder);
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

        public static void m19343a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("taggable_activity_suggestions");
                MinutiaeTaggableObjectsParser.m19345a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: admin */
    public final class MinutiaeTaggableObjectsParser {
        public static int m19344a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("edges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(TaggableObjectEdgeParser.m19352b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[0] = i2;
                    } else if (i.equals("page_info")) {
                        iArr[1] = DefaultPageInfoTailFieldsParser.m9654a(jsonParser, flatBufferBuilder);
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

        public static void m19345a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    TaggableObjectEdgeParser.m19353b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("page_info");
                DefaultPageInfoTailFieldsParser.m9655a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: admin */
    public final class TaggableObjectEdgeParser {

        /* compiled from: admin */
        public final class AssociatedPlacesInfoParser {
            public static int m19346a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("place_ids")) {
                            iArr[0] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("place_topic_ids")) {
                            iArr[1] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("show_all_contextual_places")) {
                            iArr[2] = flatBufferBuilder.a(GraphQLCheckinPlaceResultsContext.fromString(jsonParser.o()));
                        } else if (i.equals("suggestion_mechanism")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                return flatBufferBuilder.d();
            }

            public static void m19347a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("place_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 0), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("place_topic_ids");
                    SerializerHelpers.a(mutableFlatBuffer.f(i, 1), jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("show_all_contextual_places");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("suggestion_mechanism");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: admin */
        public final class IconParser {
            public static int m19348a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("icon_background_color")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
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

            public static void m19349a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("icon_background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: admin */
        public final class SubtextParser {
            public static int m19350a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("text")) {
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

            public static void m19351a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m19352b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("associated_places_info")) {
                        iArr[0] = AssociatedPlacesInfoParser.m19346a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cursor")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("custom_icon_suggestions")) {
                        iArr[2] = MinutiaeIconParser.m19511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("display_name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("icon")) {
                        iArr[4] = IconParser.m19348a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("iconImageLarge")) {
                        iArr[5] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("node")) {
                        iArr[6] = MinutiaeTaggableObjectFieldsParser.m19538a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("show_attachment_preview")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("subtext")) {
                        iArr[8] = SubtextParser.m19350a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tracking")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[0]) {
                flatBufferBuilder.a(7, zArr2[0]);
            }
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            return flatBufferBuilder.d();
        }

        public static void m19353b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("associated_places_info");
                AssociatedPlacesInfoParser.m19347a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("cursor");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("custom_icon_suggestions");
                MinutiaeIconParser.m19512a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("display_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("icon");
                IconParser.m19349a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("iconImageLarge");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("node");
                MinutiaeTaggableObjectFieldsParser.m19539a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("show_attachment_preview");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("subtext");
                SubtextParser.m19351a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            jsonGenerator.g();
        }
    }
}
