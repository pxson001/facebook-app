package com.facebook.photos.data.protocol;

import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.SimpleReactionsFeedbackFieldsParser.ReactorsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsFeedbackFieldsParser.SupportedReactionsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ImportantReactorsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsSocialFeedbackFieldsParser.ViewerActsAsPersonParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityPreviewTemplateFieldsParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.enums.GraphQLPlaceSuggestionType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLParsers.ImageOverlayFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: success_result */
public class PhotosMetadataGraphQLParsers {

    /* compiled from: success_result */
    public final class FaceBoxInfoParser {
        public static int m5404b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("facebox_center")) {
                        iArr[0] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("facebox_size")) {
                        iArr[1] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("tag_suggestions")) {
                        iArr[3] = FaceBoxSuggestionsQueryParser.m5408a(jsonParser, flatBufferBuilder);
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

        public static void m5405b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("facebox_center");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("facebox_size");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("tag_suggestions");
                FaceBoxSuggestionsQueryParser.m5409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class FaceBoxSuggestionsQueryParser {

        /* compiled from: success_result */
        public final class EdgesParser {
            public static int m5406b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cursor")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("node")) {
                            iArr[1] = FaceBoxUserParser.m5410a(jsonParser, flatBufferBuilder);
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

            public static void m5407b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("cursor");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("node");
                    FaceBoxUserParser.m5411a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m5408a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                arrayList.add(Integer.valueOf(EdgesParser.m5406b(jsonParser, flatBufferBuilder)));
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

        public static void m5409a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    EdgesParser.m5407b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class FaceBoxUserParser {
        public static int m5410a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
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

        public static void m5411a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class InlineActivityInfoParser {

        /* compiled from: success_result */
        public final class TaggableActivityIconParser {

            /* compiled from: success_result */
            public final class ImageParser {
                public static int m5412a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m5413a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m5414a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("image")) {
                            iArr[0] = ImageParser.m5412a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m5415a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("image");
                    ImageParser.m5413a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m5416b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("object")) {
                        iArr[1] = InlineActivityObjectParser.m5418a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("taggable_activity")) {
                        iArr[2] = MinutiaeTaggableActivityPreviewTemplateFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("taggable_activity_icon")) {
                        iArr[3] = TaggableActivityIconParser.m5414a(jsonParser, flatBufferBuilder);
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

        public static void m5417b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("object");
                InlineActivityObjectParser.m5419a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("taggable_activity");
                MinutiaeTaggableActivityPreviewTemplateFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("taggable_activity_icon");
                TaggableActivityIconParser.m5415a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class InlineActivityObjectParser {
        public static int m5418a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
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

        public static void m5419a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class LocationSuggestionParser {

        /* compiled from: success_result */
        public final class LocationTagSuggestionParser {
            public static int m5420a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("place")) {
                            iArr[0] = PlaceInfoParser.m5484a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("session_id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("suggestion_type")) {
                            iArr[2] = flatBufferBuilder.a(GraphQLPlaceSuggestionType.fromString(jsonParser.o()));
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

            public static void m5421a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("place");
                    PlaceInfoParser.m5485a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("session_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("suggestion_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m5422a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("location_tag_suggestion")) {
                        iArr[0] = LocationTagSuggestionParser.m5420a(jsonParser, flatBufferBuilder);
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

    /* compiled from: success_result */
    public final class MediaMetadataAttributionAppParser {

        /* compiled from: success_result */
        public final class NativeStoreObjectParser {
            public static int m5423a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("native_store_id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("native_store_url")) {
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

            public static void m5424a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("native_store_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("native_store_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class SquareLogoParser {
            public static int m5425a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m5426a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m5427a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("native_store_object")) {
                        iArr[2] = NativeStoreObjectParser.m5423a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("square_logo")) {
                        iArr[3] = SquareLogoParser.m5425a(jsonParser, flatBufferBuilder);
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

        public static void m5428a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("native_store_object");
                NativeStoreObjectParser.m5424a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("square_logo");
                SquareLogoParser.m5426a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class MediaMetadataCreationStoryParser {

        /* compiled from: success_result */
        public final class ApplicationParser {
            public static int m5429a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
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

            public static void m5430a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class AttachmentsParser {

            /* compiled from: success_result */
            public final class ActionLinksParser {
                public static int m5432b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    boolean[] zArr = new boolean[1];
                    long[] jArr = new long[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("action_link_type")) {
                                iArr[1] = flatBufferBuilder.a(GraphQLProfilePictureActionLinkType.fromString(jsonParser.o()));
                            } else if (i.equals("default_expiration_time")) {
                                zArr[0] = true;
                                jArr[0] = jsonParser.F();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, iArr[0]);
                    flatBufferBuilder.b(1, iArr[1]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(2, jArr[0], 0);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m5431a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("action_link_type");
                        jsonGenerator.b(mutableFlatBuffer.b(i, 1));
                    }
                    long a = mutableFlatBuffer.a(i, 2, 0);
                    if (a != 0) {
                        jsonGenerator.a("default_expiration_time");
                        jsonGenerator.a(a);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m5433b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("action_links")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(ActionLinksParser.m5432b(jsonParser, flatBufferBuilder)));
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

            public static void m5434b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("action_links");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ActionLinksParser.m5431a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class SponsoredDataParser {

            /* compiled from: success_result */
            public final class UserParser {
                public static int m5435a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
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

                public static void m5436a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m5437a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("user")) {
                            iArr[0] = UserParser.m5435a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m5438a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m5436a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m5439a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("application")) {
                        iArr[0] = ApplicationParser.m5429a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attachments")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(AttachmentsParser.m5433b(jsonParser, flatBufferBuilder)));
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
                    } else if (i.equals("cache_id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("legacy_api_story_id")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sponsored_data")) {
                        iArr[5] = SponsoredDataParser.m5437a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tracking")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
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
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m5440a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("application");
                ApplicationParser.m5430a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("attachments");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    AttachmentsParser.m5434b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("cache_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("legacy_api_story_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("sponsored_data");
                SponsoredDataParser.m5438a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("tracking");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class MediaMetadataInlineActivitiesParser {
        public static int m5441a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                arrayList.add(Integer.valueOf(InlineActivityInfoParser.m5416b(jsonParser, flatBufferBuilder)));
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

        public static void m5442a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nodes");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    InlineActivityInfoParser.m5417b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class MediaMetadataOwnerParser {
        public static int m5443a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
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

        public static void m5444a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class MediaMetadataParser {
        public static int m5445a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[46];
            boolean[] zArr = new boolean[16];
            boolean[] zArr2 = new boolean[14];
            int[] iArr2 = new int[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("accessibility_caption")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("album")) {
                        iArr[2] = AlbumParser.m5449a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app")) {
                        iArr[3] = MediaMetadataAttributionAppParser.m5427a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app_metadata")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("can_viewer_add_tags")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("can_viewer_edit")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("can_viewer_export")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("can_viewer_make_cover_photo")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("can_viewer_make_profile_picture")) {
                        zArr[5] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("can_viewer_report")) {
                        zArr[6] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("can_viewer_share")) {
                        zArr[7] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("can_viewer_suggest_location")) {
                        zArr[8] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("can_viewer_untag")) {
                        zArr[9] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("container_story")) {
                        iArr[15] = MediaPrivacyContainerStoryParser.m5470a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("created_time")) {
                        zArr[10] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_story")) {
                        iArr[17] = MediaMetadataCreationStoryParser.m5439a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explicit_place")) {
                        iArr[18] = ExplicitPlaceParser.m5451a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("face_boxes")) {
                        iArr[19] = PhotosFaceBoxesQueryParser.m5480a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[20] = SimpleMediaFeedbackParser.m5490a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("focus")) {
                        iArr[21] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("has_stickers")) {
                        zArr[11] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("hd_playable_url")) {
                        iArr[23] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[24] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[25] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHigh")) {
                        iArr[26] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHighOrig")) {
                        iArr[27] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLow")) {
                        iArr[28] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageMedium")) {
                        iArr[29] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageThumbnail")) {
                        iArr[30] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("inline_activities")) {
                        iArr[31] = MediaMetadataInlineActivitiesParser.m5441a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_delegating_delete")) {
                        zArr[12] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("is_playable")) {
                        zArr[13] = true;
                        zArr2[12] = jsonParser.H();
                    } else if (i.equals("largeThumbnail")) {
                        iArr[34] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("location_tag_suggestion")) {
                        iArr[35] = LocationTagSuggestionParser.m5420a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[36] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("owner")) {
                        iArr[37] = MediaMetadataOwnerParser.m5443a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pending_place")) {
                        iArr[38] = PendingPlaceParser.m5453a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[14] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[40] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_scope")) {
                        iArr[41] = PrivacyScopeParser.m5463a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("profile_picture_overlay")) {
                        iArr[42] = ImageOverlayFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("show_objectionable_warning_in_feed")) {
                        zArr[15] = true;
                        zArr2[13] = jsonParser.H();
                    } else if (i.equals("tags")) {
                        iArr[44] = TagInfoQueryParser.m5500a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("with_tags")) {
                        iArr[45] = WithTagsParser.m5457a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(46);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[0]) {
                flatBufferBuilder.a(5, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(6, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(7, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(8, zArr2[3]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(9, zArr2[4]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(10, zArr2[5]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(11, zArr2[6]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(12, zArr2[7]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(13, zArr2[8]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(14, zArr2[9]);
            }
            flatBufferBuilder.b(15, iArr[15]);
            if (zArr[10]) {
                flatBufferBuilder.a(16, jArr[0], 0);
            }
            flatBufferBuilder.b(17, iArr[17]);
            flatBufferBuilder.b(18, iArr[18]);
            flatBufferBuilder.b(19, iArr[19]);
            flatBufferBuilder.b(20, iArr[20]);
            flatBufferBuilder.b(21, iArr[21]);
            if (zArr[11]) {
                flatBufferBuilder.a(22, zArr2[10]);
            }
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            flatBufferBuilder.b(31, iArr[31]);
            if (zArr[12]) {
                flatBufferBuilder.a(32, zArr2[11]);
            }
            if (zArr[13]) {
                flatBufferBuilder.a(33, zArr2[12]);
            }
            flatBufferBuilder.b(34, iArr[34]);
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            flatBufferBuilder.b(38, iArr[38]);
            if (zArr[14]) {
                flatBufferBuilder.a(39, iArr2[0], 0);
            }
            flatBufferBuilder.b(40, iArr[40]);
            flatBufferBuilder.b(41, iArr[41]);
            flatBufferBuilder.b(42, iArr[42]);
            if (zArr[15]) {
                flatBufferBuilder.a(43, zArr2[13]);
            }
            flatBufferBuilder.b(44, iArr[44]);
            flatBufferBuilder.b(45, iArr[45]);
            return flatBufferBuilder.d();
        }

        public static int m5447b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m5445a(jsonParser, flatBufferBuilder)));
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

        public static void m5446a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m5448b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m5448b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("accessibility_caption");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m5450a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("attribution_app");
                MediaMetadataAttributionAppParser.m5428a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("attribution_app_metadata");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            boolean a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("can_viewer_add_tags");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("can_viewer_edit");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("can_viewer_export");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("can_viewer_make_cover_photo");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("can_viewer_make_profile_picture");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("can_viewer_report");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("can_viewer_share");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 13);
            if (a) {
                jsonGenerator.a("can_viewer_suggest_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 14);
            if (a) {
                jsonGenerator.a("can_viewer_untag");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("container_story");
                MediaPrivacyContainerStoryParser.m5471a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            long a2 = mutableFlatBuffer.a(i, 16, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                MediaMetadataCreationStoryParser.m5440a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("explicit_place");
                ExplicitPlaceParser.m5452a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("face_boxes");
                PhotosFaceBoxesQueryParser.m5481a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 20);
            if (g != 0) {
                jsonGenerator.a("feedback");
                SimpleMediaFeedbackParser.m5491a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 21);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 22);
            if (a) {
                jsonGenerator.a("has_stickers");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 23) != 0) {
                jsonGenerator.a("hd_playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 23));
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 24));
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("imageHigh");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("imageHighOrig");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("imageLow");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("imageMedium");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("imageThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 31);
            if (g != 0) {
                jsonGenerator.a("inline_activities");
                MediaMetadataInlineActivitiesParser.m5442a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 32);
            if (a) {
                jsonGenerator.a("is_delegating_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 33);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 34);
            if (g != 0) {
                jsonGenerator.a("largeThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 35);
            if (g != 0) {
                jsonGenerator.a("location_tag_suggestion");
                LocationTagSuggestionParser.m5421a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("owner");
                MediaMetadataOwnerParser.m5444a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 38);
            if (g != 0) {
                jsonGenerator.a("pending_place");
                PendingPlaceParser.m5454a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 39, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 40) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 40));
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("privacy_scope");
                PrivacyScopeParser.m5464a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("profile_picture_overlay");
                ImageOverlayFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 43);
            if (a) {
                jsonGenerator.a("show_objectionable_warning_in_feed");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("tags");
                TagInfoQueryParser.m5501a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 45);
            if (g != 0) {
                jsonGenerator.a("with_tags");
                WithTagsParser.m5458a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class MediaMetadataWithoutFeedbackParser {

        /* compiled from: success_result */
        public final class AlbumParser {
            public static int m5449a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("album_type")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLPhotosAlbumAPIType.fromString(jsonParser.o()));
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

            public static void m5450a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("album_type");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class ExplicitPlaceParser {
            public static int m5451a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
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

            public static void m5452a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class PendingPlaceParser {
            public static int m5453a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
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

            public static void m5454a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class WithTagsParser {

            /* compiled from: success_result */
            public final class NodesParser {
                public static int m5456b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
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

                public static void m5455a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                    jsonGenerator.g();
                }
            }

            public static int m5457a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(NodesParser.m5456b(jsonParser, flatBufferBuilder)));
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

            public static void m5458a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        NodesParser.m5455a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m5459a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[38];
            boolean[] zArr = new boolean[14];
            boolean[] zArr2 = new boolean[12];
            int[] iArr2 = new int[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("album")) {
                        iArr[1] = AlbumParser.m5449a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app")) {
                        iArr[2] = MediaMetadataAttributionAppParser.m5427a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app_metadata")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("can_viewer_add_tags")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("can_viewer_edit")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("can_viewer_export")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("can_viewer_make_cover_photo")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("can_viewer_make_profile_picture")) {
                        zArr[5] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("can_viewer_report")) {
                        zArr[6] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("can_viewer_share")) {
                        zArr[7] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("can_viewer_suggest_location")) {
                        zArr[8] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("can_viewer_untag")) {
                        zArr[9] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("created_time")) {
                        zArr[10] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_story")) {
                        iArr[15] = MediaMetadataCreationStoryParser.m5439a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("explicit_place")) {
                        iArr[16] = ExplicitPlaceParser.m5451a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("face_boxes")) {
                        iArr[17] = PhotosFaceBoxesQueryParser.m5480a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("focus")) {
                        iArr[18] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("has_stickers")) {
                        zArr[11] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("hd_playable_url")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[22] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHigh")) {
                        iArr[23] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLow")) {
                        iArr[24] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageMedium")) {
                        iArr[25] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageThumbnail")) {
                        iArr[26] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("inline_activities")) {
                        iArr[27] = MediaMetadataInlineActivitiesParser.m5441a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_playable")) {
                        zArr[12] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("largeThumbnail")) {
                        iArr[29] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("message")) {
                        iArr[30] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("owner")) {
                        iArr[31] = MediaMetadataOwnerParser.m5443a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("pending_place")) {
                        iArr[32] = PendingPlaceParser.m5453a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[13] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[34] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("profile_picture_overlay")) {
                        iArr[35] = ImageOverlayFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tags")) {
                        iArr[36] = TagInfoQueryParser.m5500a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("with_tags")) {
                        iArr[37] = WithTagsParser.m5457a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(38);
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
            if (zArr[2]) {
                flatBufferBuilder.a(6, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(7, zArr2[3]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(8, zArr2[4]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(9, zArr2[5]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(10, zArr2[6]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(11, zArr2[7]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(12, zArr2[8]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(13, zArr2[9]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(14, jArr[0], 0);
            }
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            flatBufferBuilder.b(17, iArr[17]);
            flatBufferBuilder.b(18, iArr[18]);
            if (zArr[11]) {
                flatBufferBuilder.a(19, zArr2[10]);
            }
            flatBufferBuilder.b(20, iArr[20]);
            flatBufferBuilder.b(21, iArr[21]);
            flatBufferBuilder.b(22, iArr[22]);
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            if (zArr[12]) {
                flatBufferBuilder.a(28, zArr2[11]);
            }
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            flatBufferBuilder.b(31, iArr[31]);
            flatBufferBuilder.b(32, iArr[32]);
            if (zArr[13]) {
                flatBufferBuilder.a(33, iArr2[0], 0);
            }
            flatBufferBuilder.b(34, iArr[34]);
            flatBufferBuilder.b(35, iArr[35]);
            flatBufferBuilder.b(36, iArr[36]);
            flatBufferBuilder.b(37, iArr[37]);
            return flatBufferBuilder.d();
        }

        public static void m5460a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("album");
                AlbumParser.m5450a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("attribution_app");
                MediaMetadataAttributionAppParser.m5428a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("attribution_app_metadata");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            boolean a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("can_viewer_add_tags");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("can_viewer_edit");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("can_viewer_export");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("can_viewer_make_cover_photo");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("can_viewer_make_profile_picture");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("can_viewer_report");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("can_viewer_share");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("can_viewer_suggest_location");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 13);
            if (a) {
                jsonGenerator.a("can_viewer_untag");
                jsonGenerator.a(a);
            }
            long a2 = mutableFlatBuffer.a(i, 14, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                MediaMetadataCreationStoryParser.m5440a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("explicit_place");
                ExplicitPlaceParser.m5452a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("face_boxes");
                PhotosFaceBoxesQueryParser.m5481a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 19);
            if (a) {
                jsonGenerator.a("has_stickers");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("hd_playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
            }
            g = mutableFlatBuffer.g(i, 22);
            if (g != 0) {
                jsonGenerator.a("image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 23);
            if (g != 0) {
                jsonGenerator.a("imageHigh");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 24);
            if (g != 0) {
                jsonGenerator.a("imageLow");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("imageMedium");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("imageThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("inline_activities");
                MediaMetadataInlineActivitiesParser.m5442a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 28);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("largeThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 30);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 31);
            if (g != 0) {
                jsonGenerator.a("owner");
                MediaMetadataOwnerParser.m5444a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 32);
            if (g != 0) {
                jsonGenerator.a("pending_place");
                PendingPlaceParser.m5454a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 33, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 34) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 34));
            }
            g = mutableFlatBuffer.g(i, 35);
            if (g != 0) {
                jsonGenerator.a("profile_picture_overlay");
                ImageOverlayFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 36);
            if (g != 0) {
                jsonGenerator.a("tags");
                TagInfoQueryParser.m5501a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 37);
            if (g != 0) {
                jsonGenerator.a("with_tags");
                WithTagsParser.m5458a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class MediaPrivacyAndContainerStoryParser {

        /* compiled from: success_result */
        public final class PrivacyScopeParser {

            /* compiled from: success_result */
            public final class IconImageParser {
                public static int m5461a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m5462a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m5463a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_edit")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("icon_image")) {
                            iArr[1] = IconImageParser.m5461a(jsonParser, flatBufferBuilder);
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

            public static void m5464a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_edit");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    IconImageParser.m5462a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m5465a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("container_story")) {
                        iArr[0] = MediaPrivacyContainerStoryParser.m5470a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("privacy_scope")) {
                        iArr[1] = PrivacyScopeParser.m5463a(jsonParser, flatBufferBuilder);
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

    /* compiled from: success_result */
    public final class MediaPrivacyContainerStoryParser {

        /* compiled from: success_result */
        public final class PrivacyScopeParser {

            /* compiled from: success_result */
            public final class IconImageParser {
                public static int m5466a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m5467a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m5468a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("can_viewer_edit")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("icon_image")) {
                            iArr[1] = IconImageParser.m5466a(jsonParser, flatBufferBuilder);
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

            public static void m5469a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(i, 0);
                if (a) {
                    jsonGenerator.a("can_viewer_edit");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    IconImageParser.m5467a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m5470a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("cache_id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("legacy_api_story_id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("privacy_scope")) {
                        iArr[3] = PrivacyScopeParser.m5468a(jsonParser, flatBufferBuilder);
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

        public static void m5471a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("cache_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("legacy_api_story_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            int g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("privacy_scope");
                PrivacyScopeParser.m5469a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class PageMediaWithAttributionParser {

        /* compiled from: success_result */
        public final class OwnerParser {
            public static int m5472a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("name")) {
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

            public static void m5473a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class PrivacyScopeParser {

            /* compiled from: success_result */
            public final class IconImageParser {
                public static int m5474a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m5475a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("uri");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m5476a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("icon_image")) {
                            iArr[0] = IconImageParser.m5474a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m5477a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("icon_image");
                    IconImageParser.m5475a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m5478a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[10];
            boolean[] zArr = new boolean[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("created_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("focus")) {
                        iArr[2] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[3] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[4] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHigh")) {
                        iArr[5] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLow")) {
                        iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageMedium")) {
                        iArr[7] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("owner")) {
                        iArr[8] = OwnerParser.m5472a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("privacy_scope")) {
                        iArr[9] = PrivacyScopeParser.m5476a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, jArr[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            return flatBufferBuilder.d();
        }

        public static void m5479a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            long a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 3));
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("imageHigh");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("imageLow");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("imageMedium");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("owner");
                OwnerParser.m5473a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("privacy_scope");
                PrivacyScopeParser.m5477a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class PhotosFaceBoxesQueryParser {
        public static int m5480a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                arrayList.add(Integer.valueOf(FaceBoxInfoParser.m5404b(jsonParser, flatBufferBuilder)));
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

        public static void m5481a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("nodes");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    FaceBoxInfoParser.m5405b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class PlaceInfoParser {

        /* compiled from: success_result */
        public final class PlaceProfilePictureParser {
            public static int m5482a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m5483a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m5484a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                    } else if (i.equals("placeProfilePicture")) {
                        iArr[3] = PlaceProfilePictureParser.m5482a(jsonParser, flatBufferBuilder);
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

        public static void m5485a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                jsonGenerator.a("placeProfilePicture");
                PlaceProfilePictureParser.m5483a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class SimpleMediaFeedbackParser {

        /* compiled from: success_result */
        public final class LikersParser {
            public static int m5486a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m5487a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: success_result */
        public final class TopLevelCommentsParser {
            public static int m5488a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                boolean[] zArr = new boolean[2];
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("count")) {
                            zArr[0] = true;
                            iArr[0] = jsonParser.E();
                        } else if (i.equals("total_count")) {
                            zArr[1] = true;
                            iArr[1] = jsonParser.E();
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                if (zArr[0]) {
                    flatBufferBuilder.a(0, iArr[0], 0);
                }
                if (zArr[1]) {
                    flatBufferBuilder.a(1, iArr[1], 0);
                }
                return flatBufferBuilder.d();
            }

            public static void m5489a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(i, 1, 0);
                if (a != 0) {
                    jsonGenerator.a("total_count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        public static int m5490a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[21];
            boolean[] zArr = new boolean[11];
            boolean[] zArr2 = new boolean[10];
            int[] iArr2 = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_see_voice_switcher")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_comment")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("can_viewer_comment_with_photo")) {
                        zArr[2] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("can_viewer_comment_with_video")) {
                        zArr[3] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("can_viewer_like")) {
                        zArr[4] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("can_viewer_react")) {
                        zArr[5] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("can_viewer_subscribe")) {
                        zArr[6] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("display_reactions")) {
                        zArr[7] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("does_viewer_like")) {
                        zArr[8] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("id")) {
                        iArr[9] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("important_reactors")) {
                        iArr[10] = ImportantReactorsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_viewer_subscribed")) {
                        zArr[9] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("legacy_api_post_id")) {
                        iArr[12] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("likers")) {
                        iArr[13] = LikersParser.m5486a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("reactors")) {
                        iArr[14] = ReactorsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("remixable_photo_uri")) {
                        iArr[15] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("supported_reactions")) {
                        iArr[16] = SupportedReactionsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("top_level_comments")) {
                        iArr[17] = TopLevelCommentsParser.m5488a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("top_reactions")) {
                        iArr[18] = TopReactionsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_acts_as_person")) {
                        iArr[19] = ViewerActsAsPersonParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("viewer_feedback_reaction_key")) {
                        zArr[10] = true;
                        iArr2[0] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(21);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, zArr2[2]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(3, zArr2[3]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(4, zArr2[4]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(5, zArr2[5]);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(6, zArr2[6]);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(7, zArr2[7]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(8, zArr2[8]);
            }
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            if (zArr[9]) {
                flatBufferBuilder.a(11, zArr2[9]);
            }
            flatBufferBuilder.b(12, iArr[12]);
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            flatBufferBuilder.b(17, iArr[17]);
            flatBufferBuilder.b(18, iArr[18]);
            flatBufferBuilder.b(19, iArr[19]);
            if (zArr[10]) {
                flatBufferBuilder.a(20, iArr2[0], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m5491a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_see_voice_switcher");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_comment");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("can_viewer_comment_with_photo");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("can_viewer_comment_with_video");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 4);
            if (a) {
                jsonGenerator.a("can_viewer_like");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("can_viewer_react");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 6);
            if (a) {
                jsonGenerator.a("can_viewer_subscribe");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("display_reactions");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("does_viewer_like");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 9) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 9));
            }
            int g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("important_reactors");
                ImportantReactorsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("is_viewer_subscribed");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 12) != 0) {
                jsonGenerator.a("legacy_api_post_id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 12));
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("likers");
                LikersParser.m5487a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("reactors");
                ReactorsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 15) != 0) {
                jsonGenerator.a("remixable_photo_uri");
                jsonGenerator.b(mutableFlatBuffer.c(i, 15));
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("supported_reactions");
                SupportedReactionsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 17);
            if (g != 0) {
                jsonGenerator.a("top_level_comments");
                TopLevelCommentsParser.m5489a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("top_reactions");
                TopReactionsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("viewer_acts_as_person");
                ViewerActsAsPersonParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 20, 0);
            if (g != 0) {
                jsonGenerator.a("viewer_feedback_reaction_key");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class TagInfoParser {

        /* compiled from: success_result */
        public final class TaggerParser {
            public static int m5492a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("name")) {
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

            public static void m5493a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m5494a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[1];
            long[] jArr = new long[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_remove_tag")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("location")) {
                        iArr[1] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("tagger")) {
                        iArr[2] = TaggerParser.m5492a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("time")) {
                        zArr[1] = true;
                        jArr[0] = jsonParser.F();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[1]) {
                flatBufferBuilder.a(3, jArr[0], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m5495a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_viewer_remove_tag");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("location");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("tagger");
                TaggerParser.m5493a(mutableFlatBuffer, g, jsonGenerator);
            }
            long a2 = mutableFlatBuffer.a(i, 3, 0);
            if (a2 != 0) {
                jsonGenerator.a("time");
                jsonGenerator.a(a2);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: success_result */
    public final class TagInfoQueryParser {

        /* compiled from: success_result */
        public final class EdgesParser {

            /* compiled from: success_result */
            public final class NodeParser {
                public static int m5496a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
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

                public static void m5497a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                    jsonGenerator.g();
                }
            }

            public static int m5498b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cursor")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("node")) {
                            iArr[1] = NodeParser.m5496a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tag")) {
                            iArr[2] = TagInfoParser.m5494a(jsonParser, flatBufferBuilder);
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

            public static void m5499b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("cursor");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("node");
                    NodeParser.m5497a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("tag");
                    TagInfoParser.m5495a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m5500a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                arrayList.add(Integer.valueOf(EdgesParser.m5498b(jsonParser, flatBufferBuilder)));
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

        public static void m5501a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("edges");
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                    EdgesParser.m5499b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }
            jsonGenerator.g();
        }
    }
}
