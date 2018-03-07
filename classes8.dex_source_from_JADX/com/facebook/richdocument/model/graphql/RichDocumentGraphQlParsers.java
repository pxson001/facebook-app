package com.facebook.richdocument.model.graphql;

import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.FBFullImageFragmentParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer;
import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLCapitalizationStyle;
import com.facebook.graphql.enums.GraphQLComposedBlockType;
import com.facebook.graphql.enums.GraphQLComposedEntityType;
import com.facebook.graphql.enums.GraphQLDocumentAuthorStyle;
import com.facebook.graphql.enums.GraphQLDocumentDateStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementMarginStyle;
import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.enums.GraphQLDocumentListStyle;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.enums.GraphQLInlineStyle;
import com.facebook.graphql.enums.GraphQLInstantArticlePublishStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTextAnnotationHorizontalPosition;
import com.facebook.graphql.enums.GraphQLTextAnnotationPresentationStyle;
import com.facebook.graphql.enums.GraphQLTextAnnotationVerticalPosition;
import com.facebook.graphql.enums.GraphQLUnderlineStyle;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: photo_pandora */
public class RichDocumentGraphQlParsers {

    /* compiled from: photo_pandora */
    public final class FBAggregatedEntitiesAtRangeParser {

        /* compiled from: photo_pandora */
        public final class SampleEntitiesParser {
            public static int m6452b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("cache_id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("url")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
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

            public static void m6451a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("cache_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                jsonGenerator.g();
            }
        }

