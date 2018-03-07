package com.facebook.friendsharing.souvenirs.protocols;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLParsers.SizeAwareMediaParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: REDIRECT_INTENT */
public class FetchSouvenirsParsers {

    /* compiled from: REDIRECT_INTENT */
    public final class SouvenirsDetailsFieldsParser {

        /* compiled from: REDIRECT_INTENT */
        public final class ContainerPostParser {

            /* compiled from: REDIRECT_INTENT */
            public final class ActorsParser {

                /* compiled from: REDIRECT_INTENT */
                public final class ProfilePictureParser {
                    public static int m26395a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m26396a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m26397b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[3];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("__type__")) {
                                iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                            } else if (i.equals("name")) {
                                iArr[1] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("profile_picture")) {
                                iArr[2] = ProfilePictureParser.m26395a(jsonParser, flatBufferBuilder);
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

                public static void m26398b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("__type__");
                        SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 1) != 0) {
                        jsonGenerator.a("name");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                    }
                    int g = mutableFlatBuffer.g(i, 2);
                    if (g != 0) {
                        jsonGenerator.a("profile_picture");
                        ProfilePictureParser.m26396a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m26399a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("actors")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(ActorsParser.m26397b(jsonParser, flatBufferBuilder)));
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

            public static void m26400a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("actors");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ActorsParser.m26398b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: REDIRECT_INTENT */
        public final class MediaElementsParser {

            /* compiled from: REDIRECT_INTENT */
            public final class EdgesParser {
                public static int m26401b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = SouvenirsMediaElementFieldsParser.m26410a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m26402b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        SouvenirsMediaElementFieldsParser.m26411a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m26403a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m26401b(jsonParser, flatBufferBuilder)));
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

            public static void m26404a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m26402b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m26405a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[6];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("container_post")) {
                        iArr[0] = ContainerPostParser.m26399a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("formatting_string")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("media_elements")) {
                        iArr[3] = MediaElementsParser.m26403a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("souvenir_cover_photo")) {
                        iArr[4] = SizeAwareMediaParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("title")) {
                        iArr[5] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
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

    /* compiled from: REDIRECT_INTENT */
    public final class SouvenirsMediaElementFieldsParser {

        /* compiled from: REDIRECT_INTENT */
        public final class SouvenirMediaParser {

            /* compiled from: REDIRECT_INTENT */
            public final class EdgesParser {
                public static int m26406b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = SouvenirsMediaFieldsParser.m26420a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m26407b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        SouvenirsMediaFieldsParser.m26421a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m26408a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                    arrayList.add(Integer.valueOf(EdgesParser.m26406b(jsonParser, flatBufferBuilder)));
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

            public static void m26409a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m26407b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static int m26410a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[4];
            boolean[] zArr = new boolean[1];
            boolean[] zArr2 = new boolean[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("is_highlighted")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("souvenir_media")) {
                        iArr[2] = SouvenirMediaParser.m26408a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("souvenir_media_type")) {
                        iArr[3] = flatBufferBuilder.a(GraphQLSouvenirMediaFieldType.fromString(jsonParser.o()));
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            return flatBufferBuilder.d();
        }

        public static void m26411a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("is_highlighted");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("souvenir_media");
                SouvenirMediaParser.m26409a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 3) != 0) {
                jsonGenerator.a("souvenir_media_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 3));
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: REDIRECT_INTENT */
    public final class SouvenirsMediaFieldsParser {

        /* compiled from: REDIRECT_INTENT */
        public final class CreationStoryParser {

            /* compiled from: REDIRECT_INTENT */
            public final class FeedbackParser {

                /* compiled from: REDIRECT_INTENT */
                public final class CommentsParser {
                    public static int m26412a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m26413a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("count");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: REDIRECT_INTENT */
                public final class LikersParser {
                    public static int m26414a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m26415a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("count");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m26416a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[8];
                    boolean[] zArr = new boolean[4];
                    boolean[] zArr2 = new boolean[4];
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
                            } else if (i.equals("can_viewer_like")) {
                                zArr[2] = true;
                                zArr2[2] = jsonParser.H();
                            } else if (i.equals("comments")) {
                                iArr[3] = CommentsParser.m26412a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("does_viewer_like")) {
                                zArr[3] = true;
                                zArr2[3] = jsonParser.H();
                            } else if (i.equals("id")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("legacy_api_post_id")) {
                                iArr[6] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("likers")) {
                                iArr[7] = LikersParser.m26414a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(8);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(1, zArr2[1]);
                    }
                    if (zArr[2]) {
                        flatBufferBuilder.a(2, zArr2[2]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    if (zArr[3]) {
                        flatBufferBuilder.a(4, zArr2[3]);
                    }
                    flatBufferBuilder.b(5, iArr[5]);
                    flatBufferBuilder.b(6, iArr[6]);
                    flatBufferBuilder.b(7, iArr[7]);
                    return flatBufferBuilder.d();
                }

                public static void m26417a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        jsonGenerator.a("can_viewer_like");
                        jsonGenerator.a(a);
                    }
                    int g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("comments");
                        CommentsParser.m26413a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    a = mutableFlatBuffer.a(i, 4);
                    if (a) {
                        jsonGenerator.a("does_viewer_like");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    if (mutableFlatBuffer.g(i, 6) != 0) {
                        jsonGenerator.a("legacy_api_post_id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 6));
                    }
                    g = mutableFlatBuffer.g(i, 7);
                    if (g != 0) {
                        jsonGenerator.a("likers");
                        LikersParser.m26415a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m26418a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("feedback")) {
                            iArr[0] = FeedbackParser.m26416a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m26419a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m26417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m26420a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[15];
            boolean[] zArr = new boolean[6];
            boolean[] zArr2 = new boolean[3];
            int[] iArr2 = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_report")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("creation_story")) {
                        iArr[3] = CreationStoryParser.m26418a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("focus")) {
                        iArr[4] = DefaultVect2FieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("height")) {
                        zArr[2] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("id")) {
                        iArr[6] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[7] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHigh")) {
                        iArr[8] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLow")) {
                        iArr[9] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageMedium")) {
                        iArr[10] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("is_playable")) {
                        zArr[3] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[4] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[13] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("width")) {
                        zArr[5] = true;
                        iArr2[2] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(2, zArr2[1]);
            }
            flatBufferBuilder.b(3, iArr[3]);
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[2]) {
                flatBufferBuilder.a(5, iArr2[0], 0);
            }
            flatBufferBuilder.b(6, iArr[6]);
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            flatBufferBuilder.b(9, iArr[9]);
            flatBufferBuilder.b(10, iArr[10]);
            if (zArr[3]) {
                flatBufferBuilder.a(11, zArr2[2]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(12, iArr2[1], 0);
            }
            flatBufferBuilder.b(13, iArr[13]);
            if (zArr[5]) {
                flatBufferBuilder.a(14, iArr2[2], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m26421a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 2);
            if (a) {
                jsonGenerator.a("can_viewer_report");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                CreationStoryParser.m26419a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 5, 0);
            if (g != 0) {
                jsonGenerator.a("height");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 6));
            }
            g = mutableFlatBuffer.g(i, 7);
            if (g != 0) {
                jsonGenerator.a("image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("imageHigh");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 9);
            if (g != 0) {
                jsonGenerator.a("imageLow");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 10);
            if (g != 0) {
                jsonGenerator.a("imageMedium");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.a(i, 12, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 13) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 13));
            }
            g = mutableFlatBuffer.a(i, 14, 0);
            if (g != 0) {
                jsonGenerator.a("width");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }
}