        public static int m6453b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("length")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("offset")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("sample_entities")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(SampleEntitiesParser.m6452b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr3 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr3, true);
                        }
                        iArr[2] = i2;
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, iArr2[1], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static void m6454b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("length");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("offset");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 2);
            if (a != 0) {
                jsonGenerator.a("sample_entities");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                    SampleEntitiesParser.m6451a(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class FBMessengerSubscriptionInfoParser {

        /* compiled from: photo_pandora */
        public final class MessengerContentSubscriptionOptionParser {
            public static int m6455a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("content")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title")) {
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

            public static void m6456a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("content");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6457a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("messenger_content_subscription_option")) {
                        iArr[0] = MessengerContentSubscriptionOptionParser.m6455a(jsonParser, flatBufferBuilder);
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

    /* compiled from: photo_pandora */
    public final class FBPageParser {
        public static int m6458a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_like")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("does_viewer_like")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profilePicture50")) {
                        iArr[4] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static void m6459a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_viewer_like");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("does_viewer_like");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            int g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("profilePicture50");
                FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class FBPhotoParser {
        public static int m6460a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[1] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("intermediate_image")) {
                        iArr[2] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("preview_payload")) {
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

        public static void m6461a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("image");
                FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("intermediate_image");
                FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("preview_payload");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class FBProfileParser {
        public static int m6462a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profilePicture60")) {
                        iArr[3] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
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

        public static void m6463a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            int g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("profilePicture60");
                FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class FBTextWithEntitiesParser {

        /* compiled from: photo_pandora */
        public final class RangesParser {

            /* compiled from: photo_pandora */
            public final class EntityParser {
                public static int m6464a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[5];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("cache_id")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("id")) {
                                iArr[2] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("name")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
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

                public static void m6465a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("cache_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6467b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("entity")) {
                            iArr[0] = EntityParser.m6464a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("length")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("offset")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m6466a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m6467b(jsonParser, flatBufferBuilder)));
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

            public static void m6468b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("entity");
                    EntityParser.m6465a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("length");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("offset");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static int m6469a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("aggregated_ranges")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(FBAggregatedEntitiesAtRangeParser.m6453b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("ranges")) {
                        iArr[1] = RangesParser.m6466a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static void m6470a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int i2;
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("aggregated_ranges");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    FBAggregatedEntitiesAtRangeParser.m6454b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("ranges");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    RangesParser.m6468b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class FBVideoParser {

        /* compiled from: photo_pandora */
        public final class MessageParser {
            public static int m6471a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m6472a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m6473a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[21];
            boolean[] zArr = new boolean[10];
            boolean[] zArr2 = new boolean[1];
            int[] iArr2 = new int[7];
            double[] dArr = new double[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("height")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("initial_view_heading_degrees")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("initial_view_pitch_degrees")) {
                        zArr[2] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("initial_view_roll_degrees")) {
                        zArr[3] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("is_spherical")) {
                        zArr[4] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("message")) {
                        iArr[6] = MessageParser.m6471a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[5] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[8] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playable_url_hd")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playable_url_preferred")) {
                        iArr[10] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playlist")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("projection_type")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalFullscreenAspectRatio")) {
                        zArr[6] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("sphericalInlineAspectRatio")) {
                        zArr[7] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("sphericalPlayableUrlHdString")) {
                        iArr[15] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPlayableUrlSdString")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPlaylist")) {
                        iArr[17] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPreferredFov")) {
                        zArr[8] = true;
                        iArr2[5] = jsonParser.E();
                    } else if (i.equals("video_preview_image")) {
                        iArr[19] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("width")) {
                        zArr[9] = true;
                        iArr2[6] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(21);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr2[0], 0);
            }
            flatBufferBuilder.b(1, iArr[1]);
            if (zArr[1]) {
                flatBufferBuilder.a(2, iArr2[1], 0);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(3, iArr2[2], 0);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(4, iArr2[3], 0);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(5, zArr2[0]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[5]) {
                flatBufferBuilder.a(7, iArr2[4], 0);
            }
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            if (zArr[6]) {
                flatBufferBuilder.a(13, dArr[0], 0.0d);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(14, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            flatBufferBuilder.b(17, iArr[17]);
            if (zArr[8]) {
                flatBufferBuilder.a(18, iArr2[5], 0);
            }
            flatBufferBuilder.b(19, iArr[19]);
            if (zArr[9]) {
                flatBufferBuilder.a(20, iArr2[6], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m6474a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int a = mutableFlatBuffer.a(i, 0, 0);
            if (a != 0) {
                jsonGenerator.a("height");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            a = mutableFlatBuffer.a(i, 2, 0);
            if (a != 0) {
                jsonGenerator.a("initial_view_heading_degrees");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 3, 0);
            if (a != 0) {
                jsonGenerator.a("initial_view_pitch_degrees");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.a(i, 4, 0);
            if (a != 0) {
                jsonGenerator.a("initial_view_roll_degrees");
                jsonGenerator.b(a);
            }
            boolean a2 = mutableFlatBuffer.a(i, 5);
            if (a2) {
                jsonGenerator.a("is_spherical");
                jsonGenerator.a(a2);
            }
            a = mutableFlatBuffer.g(i, 6);
            if (a != 0) {
                jsonGenerator.a("message");
                MessageParser.m6472a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 7, 0);
            if (a != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("playable_url_hd");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            if (mutableFlatBuffer.g(i, 10) != 0) {
                jsonGenerator.a("playable_url_preferred");
                jsonGenerator.b(mutableFlatBuffer.c(i, 10));
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("playlist");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("projection_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            double a3 = mutableFlatBuffer.a(i, 13, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalFullscreenAspectRatio");
                jsonGenerator.a(a3);
            }
            a3 = mutableFlatBuffer.a(i, 14, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalInlineAspectRatio");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("sphericalPlayableUrlHdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 15));
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("sphericalPlayableUrlSdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("sphericalPlaylist");
                jsonGenerator.b(mutableFlatBuffer.c(i, 17));
            }
            a = mutableFlatBuffer.a(i, 18, 0);
            if (a != 0) {
                jsonGenerator.a("sphericalPreferredFov");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 19);
            if (a != 0) {
                jsonGenerator.a("video_preview_image");
                FBFullImageFragmentParser.a(mutableFlatBuffer, a, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 20, 0);
            if (a != 0) {
                jsonGenerator.a("width");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RelatedArticleDocumentKickerParser {

        /* compiled from: photo_pandora */
        public final class RelatedArticleVersionParser {
            public static int m6475a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("document_kicker")) {
                            iArr[0] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
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

            public static void m6476a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("document_kicker");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m6477a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("relatedArticleVersion")) {
                        iArr[1] = RelatedArticleVersionParser.m6475a(jsonParser, flatBufferBuilder);
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

        public static void m6478a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("relatedArticleVersion");
                RelatedArticleVersionParser.m6476a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RelatedArticleEdgeParser {

        /* compiled from: photo_pandora */
        public final class NodeParser {
            public static int m6479a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("global_share")) {
                            iArr[0] = RelatedArticleGlobalShareParser.m6489a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("is_sponsored")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                return flatBufferBuilder.d();
            }

            public static void m6480a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("global_share");
                    RelatedArticleGlobalShareParser.m6490a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("is_sponsored");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m6481b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("node")) {
                        iArr[0] = NodeParser.m6479a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m6482b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("node");
                NodeParser.m6480a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RelatedArticleGlobalShareParser {

        /* compiled from: photo_pandora */
        public final class LinkMediaParser {

            /* compiled from: photo_pandora */
            public final class ImageParser {
                public static int m6483a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m6484a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6485a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("image")) {
                            iArr[1] = ImageParser.m6483a(jsonParser, flatBufferBuilder);
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

            public static void m6486a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m6484a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: photo_pandora */
        public final class TitleParser {
            public static int m6487a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m6488a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m6489a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("external_url")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("instant_article")) {
                        iArr[2] = RelatedArticleDocumentKickerParser.m6477a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("link_media")) {
                        iArr[3] = LinkMediaParser.m6485a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[4] = TitleParser.m6487a(jsonParser, flatBufferBuilder);
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

        public static void m6490a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("external_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("instant_article");
                RelatedArticleDocumentKickerParser.m6478a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("link_media");
                LinkMediaParser.m6486a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("title");
                TitleParser.m6488a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentAuthorEdgeParser {
        public static int m6493b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("rich_document_author")) {
                        iArr[0] = RichDocumentAuthorParser.m6497a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static int m6491a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m6493b(jsonParser, flatBufferBuilder)));
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

        public static void m6492a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m6494b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m6494b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("rich_document_author");
                RichDocumentAuthorParser.m6498a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentAuthorParser {

        /* compiled from: photo_pandora */
        public final class ProfileParser {
            public static int m6495a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[7];
                boolean[] zArr = new boolean[2];
                boolean[] zArr2 = new boolean[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("can_viewer_like")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("does_viewer_like")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("id")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("name")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("profilePicture50")) {
                            iArr[5] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subscribe_status")) {
                            iArr[6] = flatBufferBuilder.a(GraphQLSubscribeStatus.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, zArr2[1]);
                }
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                return flatBufferBuilder.d();
            }

            public static void m6496a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_like");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 2);
                if (a) {
                    jsonGenerator.a("does_viewer_like");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                int g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("profilePicture50");
                    FBFullImageFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 6) != 0) {
                    jsonGenerator.a("subscribe_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 6));
                }
                jsonGenerator.g();
            }
        }

        public static int m6497a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("author_bio")) {
                        iArr[0] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("author_contribution")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("author_name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("include_in_byline")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_primary")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("profile")) {
                        iArr[6] = ProfileParser.m6495a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[0]) {
                flatBufferBuilder.a(4, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m6498a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("author_bio");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("author_contribution");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("author_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            boolean a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("include_in_byline");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("is_primary");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("profile");
                ProfileParser.m6496a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentBylineParser {
        public static int m6499a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("author_style")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLDocumentAuthorStyle.fromString(jsonParser.o()));
                    } else if (i.equals("date_style")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLDocumentDateStyle.fromString(jsonParser.o()));
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

        public static void m6500a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("author_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("date_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentEdgeParser {

        /* compiled from: photo_pandora */
        public final class CoverMediaParser {
            public static int m6501a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[20];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("audio_play_mode")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLAudioAnnotationPlayMode.fromString(jsonParser.o()));
                        } else if (i.equals("audio_title")) {
                            iArr[2] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("audio_url")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("copyright_annotation")) {
                            iArr[4] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("document_element_type")) {
                            iArr[5] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_video")) {
                            iArr[6] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback")) {
                            iArr[7] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback_options")) {
                            iArr[8] = flatBufferBuilder.a(GraphQLDocumentFeedbackOptions.fromString(jsonParser.o()));
                        } else if (i.equals("id")) {
                            iArr[9] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("location_annotation")) {
                            iArr[10] = RichDocumentLocationAnnotationParser.m6532a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("photo")) {
                            iArr[11] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("poster_image")) {
                            iArr[12] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("presentation_state")) {
                            iArr[13] = flatBufferBuilder.a(GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o()));
                        } else if (i.equals("slideEdges")) {
                            iArr[14] = SlideEdgesParser.m6579a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subtitle_annotation")) {
                            iArr[15] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title_annotation")) {
                            iArr[16] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_autoplay_style")) {
                            iArr[17] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_control_style")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_looping_style")) {
                            iArr[19] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
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
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
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

            public static void m6502a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("audio_play_mode");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("audio_title");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("audio_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("copyright_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 5));
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 8) != 0) {
                    jsonGenerator.a("feedback_options");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 8));
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("location_annotation");
                    RichDocumentLocationAnnotationParser.m6535b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("poster_image");
                    FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 13) != 0) {
                    jsonGenerator.a("presentation_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 13));
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("slideEdges");
                    SlideEdgesParser.m6580a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("subtitle_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("title_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 17) != 0) {
                    jsonGenerator.a("video_autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 17));
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("video_control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("video_looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: photo_pandora */
        public final class DocumentAuthorsParser {
            public static int m6503a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            iArr[0] = RichDocumentAuthorEdgeParser.m6491a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6504a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    RichDocumentAuthorEdgeParser.m6492a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: photo_pandora */
        public final class DocumentBodyElementsParser {
            public static int m6505a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("edges")) {
                            iArr[1] = RichDocumentSectionEdgeParser.m6573a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("page_info")) {
                            iArr[2] = DefaultPageInfoFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr2[0], 0);
                }
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m6506a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("edges");
                    RichDocumentSectionEdgeParser.m6574a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.g(i, 2);
                if (a != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m6507a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[21];
            boolean[] zArr = new boolean[3];
            int[] iArr2 = new int[1];
            long[] jArr = new long[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("article_canonical_url")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("article_version_number")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("copyright")) {
                        iArr[2] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("cover_media")) {
                        iArr[3] = CoverMediaParser.m6501a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("credits")) {
                        iArr[4] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_authors")) {
                        iArr[5] = DocumentAuthorsParser.m6503a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_body_elements")) {
                        iArr[6] = DocumentBodyElementsParser.m6505a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_description")) {
                        iArr[7] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_kicker")) {
                        iArr[8] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_owner")) {
                        iArr[9] = FBPageParser.m6458a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_style")) {
                        iArr[10] = RichDocumentStyleParser.m6584a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_subtitle")) {
                        iArr[11] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_title")) {
                        iArr[12] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[13] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback_options")) {
                        iArr[14] = flatBufferBuilder.a(GraphQLDocumentFeedbackOptions.fromString(jsonParser.o()));
                    } else if (i.equals("format_version")) {
                        iArr[15] = flatBufferBuilder.a(GraphQLDocumentFormatVersion.fromString(jsonParser.o()));
                    } else if (i.equals("id")) {
                        iArr[16] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("modified_timestamp")) {
                        zArr[1] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("publish_status")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLInstantArticlePublishStatus.fromString(jsonParser.o()));
                    } else if (i.equals("publish_timestamp")) {
                        zArr[2] = true;
                        jArr[1] = jsonParser.F();
                    } else if (i.equals("text_direction")) {
                        iArr[20] = flatBufferBuilder.a(GraphQLDocumentTextDirectionEnum.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(21);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, iArr2[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            flatBufferBuilder.b(11, iArr[11]);
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            if (zArr[1]) {
                flatBufferBuilder.a(17, jArr[0], 0);
            }
            flatBufferBuilder.b(18, iArr[18]);
            if (zArr[2]) {
                flatBufferBuilder.a(19, jArr[1], 0);
            }
            flatBufferBuilder.b(20, iArr[20]);
            return flatBufferBuilder.d();
        }

        public static void m6508a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("article_canonical_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("article_version_number");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 2);
            if (a != 0) {
                jsonGenerator.a("copyright");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 3);
            if (a != 0) {
                jsonGenerator.a("cover_media");
                CoverMediaParser.m6502a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 4);
            if (a != 0) {
                jsonGenerator.a("credits");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 5);
            if (a != 0) {
                jsonGenerator.a("document_authors");
                DocumentAuthorsParser.m6504a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 6);
            if (a != 0) {
                jsonGenerator.a("document_body_elements");
                DocumentBodyElementsParser.m6506a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 7);
            if (a != 0) {
                jsonGenerator.a("document_description");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 8);
            if (a != 0) {
                jsonGenerator.a("document_kicker");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 9);
            if (a != 0) {
                jsonGenerator.a("document_owner");
                FBPageParser.m6459a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 10);
            if (a != 0) {
                jsonGenerator.a("document_style");
                RichDocumentStyleParser.m6585a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 11);
            if (a != 0) {
                jsonGenerator.a("document_subtitle");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 12);
            if (a != 0) {
                jsonGenerator.a("document_title");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.g(i, 13);
            if (a != 0) {
                jsonGenerator.a("feedback");
                GraphQLFeedbackDeserializer.b(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 14) != 0) {
                jsonGenerator.a("feedback_options");
                jsonGenerator.b(mutableFlatBuffer.b(i, 14));
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("format_version");
                jsonGenerator.b(mutableFlatBuffer.b(i, 15));
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 16));
            }
            long a2 = mutableFlatBuffer.a(i, 17, 0);
            if (a2 != 0) {
                jsonGenerator.a("modified_timestamp");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("publish_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            a2 = mutableFlatBuffer.a(i, 19, 0);
            if (a2 != 0) {
                jsonGenerator.a("publish_timestamp");
                jsonGenerator.a(a2);
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("text_direction");
                jsonGenerator.b(mutableFlatBuffer.b(i, 20));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentElementStyleParser {
        public static int m6509a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("capitalization")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLCapitalizationStyle.fromString(jsonParser.o()));
                    } else if (i.equals("color")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("font")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("text_background_color")) {
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

        public static void m6510a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("capitalization");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("font");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("text_background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentFontResourceParser {
        public static int m6514b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("is_compressed")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("is_font_family")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("resource_name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("resource_version")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("url")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static int m6511a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m6514b(jsonParser, flatBufferBuilder)));
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

        public static void m6513a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m6512a(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator);
            }
            jsonGenerator.e();
        }

        public static void m6512a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("is_compressed");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_font_family");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("resource_name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("resource_version");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentGlobalShareParser {

        /* compiled from: photo_pandora */
        public final class LinkMediaParser {

            /* compiled from: photo_pandora */
            public final class ImageParser {
                public static int m6515a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m6516a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6517a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("image")) {
                            iArr[1] = ImageParser.m6515a(jsonParser, flatBufferBuilder);
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

            public static void m6518a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m6516a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: photo_pandora */
        public final class TitleParser {
            public static int m6519a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m6520a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m6521a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("external_url")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("link_media")) {
                        iArr[2] = LinkMediaParser.m6517a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[3] = TitleParser.m6519a(jsonParser, flatBufferBuilder);
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

        public static void m6522a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("external_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("link_media");
                LinkMediaParser.m6518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("title");
                TitleParser.m6520a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentLinkStyleParser {
        public static int m6523a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("color")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("font")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("underline_style")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLUnderlineStyle.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }

        public static void m6524a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("font");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("underline_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentListItemEdgeParser {

        /* compiled from: photo_pandora */
        public final class RichDocumentListItemParser {
            public static int m6525a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[35];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[1];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("audio_play_mode")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLAudioAnnotationPlayMode.fromString(jsonParser.o()));
                        } else if (i.equals("audio_title")) {
                            iArr[2] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("audio_url")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("base_url")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("block_title")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("copyright_annotation")) {
                            iArr[6] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("display_height")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("display_width")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("document_element_type")) {
                            iArr[9] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_text")) {
                            iArr[10] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_video")) {
                            iArr[11] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("enable_ad_network_bridging")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("feedback")) {
                            iArr[13] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback_options")) {
                            iArr[14] = flatBufferBuilder.a(GraphQLDocumentFeedbackOptions.fromString(jsonParser.o()));
                        } else if (i.equals("html_source")) {
                            iArr[15] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("l")) {
                            iArr[17] = LParser.m6563a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("list_style")) {
                            iArr[18] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
                        } else if (i.equals("location_annotation")) {
                            iArr[19] = RichDocumentLocationAnnotationParser.m6532a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_locations")) {
                            iArr[20] = RichDocumentLocationAnnotationParser.m6534b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_style")) {
                            iArr[21] = flatBufferBuilder.a(GraphQLDocumentMapStyle.fromString(jsonParser.o()));
                        } else if (i.equals("margin_style")) {
                            iArr[22] = flatBufferBuilder.a(GraphQLDocumentElementMarginStyle.fromString(jsonParser.o()));
                        } else if (i.equals("photo")) {
                            iArr[23] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("poster_image")) {
                            iArr[24] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("presentation_state")) {
                            iArr[25] = flatBufferBuilder.a(GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o()));
                        } else if (i.equals("related_article_objs")) {
                            iArr[26] = RelatedArticleObjsParser.m6568a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("slideEdges")) {
                            iArr[27] = SlideEdgesParser.m6579a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subtitle_annotation")) {
                            iArr[28] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text_background_color")) {
                            iArr[29] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title_annotation")) {
                            iArr[30] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_autoplay_style")) {
                            iArr[31] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_control_style")) {
                            iArr[32] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_looping_style")) {
                            iArr[33] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("webview_presentation_style")) {
                            iArr[34] = flatBufferBuilder.a(GraphQLDocumentWebviewPresentationStyle.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(35);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                if (zArr[0]) {
                    flatBufferBuilder.a(7, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(8, iArr2[1], 0);
                }
                flatBufferBuilder.b(9, iArr[9]);
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                if (zArr[2]) {
                    flatBufferBuilder.a(12, zArr2[0]);
                }
                flatBufferBuilder.b(13, iArr[13]);
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                flatBufferBuilder.b(24, iArr[24]);
                flatBufferBuilder.b(25, iArr[25]);
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                flatBufferBuilder.b(28, iArr[28]);
                flatBufferBuilder.b(29, iArr[29]);
                flatBufferBuilder.b(30, iArr[30]);
                flatBufferBuilder.b(31, iArr[31]);
                flatBufferBuilder.b(32, iArr[32]);
                flatBufferBuilder.b(33, iArr[33]);
                flatBufferBuilder.b(34, iArr[34]);
                return flatBufferBuilder.d();
            }

            public static void m6526a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("audio_play_mode");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("audio_title");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("audio_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("base_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("block_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("copyright_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 7, 0);
                if (g != 0) {
                    jsonGenerator.a("display_height");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 8, 0);
                if (g != 0) {
                    jsonGenerator.a("display_width");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 9) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 9));
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(i, 12);
                if (a) {
                    jsonGenerator.a("enable_ad_network_bridging");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 14) != 0) {
                    jsonGenerator.a("feedback_options");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 14));
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("html_source");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("l");
                    LParser.m6564a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 18) != 0) {
                    jsonGenerator.a("list_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 18));
                }
                g = mutableFlatBuffer.g(i, 19);
                if (g != 0) {
                    jsonGenerator.a("location_annotation");
                    RichDocumentLocationAnnotationParser.m6535b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 20);
                if (g != 0) {
                    jsonGenerator.a("map_locations");
                    RichDocumentLocationAnnotationParser.m6533a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 21) != 0) {
                    jsonGenerator.a("map_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 21));
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("margin_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 22));
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("poster_image");
                    FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 25) != 0) {
                    jsonGenerator.a("presentation_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 25));
                }
                g = mutableFlatBuffer.g(i, 26);
                if (g != 0) {
                    jsonGenerator.a("related_article_objs");
                    RelatedArticleObjsParser.m6569a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("slideEdges");
                    SlideEdgesParser.m6580a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 28);
                if (g != 0) {
                    jsonGenerator.a("subtitle_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 29) != 0) {
                    jsonGenerator.a("text_background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 29));
                }
                g = mutableFlatBuffer.g(i, 30);
                if (g != 0) {
                    jsonGenerator.a("title_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 31) != 0) {
                    jsonGenerator.a("video_autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 31));
                }
                if (mutableFlatBuffer.g(i, 32) != 0) {
                    jsonGenerator.a("video_control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 32));
                }
                if (mutableFlatBuffer.g(i, 33) != 0) {
                    jsonGenerator.a("video_looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 33));
                }
                if (mutableFlatBuffer.g(i, 34) != 0) {
                    jsonGenerator.a("webview_presentation_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 34));
                }
                jsonGenerator.g();
            }
        }

        public static int m6527b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("rich_document_list_item")) {
                        iArr[0] = RichDocumentListItemParser.m6525a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m6528b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("rich_document_list_item");
                RichDocumentListItemParser.m6526a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentListItemsParser {

        /* compiled from: photo_pandora */
        public final class ListElementsParser {
            public static int m6529a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(RichDocumentListItemEdgeParser.m6527b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6530a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RichDocumentListItemEdgeParser.m6528b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6531a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("list_elements")) {
                        iArr[0] = ListElementsParser.m6529a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("list_style")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentLocationAnnotationParser {
        public static int m6532a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            double[] dArr = new double[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("location_latlong")) {
                        iArr[0] = DefaultLocationFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_radius")) {
                        zArr[0] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("location_subtitle")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("location_title")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, dArr[0], 0.0d);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }

        public static int m6534b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m6532a(jsonParser, flatBufferBuilder)));
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

        public static void m6533a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m6535b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m6535b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("location_latlong");
                DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            double a = mutableFlatBuffer.a(i, 1, 0.0d);
            if (a != 0.0d) {
                jsonGenerator.a("location_radius");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("location_subtitle");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("location_title");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentLogoParser {
        public static int m6536a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[6];
            boolean[] zArr = new boolean[2];
            int[] iArr2 = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("accent_color")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("background_color")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bar_color")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("heightDps")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("url")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("widthDps")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[0]) {
                flatBufferBuilder.a(3, iArr2[0], 0);
            }
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, iArr2[1], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m6537a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("accent_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("bar_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            int a = mutableFlatBuffer.a(i, 3, 0);
            if (a != 0) {
                jsonGenerator.a("heightDps");
                jsonGenerator.b(a);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            a = mutableFlatBuffer.a(i, 5, 0);
            if (a != 0) {
                jsonGenerator.a("widthDps");
                jsonGenerator.b(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentMasterParser {

        /* compiled from: photo_pandora */
        public final class RelatedArticleObjectsParser {
            public static int m6538a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("nodes")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(RichDocumentRelatedArticleParser.m6566b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6539a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RichDocumentRelatedArticleParser.m6567b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6540a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("feedback")) {
                        iArr[0] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("global_share")) {
                        iArr[1] = RichDocumentGlobalShareParser.m6521a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("messenger_content_subscription_option")) {
                        iArr[3] = MessengerContentSubscriptionOptionParser.m6455a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("related_article_objects")) {
                        iArr[4] = RelatedArticleObjectsParser.m6538a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("rich_document_edge")) {
                        iArr[5] = RichDocumentEdgeParser.m6507a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentNestedListItemFieldsParser {
        public static int m6541a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("document_element_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_text")) {
                        iArr[2] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("list_style")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
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

        public static void m6542a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("document_element_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("element_text");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("list_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentNestedListItemParser {

        /* compiled from: photo_pandora */
        public final class LParser {

            /* compiled from: photo_pandora */
            public final class EParser {

                /* compiled from: photo_pandora */
                public final class NParser {

                    /* compiled from: photo_pandora */
                    public final class NLParser {

                        /* compiled from: photo_pandora */
                        public final class NLEParser {

                            /* compiled from: photo_pandora */
                            public final class NLENParser {

                                /* compiled from: photo_pandora */
                                public final class NLENLParser {

                                    /* compiled from: photo_pandora */
                                    public final class NLENLEParser {

                                        /* compiled from: photo_pandora */
                                        public final class NLENLENParser {

                                            /* compiled from: photo_pandora */
                                            public final class NLENLENLParser {

                                                /* compiled from: photo_pandora */
                                                public final class NLENLENLEParser {
                                                    public static int m6543b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                                        int[] iArr = new int[1];
                                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                                            String i = jsonParser.i();
                                                            jsonParser.c();
                                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                                if (i.equals("n")) {
                                                                    iArr[0] = RichDocumentNestedListItemFieldsParser.m6541a(jsonParser, flatBufferBuilder);
                                                                } else {
                                                                    jsonParser.f();
                                                                }
                                                            }
                                                        }
                                                        flatBufferBuilder.c(1);
                                                        flatBufferBuilder.b(0, iArr[0]);
                                                        return flatBufferBuilder.d();
                                                    }

                                                    public static void m6544b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                        jsonGenerator.f();
                                                        int g = mutableFlatBuffer.g(i, 0);
                                                        if (g != 0) {
                                                            jsonGenerator.a("n");
                                                            RichDocumentNestedListItemFieldsParser.m6542a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                                        }
                                                        jsonGenerator.g();
                                                    }
                                                }

                                                public static int m6545a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                                    int[] iArr = new int[1];
                                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                                        String i = jsonParser.i();
                                                        jsonParser.c();
                                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                            if (i.equals("e")) {
                                                                int i2 = 0;
                                                                ArrayList arrayList = new ArrayList();
                                                                if (jsonParser.g() == JsonToken.START_ARRAY) {
                                                                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                                        arrayList.add(Integer.valueOf(NLENLENLEParser.m6543b(jsonParser, flatBufferBuilder)));
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
                                                            } else {
                                                                jsonParser.f();
                                                            }
                                                        }
                                                    }
                                                    flatBufferBuilder.c(1);
                                                    flatBufferBuilder.b(0, iArr[0]);
                                                    return flatBufferBuilder.d();
                                                }

                                                public static void m6546a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                    jsonGenerator.f();
                                                    int g = mutableFlatBuffer.g(i, 0);
                                                    if (g != 0) {
                                                        jsonGenerator.a("e");
                                                        jsonGenerator.d();
                                                        for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                                            NLENLENLEParser.m6544b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                                        }
                                                        jsonGenerator.e();
                                                    }
                                                    jsonGenerator.g();
                                                }
                                            }

                                            public static int m6547a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                                int[] iArr = new int[5];
                                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                                    String i = jsonParser.i();
                                                    jsonParser.c();
                                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                        if (i.equals("__type__")) {
                                                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                                        } else if (i.equals("document_element_type")) {
                                                            iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                                                        } else if (i.equals("element_text")) {
                                                            iArr[2] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                                                        } else if (i.equals("l")) {
                                                            iArr[3] = NLENLENLParser.m6545a(jsonParser, flatBufferBuilder);
                                                        } else if (i.equals("list_style")) {
                                                            iArr[4] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
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

                                            public static void m6548a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                                jsonGenerator.f();
                                                if (mutableFlatBuffer.g(i, 0) != 0) {
                                                    jsonGenerator.a("__type__");
                                                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                                }
                                                if (mutableFlatBuffer.g(i, 1) != 0) {
                                                    jsonGenerator.a("document_element_type");
                                                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                                                }
                                                int g = mutableFlatBuffer.g(i, 2);
                                                if (g != 0) {
                                                    jsonGenerator.a("element_text");
                                                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                                }
                                                g = mutableFlatBuffer.g(i, 3);
                                                if (g != 0) {
                                                    jsonGenerator.a("l");
                                                    NLENLENLParser.m6546a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                                }
                                                if (mutableFlatBuffer.g(i, 4) != 0) {
                                                    jsonGenerator.a("list_style");
                                                    jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                                                }
                                                jsonGenerator.g();
                                            }
                                        }

                                        public static int m6549b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                            int[] iArr = new int[1];
                                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                                String i = jsonParser.i();
                                                jsonParser.c();
                                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                    if (i.equals("n")) {
                                                        iArr[0] = NLENLENParser.m6547a(jsonParser, flatBufferBuilder);
                                                    } else {
                                                        jsonParser.f();
                                                    }
                                                }
                                            }
                                            flatBufferBuilder.c(1);
                                            flatBufferBuilder.b(0, iArr[0]);
                                            return flatBufferBuilder.d();
                                        }

                                        public static void m6550b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            jsonGenerator.f();
                                            int g = mutableFlatBuffer.g(i, 0);
                                            if (g != 0) {
                                                jsonGenerator.a("n");
                                                NLENLENParser.m6548a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                            }
                                            jsonGenerator.g();
                                        }
                                    }

                                    public static int m6551a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                        int[] iArr = new int[1];
                                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                                            String i = jsonParser.i();
                                            jsonParser.c();
                                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                                if (i.equals("e")) {
                                                    int i2 = 0;
                                                    ArrayList arrayList = new ArrayList();
                                                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                                                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                            arrayList.add(Integer.valueOf(NLENLEParser.m6549b(jsonParser, flatBufferBuilder)));
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
                                                } else {
                                                    jsonParser.f();
                                                }
                                            }
                                        }
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, iArr[0]);
                                        return flatBufferBuilder.d();
                                    }

                                    public static void m6552a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        jsonGenerator.f();
                                        int g = mutableFlatBuffer.g(i, 0);
                                        if (g != 0) {
                                            jsonGenerator.a("e");
                                            jsonGenerator.d();
                                            for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                                NLENLEParser.m6550b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                            }
                                            jsonGenerator.e();
                                        }
                                        jsonGenerator.g();
                                    }
                                }

                                public static int m6553a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                    int[] iArr = new int[5];
                                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                                        String i = jsonParser.i();
                                        jsonParser.c();
                                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                            if (i.equals("__type__")) {
                                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                            } else if (i.equals("document_element_type")) {
                                                iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                                            } else if (i.equals("element_text")) {
                                                iArr[2] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("l")) {
                                                iArr[3] = NLENLParser.m6551a(jsonParser, flatBufferBuilder);
                                            } else if (i.equals("list_style")) {
                                                iArr[4] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
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

                                public static void m6554a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    jsonGenerator.f();
                                    if (mutableFlatBuffer.g(i, 0) != 0) {
                                        jsonGenerator.a("__type__");
                                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                                    }
                                    if (mutableFlatBuffer.g(i, 1) != 0) {
                                        jsonGenerator.a("document_element_type");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                                    }
                                    int g = mutableFlatBuffer.g(i, 2);
                                    if (g != 0) {
                                        jsonGenerator.a("element_text");
                                        RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                    }
                                    g = mutableFlatBuffer.g(i, 3);
                                    if (g != 0) {
                                        jsonGenerator.a("l");
                                        NLENLParser.m6552a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                    }
                                    if (mutableFlatBuffer.g(i, 4) != 0) {
                                        jsonGenerator.a("list_style");
                                        jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                                    }
                                    jsonGenerator.g();
                                }
                            }

                            public static int m6555b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                                int[] iArr = new int[1];
                                while (jsonParser.c() != JsonToken.END_OBJECT) {
                                    String i = jsonParser.i();
                                    jsonParser.c();
                                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                        if (i.equals("n")) {
                                            iArr[0] = NLENParser.m6553a(jsonParser, flatBufferBuilder);
                                        } else {
                                            jsonParser.f();
                                        }
                                    }
                                }
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, iArr[0]);
                                return flatBufferBuilder.d();
                            }

                            public static void m6556b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                jsonGenerator.f();
                                int g = mutableFlatBuffer.g(i, 0);
                                if (g != 0) {
                                    jsonGenerator.a("n");
                                    NLENParser.m6554a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.g();
                            }
                        }

                        public static int m6557a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[1];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("e")) {
                                        int i2 = 0;
                                        ArrayList arrayList = new ArrayList();
                                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                arrayList.add(Integer.valueOf(NLEParser.m6555b(jsonParser, flatBufferBuilder)));
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
                                    } else {
                                        jsonParser.f();
                                    }
                                }
                            }
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, iArr[0]);
                            return flatBufferBuilder.d();
                        }

                        public static void m6558a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("e");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    NLEParser.m6556b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                                }
                                jsonGenerator.e();
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m6559a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[5];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("document_element_type")) {
                                    iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                                } else if (i.equals("element_text")) {
                                    iArr[2] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("l")) {
                                    iArr[3] = NLParser.m6557a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("list_style")) {
                                    iArr[4] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
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

                    public static void m6560a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        if (mutableFlatBuffer.g(i, 1) != 0) {
                            jsonGenerator.a("document_element_type");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                        }
                        int g = mutableFlatBuffer.g(i, 2);
                        if (g != 0) {
                            jsonGenerator.a("element_text");
                            RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        g = mutableFlatBuffer.g(i, 3);
                        if (g != 0) {
                            jsonGenerator.a("l");
                            NLParser.m6558a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                        }
                        if (mutableFlatBuffer.g(i, 4) != 0) {
                            jsonGenerator.a("list_style");
                            jsonGenerator.b(mutableFlatBuffer.b(i, 4));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m6561b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("n")) {
                                iArr[0] = NParser.m6559a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m6562b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("n");
                        NParser.m6560a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6563a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("e")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EParser.m6561b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6564a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("e");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EParser.m6562b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6565a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("document_element_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_text")) {
                        iArr[2] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("l")) {
                        iArr[3] = LParser.m6563a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("list_style")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentRelatedArticleParser {
        public static int m6566b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("global_share")) {
                        iArr[0] = RelatedArticleGlobalShareParser.m6489a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_sponsored")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            return flatBufferBuilder.d();
        }

        public static void m6567b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("global_share");
                RelatedArticleGlobalShareParser.m6490a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_sponsored");
                jsonGenerator.a(a);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentRelatedArticlesParser {

        /* compiled from: photo_pandora */
        public final class RelatedArticleObjsParser {
            public static int m6568a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(RelatedArticleEdgeParser.m6481b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6569a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RelatedArticleEdgeParser.m6482b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6570a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("block_title")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("document_element_type")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("related_article_objs")) {
                        iArr[3] = RelatedArticleObjsParser.m6568a(jsonParser, flatBufferBuilder);
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
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentSectionEdgeParser {

        /* compiled from: photo_pandora */
        public final class RichDocumentSectionParser {
            public static int m6571a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[36];
                boolean[] zArr = new boolean[3];
                boolean[] zArr2 = new boolean[1];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("audio_play_mode")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLAudioAnnotationPlayMode.fromString(jsonParser.o()));
                        } else if (i.equals("audio_title")) {
                            iArr[2] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("audio_url")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("base_url")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("block_title")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("blocks")) {
                            iArr[6] = RichDocumentTextParser.m6597b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("copyright_annotation")) {
                            iArr[7] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("display_height")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("display_width")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else if (i.equals("document_element_type")) {
                            iArr[10] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                        } else if (i.equals("element_text")) {
                            iArr[11] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("element_video")) {
                            iArr[12] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("enable_ad_network_bridging")) {
                            zArr[2] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("feedback")) {
                            iArr[14] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback_options")) {
                            iArr[15] = flatBufferBuilder.a(GraphQLDocumentFeedbackOptions.fromString(jsonParser.o()));
                        } else if (i.equals("html_source")) {
                            iArr[16] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
                            iArr[17] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("list_elements")) {
                            iArr[18] = ListElementsParser.m6529a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("list_style")) {
                            iArr[19] = flatBufferBuilder.a(GraphQLDocumentListStyle.fromString(jsonParser.o()));
                        } else if (i.equals("location_annotation")) {
                            iArr[20] = RichDocumentLocationAnnotationParser.m6532a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_locations")) {
                            iArr[21] = RichDocumentLocationAnnotationParser.m6534b(jsonParser, flatBufferBuilder);
                        } else if (i.equals("map_style")) {
                            iArr[22] = flatBufferBuilder.a(GraphQLDocumentMapStyle.fromString(jsonParser.o()));
                        } else if (i.equals("margin_style")) {
                            iArr[23] = flatBufferBuilder.a(GraphQLDocumentElementMarginStyle.fromString(jsonParser.o()));
                        } else if (i.equals("photo")) {
                            iArr[24] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("poster_image")) {
                            iArr[25] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("presentation_state")) {
                            iArr[26] = flatBufferBuilder.a(GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o()));
                        } else if (i.equals("related_article_objs")) {
                            iArr[27] = RelatedArticleObjsParser.m6568a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("slideEdges")) {
                            iArr[28] = SlideEdgesParser.m6579a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subtitle_annotation")) {
                            iArr[29] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("text_background_color")) {
                            iArr[30] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("title_annotation")) {
                            iArr[31] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("video_autoplay_style")) {
                            iArr[32] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_control_style")) {
                            iArr[33] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                        } else if (i.equals("video_looping_style")) {
                            iArr[34] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
                        } else if (i.equals("webview_presentation_style")) {
                            iArr[35] = flatBufferBuilder.a(GraphQLDocumentWebviewPresentationStyle.fromString(jsonParser.o()));
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(36);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                if (zArr[0]) {
                    flatBufferBuilder.a(8, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(9, iArr2[1], 0);
                }
                flatBufferBuilder.b(10, iArr[10]);
                flatBufferBuilder.b(11, iArr[11]);
                flatBufferBuilder.b(12, iArr[12]);
                if (zArr[2]) {
                    flatBufferBuilder.a(13, zArr2[0]);
                }
                flatBufferBuilder.b(14, iArr[14]);
                flatBufferBuilder.b(15, iArr[15]);
                flatBufferBuilder.b(16, iArr[16]);
                flatBufferBuilder.b(17, iArr[17]);
                flatBufferBuilder.b(18, iArr[18]);
                flatBufferBuilder.b(19, iArr[19]);
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                flatBufferBuilder.b(24, iArr[24]);
                flatBufferBuilder.b(25, iArr[25]);
                flatBufferBuilder.b(26, iArr[26]);
                flatBufferBuilder.b(27, iArr[27]);
                flatBufferBuilder.b(28, iArr[28]);
                flatBufferBuilder.b(29, iArr[29]);
                flatBufferBuilder.b(30, iArr[30]);
                flatBufferBuilder.b(31, iArr[31]);
                flatBufferBuilder.b(32, iArr[32]);
                flatBufferBuilder.b(33, iArr[33]);
                flatBufferBuilder.b(34, iArr[34]);
                flatBufferBuilder.b(35, iArr[35]);
                return flatBufferBuilder.d();
            }

            public static void m6572a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("audio_play_mode");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                int g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("audio_title");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("audio_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("base_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("block_title");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("blocks");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RichDocumentTextParser.m6598b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("copyright_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(i, 8, 0);
                if (g != 0) {
                    jsonGenerator.a("display_height");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 9, 0);
                if (g != 0) {
                    jsonGenerator.a("display_width");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(i, 10) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 10));
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("element_text");
                    RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("element_video");
                    FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(i, 13);
                if (a) {
                    jsonGenerator.a("enable_ad_network_bridging");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 15) != 0) {
                    jsonGenerator.a("feedback_options");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 15));
                }
                if (mutableFlatBuffer.g(i, 16) != 0) {
                    jsonGenerator.a("html_source");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                }
                if (mutableFlatBuffer.g(i, 17) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("list_elements");
                    ListElementsParser.m6530a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 19) != 0) {
                    jsonGenerator.a("list_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 19));
                }
                g = mutableFlatBuffer.g(i, 20);
                if (g != 0) {
                    jsonGenerator.a("location_annotation");
                    RichDocumentLocationAnnotationParser.m6535b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("map_locations");
                    RichDocumentLocationAnnotationParser.m6533a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 22) != 0) {
                    jsonGenerator.a("map_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 22));
                }
                if (mutableFlatBuffer.g(i, 23) != 0) {
                    jsonGenerator.a("margin_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 23));
                }
                g = mutableFlatBuffer.g(i, 24);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 25);
                if (g != 0) {
                    jsonGenerator.a("poster_image");
                    FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 26) != 0) {
                    jsonGenerator.a("presentation_state");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 26));
                }
                g = mutableFlatBuffer.g(i, 27);
                if (g != 0) {
                    jsonGenerator.a("related_article_objs");
                    RelatedArticleObjsParser.m6569a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 28);
                if (g != 0) {
                    jsonGenerator.a("slideEdges");
                    SlideEdgesParser.m6580a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 29);
                if (g != 0) {
                    jsonGenerator.a("subtitle_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 30) != 0) {
                    jsonGenerator.a("text_background_color");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 30));
                }
                g = mutableFlatBuffer.g(i, 31);
                if (g != 0) {
                    jsonGenerator.a("title_annotation");
                    RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 32) != 0) {
                    jsonGenerator.a("video_autoplay_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 32));
                }
                if (mutableFlatBuffer.g(i, 33) != 0) {
                    jsonGenerator.a("video_control_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 33));
                }
                if (mutableFlatBuffer.g(i, 34) != 0) {
                    jsonGenerator.a("video_looping_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 34));
                }
                if (mutableFlatBuffer.g(i, 35) != 0) {
                    jsonGenerator.a("webview_presentation_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 35));
                }
                jsonGenerator.g();
            }
        }

        public static int m6575b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("rich_document_section")) {
                        iArr[0] = RichDocumentSectionParser.m6571a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static int m6573a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m6575b(jsonParser, flatBufferBuilder)));
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

        public static void m6574a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m6576b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m6576b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("rich_document_section");
                RichDocumentSectionParser.m6572a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentSlideParser {
        public static int m6577b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[19];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("audio_play_mode")) {
                        iArr[1] = flatBufferBuilder.a(GraphQLAudioAnnotationPlayMode.fromString(jsonParser.o()));
                    } else if (i.equals("audio_title")) {
                        iArr[2] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("audio_url")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("copyright_annotation")) {
                        iArr[4] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("document_element_type")) {
                        iArr[5] = flatBufferBuilder.a(GraphQLDocumentElementType.fromString(jsonParser.o()));
                    } else if (i.equals("element_video")) {
                        iArr[6] = FBVideoParser.m6473a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[7] = GraphQLFeedbackDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback_options")) {
                        iArr[8] = flatBufferBuilder.a(GraphQLDocumentFeedbackOptions.fromString(jsonParser.o()));
                    } else if (i.equals("id")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("location_annotation")) {
                        iArr[10] = RichDocumentLocationAnnotationParser.m6532a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo")) {
                        iArr[11] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("poster_image")) {
                        iArr[12] = FBPhotoParser.m6460a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("presentation_state")) {
                        iArr[13] = flatBufferBuilder.a(GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o()));
                    } else if (i.equals("subtitle_annotation")) {
                        iArr[14] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title_annotation")) {
                        iArr[15] = RichDocumentTextAnnotationParser.m6586a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_autoplay_style")) {
                        iArr[16] = flatBufferBuilder.a(GraphQLDocumentVideoAutoplayStyle.fromString(jsonParser.o()));
                    } else if (i.equals("video_control_style")) {
                        iArr[17] = flatBufferBuilder.a(GraphQLDocumentVideoControlStyle.fromString(jsonParser.o()));
                    } else if (i.equals("video_looping_style")) {
                        iArr[18] = flatBufferBuilder.a(GraphQLDocumentVideoLoopingStyle.fromString(jsonParser.o()));
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
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
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
            return flatBufferBuilder.d();
        }

        public static void m6578b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("audio_play_mode");
                jsonGenerator.b(mutableFlatBuffer.b(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("audio_title");
                RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("audio_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("copyright_annotation");
                RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 5) != 0) {
                jsonGenerator.a("document_element_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 5));
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("element_video");
                FBVideoParser.m6474a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("feedback");
                GraphQLFeedbackDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 8) != 0) {
                jsonGenerator.a("feedback_options");
                jsonGenerator.b(mutableFlatBuffer.b(i, 8));
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("location_annotation");
                RichDocumentLocationAnnotationParser.m6535b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("photo");
                FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("poster_image");
                FBPhotoParser.m6461a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("presentation_state");
                jsonGenerator.b(mutableFlatBuffer.b(i, 13));
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("subtitle_annotation");
                RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("title_annotation");
                RichDocumentTextAnnotationParser.m6587a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 16) != 0) {
                jsonGenerator.a("video_autoplay_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 16));
            }
            if (mutableFlatBuffer.g(i, 17) != 0) {
                jsonGenerator.a("video_control_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 17));
            }
            if (mutableFlatBuffer.g(i, 18) != 0) {
                jsonGenerator.a("video_looping_style");
                jsonGenerator.b(mutableFlatBuffer.b(i, 18));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentSlideshowParser {

        /* compiled from: photo_pandora */
        public final class SlideEdgesParser {
            public static int m6579a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("slide")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(RichDocumentSlideParser.m6577b(jsonParser, flatBufferBuilder)));
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
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m6580a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("slide");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        RichDocumentSlideParser.m6578b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m6581a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("presentation_state")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLDocumentMediaPresentationStyle.fromString(jsonParser.o()));
                    } else if (i.equals("slideEdges")) {
                        iArr[1] = SlideEdgesParser.m6579a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentStyleParser {

        /* compiled from: photo_pandora */
        public final class FallbackArticleStyleParser {
            public static int m6582a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[24];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("body_text_style")) {
                            iArr[0] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("byline")) {
                            iArr[1] = RichDocumentBylineParser.m6499a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("byline_style")) {
                            iArr[2] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_credit_style")) {
                            iArr[3] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_description_extra_large_style")) {
                            iArr[4] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_description_large_style")) {
                            iArr[5] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_description_medium_style")) {
                            iArr[6] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_description_small_style")) {
                            iArr[7] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_title_extra_large_style")) {
                            iArr[8] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_title_large_style")) {
                            iArr[9] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_title_medium_style")) {
                            iArr[10] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("caption_title_small_style")) {
                            iArr[11] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("custom_fonts")) {
                            iArr[12] = RichDocumentFontResourceParser.m6511a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("end_credits_style")) {
                            iArr[13] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_one_style")) {
                            iArr[14] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("header_two_style")) {
                            iArr[15] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("kicker_style")) {
                            iArr[16] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("link_style")) {
                            iArr[17] = RichDocumentLinkStyleParser.m6523a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("logo")) {
                            iArr[18] = RichDocumentLogoParser.m6536a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("pull_quote_attribution_style")) {
                            iArr[19] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("pull_quote_style")) {
                            iArr[20] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("related_articles_style")) {
                            iArr[21] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("subtitle_style")) {
                            iArr[22] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title_style")) {
                            iArr[23] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(24);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
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
                flatBufferBuilder.b(20, iArr[20]);
                flatBufferBuilder.b(21, iArr[21]);
                flatBufferBuilder.b(22, iArr[22]);
                flatBufferBuilder.b(23, iArr[23]);
                return flatBufferBuilder.d();
            }

            public static void m6583a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("body_text_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("byline");
                    RichDocumentBylineParser.m6500a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("byline_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("caption_credit_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("caption_description_extra_large_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("caption_description_large_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("caption_description_medium_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("caption_description_small_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 8);
                if (g != 0) {
                    jsonGenerator.a("caption_title_extra_large_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 9);
                if (g != 0) {
                    jsonGenerator.a("caption_title_large_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 10);
                if (g != 0) {
                    jsonGenerator.a("caption_title_medium_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 11);
                if (g != 0) {
                    jsonGenerator.a("caption_title_small_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 12);
                if (g != 0) {
                    jsonGenerator.a("custom_fonts");
                    RichDocumentFontResourceParser.m6513a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(i, 13);
                if (g != 0) {
                    jsonGenerator.a("end_credits_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 14);
                if (g != 0) {
                    jsonGenerator.a("header_one_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 15);
                if (g != 0) {
                    jsonGenerator.a("header_two_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 16);
                if (g != 0) {
                    jsonGenerator.a("kicker_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 17);
                if (g != 0) {
                    jsonGenerator.a("link_style");
                    RichDocumentLinkStyleParser.m6524a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 18);
                if (g != 0) {
                    jsonGenerator.a("logo");
                    RichDocumentLogoParser.m6537a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 19);
                if (g != 0) {
                    jsonGenerator.a("pull_quote_attribution_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 20);
                if (g != 0) {
                    jsonGenerator.a("pull_quote_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 21);
                if (g != 0) {
                    jsonGenerator.a("related_articles_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 22);
                if (g != 0) {
                    jsonGenerator.a("subtitle_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 23);
                if (g != 0) {
                    jsonGenerator.a("title_style");
                    RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m6584a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[27];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("background_color")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("body_text_style")) {
                        iArr[1] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("byline")) {
                        iArr[2] = RichDocumentBylineParser.m6499a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("byline_style")) {
                        iArr[3] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_credit_style")) {
                        iArr[4] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_description_extra_large_style")) {
                        iArr[5] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_description_large_style")) {
                        iArr[6] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_description_medium_style")) {
                        iArr[7] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_description_small_style")) {
                        iArr[8] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_title_extra_large_style")) {
                        iArr[9] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_title_large_style")) {
                        iArr[10] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_title_medium_style")) {
                        iArr[11] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("caption_title_small_style")) {
                        iArr[12] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("custom_fonts")) {
                        iArr[13] = RichDocumentFontResourceParser.m6511a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("end_credits_style")) {
                        iArr[14] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("fallback_article_style")) {
                        iArr[15] = FallbackArticleStyleParser.m6582a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_one_style")) {
                        iArr[16] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("header_two_style")) {
                        iArr[17] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("include_end_credits")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("kicker_style")) {
                        iArr[19] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("link_style")) {
                        iArr[20] = RichDocumentLinkStyleParser.m6523a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("logo")) {
                        iArr[21] = RichDocumentLogoParser.m6536a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pull_quote_attribution_style")) {
                        iArr[22] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pull_quote_style")) {
                        iArr[23] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("related_articles_style")) {
                        iArr[24] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("subtitle_style")) {
                        iArr[25] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title_style")) {
                        iArr[26] = RichDocumentElementStyleParser.m6509a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(27);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
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
            if (zArr[0]) {
                flatBufferBuilder.a(18, zArr2[0]);
            }
            flatBufferBuilder.b(19, iArr[19]);
            flatBufferBuilder.b(20, iArr[20]);
            flatBufferBuilder.b(21, iArr[21]);
            flatBufferBuilder.b(22, iArr[22]);
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            return flatBufferBuilder.d();
        }

        public static void m6585a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("background_color");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("body_text_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("byline");
                RichDocumentBylineParser.m6500a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("byline_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("caption_credit_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("caption_description_extra_large_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("caption_description_large_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("caption_description_medium_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("caption_description_small_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("caption_title_extra_large_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("caption_title_large_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 11);
            if (g != 0) {
                jsonGenerator.a("caption_title_medium_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 12);
            if (g != 0) {
                jsonGenerator.a("caption_title_small_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("custom_fonts");
                RichDocumentFontResourceParser.m6513a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("end_credits_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("fallback_article_style");
                FallbackArticleStyleParser.m6583a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("header_one_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("header_two_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 18);
            if (a) {
                jsonGenerator.a("include_end_credits");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("kicker_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("link_style");
                RichDocumentLinkStyleParser.m6524a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("logo");
                RichDocumentLogoParser.m6537a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("pull_quote_attribution_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("pull_quote_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("related_articles_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("subtitle_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("title_style");
                RichDocumentElementStyleParser.m6510a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentTextAnnotationParser {
        public static int m6586a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("annotation_rich_text")) {
                        iArr[0] = RichDocumentTextParser.m6596a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("annotation_text")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("text_alignment")) {
                        iArr[2] = flatBufferBuilder.a(GraphQLTextAnnotationHorizontalPosition.fromString(jsonParser.o()));
                    } else if (i.equals("text_size")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLTextAnnotationPresentationStyle.fromString(jsonParser.o()));
                    } else if (i.equals("text_slot")) {
                        iArr[4] = flatBufferBuilder.a(GraphQLTextAnnotationVerticalPosition.fromString(jsonParser.o()));
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

        public static void m6587a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("annotation_rich_text");
                RichDocumentTextParser.m6598b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("annotation_text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("text_alignment");
                jsonGenerator.b(mutableFlatBuffer.b(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("text_size");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("text_slot");
                jsonGenerator.b(mutableFlatBuffer.b(i, 4));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentTextParser {

        /* compiled from: photo_pandora */
        public final class EntityRangesParser {

            /* compiled from: photo_pandora */
            public final class EntityParser {
                public static int m6588a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[30];
                    boolean[] zArr = new boolean[10];
                    boolean[] zArr2 = new boolean[1];
                    int[] iArr2 = new int[7];
                    double[] dArr = new double[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("external_url")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("height")) {
                                zArr[0] = true;
                                iArr2[0] = jsonParser.E();
                            } else if (i.equals("id")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("image")) {
                                iArr[4] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("initial_view_heading_degrees")) {
                                zArr[1] = true;
                                iArr2[1] = jsonParser.E();
                            } else if (i.equals("initial_view_pitch_degrees")) {
                                zArr[2] = true;
                                iArr2[2] = jsonParser.E();
                            } else if (i.equals("initial_view_roll_degrees")) {
                                zArr[3] = true;
                                iArr2[3] = jsonParser.E();
                            } else if (i.equals("intermediate_image")) {
                                iArr[8] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("is_spherical")) {
                                zArr[4] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("message")) {
                                iArr[10] = MessageParser.m6471a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("name")) {
                                iArr[11] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("playable_duration_in_ms")) {
                                zArr[5] = true;
                                iArr2[4] = jsonParser.E();
                            } else if (i.equals("playable_url")) {
                                iArr[13] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("playable_url_hd")) {
                                iArr[14] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("playable_url_preferred")) {
                                iArr[15] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("playlist")) {
                                iArr[16] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("preview_payload")) {
                                iArr[17] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("profilePicture50")) {
                                iArr[18] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("projection_type")) {
                                iArr[19] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("sphericalFullscreenAspectRatio")) {
                                zArr[6] = true;
                                dArr[0] = jsonParser.G();
                            } else if (i.equals("sphericalInlineAspectRatio")) {
                                zArr[7] = true;
                                dArr[1] = jsonParser.G();
                            } else if (i.equals("sphericalPlayableUrlHdString")) {
                                iArr[22] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("sphericalPlayableUrlSdString")) {
                                iArr[23] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("sphericalPlaylist")) {
                                iArr[24] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("sphericalPreferredFov")) {
                                zArr[8] = true;
                                iArr2[5] = jsonParser.E();
                            } else if (i.equals("subscribe_status")) {
                                iArr[26] = flatBufferBuilder.a(GraphQLSubscribeStatus.fromString(jsonParser.o()));
                            } else if (i.equals("url")) {
                                iArr[27] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("video_preview_image")) {
                                iArr[28] = FBFullImageFragmentParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("width")) {
                                zArr[9] = true;
                                iArr2[6] = jsonParser.E();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(30);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(2, iArr2[0], 0);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    flatBufferBuilder.b(4, iArr[4]);
                    if (zArr[1]) {
                        flatBufferBuilder.a(5, iArr2[1], 0);
                    }
                    if (zArr[2]) {
                        flatBufferBuilder.a(6, iArr2[2], 0);
                    }
                    if (zArr[3]) {
                        flatBufferBuilder.a(7, iArr2[3], 0);
                    }
                    flatBufferBuilder.b(8, iArr[8]);
                    if (zArr[4]) {
                        flatBufferBuilder.a(9, zArr2[0]);
                    }
                    flatBufferBuilder.b(10, iArr[10]);
                    flatBufferBuilder.b(11, iArr[11]);
                    if (zArr[5]) {
                        flatBufferBuilder.a(12, iArr2[4], 0);
                    }
                    flatBufferBuilder.b(13, iArr[13]);
                    flatBufferBuilder.b(14, iArr[14]);
                    flatBufferBuilder.b(15, iArr[15]);
                    flatBufferBuilder.b(16, iArr[16]);
                    flatBufferBuilder.b(17, iArr[17]);
                    flatBufferBuilder.b(18, iArr[18]);
                    flatBufferBuilder.b(19, iArr[19]);
                    if (zArr[6]) {
                        flatBufferBuilder.a(20, dArr[0], 0.0d);
                    }
                    if (zArr[7]) {
                        flatBufferBuilder.a(21, dArr[1], 0.0d);
                    }
                    flatBufferBuilder.b(22, iArr[22]);
                    flatBufferBuilder.b(23, iArr[23]);
                    flatBufferBuilder.b(24, iArr[24]);
                    if (zArr[8]) {
                        flatBufferBuilder.a(25, iArr2[5], 0);
                    }
                    flatBufferBuilder.b(26, iArr[26]);
                    flatBufferBuilder.b(27, iArr[27]);
                    flatBufferBuilder.b(28, iArr[28]);
                    if (zArr[9]) {
                        flatBufferBuilder.a(29, iArr2[6], 0);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m6589a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("external_url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    int a = mutableFlatBuffer.a(i, 2, 0);
                    if (a != 0) {
                        jsonGenerator.a("height");
                        jsonGenerator.b(a);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    a = mutableFlatBuffer.g(i, 4);
                    if (a != 0) {
                        jsonGenerator.a("image");
                        FBFullImageFragmentParser.a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 5, 0);
                    if (a != 0) {
                        jsonGenerator.a("initial_view_heading_degrees");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 6, 0);
                    if (a != 0) {
                        jsonGenerator.a("initial_view_pitch_degrees");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 7, 0);
                    if (a != 0) {
                        jsonGenerator.a("initial_view_roll_degrees");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.g(i, 8);
                    if (a != 0) {
                        jsonGenerator.a("intermediate_image");
                        FBFullImageFragmentParser.a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    boolean a2 = mutableFlatBuffer.a(i, 9);
                    if (a2) {
                        jsonGenerator.a("is_spherical");
                        jsonGenerator.a(a2);
                    }
                    a = mutableFlatBuffer.g(i, 10);
                    if (a != 0) {
                        jsonGenerator.a("message");
                        MessageParser.m6472a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 11) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                    }
                    a = mutableFlatBuffer.a(i, 12, 0);
                    if (a != 0) {
                        jsonGenerator.a("playable_duration_in_ms");
                        jsonGenerator.b(a);
                    }
                    if (mutableFlatBuffer.g(i, 13) != 0) {
                        jsonGenerator.a("playable_url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 13));
                    }
                    if (mutableFlatBuffer.g(i, 14) != 0) {
                        jsonGenerator.a("playable_url_hd");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 14));
                    }
                    if (mutableFlatBuffer.g(i, 15) != 0) {
                        jsonGenerator.a("playable_url_preferred");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 15));
                    }
                    if (mutableFlatBuffer.g(i, 16) != 0) {
                        jsonGenerator.a("playlist");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 16));
                    }
                    if (mutableFlatBuffer.g(i, 17) != 0) {
                        jsonGenerator.a("preview_payload");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 17));
                    }
                    a = mutableFlatBuffer.g(i, 18);
                    if (a != 0) {
                        jsonGenerator.a("profilePicture50");
                        FBFullImageFragmentParser.a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 19) != 0) {
                        jsonGenerator.a("projection_type");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 19));
                    }
                    double a3 = mutableFlatBuffer.a(i, 20, 0.0d);
                    if (a3 != 0.0d) {
                        jsonGenerator.a("sphericalFullscreenAspectRatio");
                        jsonGenerator.a(a3);
                    }
                    a3 = mutableFlatBuffer.a(i, 21, 0.0d);
                    if (a3 != 0.0d) {
                        jsonGenerator.a("sphericalInlineAspectRatio");
                        jsonGenerator.a(a3);
                    }
                    if (mutableFlatBuffer.g(i, 22) != 0) {
                        jsonGenerator.a("sphericalPlayableUrlHdString");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 22));
                    }
                    if (mutableFlatBuffer.g(i, 23) != 0) {
                        jsonGenerator.a("sphericalPlayableUrlSdString");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 23));
                    }
                    if (mutableFlatBuffer.g(i, 24) != 0) {
                        jsonGenerator.a("sphericalPlaylist");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 24));
                    }
                    a = mutableFlatBuffer.a(i, 25, 0);
                    if (a != 0) {
                        jsonGenerator.a("sphericalPreferredFov");
                        jsonGenerator.b(a);
                    }
                    if (mutableFlatBuffer.g(i, 26) != 0) {
                        jsonGenerator.a("subscribe_status");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 26));
                    }
                    if (mutableFlatBuffer.g(i, 27) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 27));
                    }
                    a = mutableFlatBuffer.g(i, 28);
                    if (a != 0) {
                        jsonGenerator.a("video_preview_image");
                        FBFullImageFragmentParser.a(mutableFlatBuffer, a, jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 29, 0);
                    if (a != 0) {
                        jsonGenerator.a("width");
                        jsonGenerator.b(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m6591b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[4];
                boolean[] zArr = new boolean[2];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("entity")) {
                            iArr[0] = EntityParser.m6588a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("entity_type")) {
                            iArr[1] = flatBufferBuilder.a(GraphQLComposedEntityType.fromString(jsonParser.o()));
                        } else if (i.equals("length")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("offset")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                if (zArr[0]) {
                    flatBufferBuilder.a(2, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(3, iArr2[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m6590a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m6591b(jsonParser, flatBufferBuilder)));
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

            public static void m6592b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("entity");
                    EntityParser.m6589a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("entity_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                }
                g = mutableFlatBuffer.a(i, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("length");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.a(i, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("offset");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: photo_pandora */
        public final class InlineStyleRangesParser {
            public static int m6595b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[2];
                int[] iArr2 = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("inline_style")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLInlineStyle.fromString(jsonParser.o()));
                        } else if (i.equals("length")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
                        } else if (i.equals("offset")) {
                            zArr[1] = true;
                            iArr2[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, iArr2[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(2, iArr2[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m6593a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m6595b(jsonParser, flatBufferBuilder)));
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

            public static void m6594a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("inline_style");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                int a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("length");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("offset");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m6596a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[5];
            boolean[] zArr = new boolean[1];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("block_type")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLComposedBlockType.fromString(jsonParser.o()));
                    } else if (i.equals("depth")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("entity_ranges")) {
                        iArr[2] = EntityRangesParser.m6590a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("inline_style_ranges")) {
                        iArr[3] = InlineStyleRangesParser.m6593a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("text")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, iArr2[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            return flatBufferBuilder.d();
        }

        public static int m6597b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m6596a(jsonParser, flatBufferBuilder)));
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

        public static void m6598b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int i2;
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("block_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            int a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("depth");
                jsonGenerator.b(a);
            }
            a = mutableFlatBuffer.g(i, 2);
            if (a != 0) {
                jsonGenerator.a("entity_ranges");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                    EntityRangesParser.m6592b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            a = mutableFlatBuffer.g(i, 3);
            if (a != 0) {
                jsonGenerator.a("inline_style_ranges");
                jsonGenerator.d();
                for (i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                    InlineStyleRangesParser.m6594a(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("text");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: photo_pandora */
    public final class RichDocumentTrackerParser {
        public static MutableFlatBuffer m6599a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("base_url")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("html_source")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("webview_base_url")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
