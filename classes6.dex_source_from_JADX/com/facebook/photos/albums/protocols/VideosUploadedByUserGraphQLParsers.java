package com.facebook.photos.albums.protocols;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: interrupted_count */
public class VideosUploadedByUserGraphQLParsers {

    /* compiled from: interrupted_count */
    public final class VideoDetailFragmentParser {

        /* compiled from: interrupted_count */
        public final class CreationStoryParser {

            /* compiled from: interrupted_count */
            public final class ActorsParser {
                public static int m19777b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m19776a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            /* compiled from: interrupted_count */
            public final class AttachmentsParser {

                /* compiled from: interrupted_count */
                public final class MediaParser {

                    /* compiled from: interrupted_count */
                    public final class MediaCreationStoryParser {

                        /* compiled from: interrupted_count */
                        public final class ActorsParser {
                            public static int m19779b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                            public static void m19778a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                        public static int m19780a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("actors")) {
                                        int i2 = 0;
                                        ArrayList arrayList = new ArrayList();
                                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                                arrayList.add(Integer.valueOf(ActorsParser.m19779b(jsonParser, flatBufferBuilder)));
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

                        public static void m19781a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            jsonGenerator.f();
                            int g = mutableFlatBuffer.g(i, 0);
                            if (g != 0) {
                                jsonGenerator.a("actors");
                                jsonGenerator.d();
                                for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                                    ActorsParser.m19778a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                                }
                                jsonGenerator.e();
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m19782a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[15];
                        boolean[] zArr = new boolean[8];
                        boolean[] zArr2 = new boolean[3];
                        int[] iArr2 = new int[5];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("bitrate")) {
                                    zArr[0] = true;
                                    iArr2[0] = jsonParser.E();
                                } else if (i.equals("creation_story")) {
                                    iArr[2] = MediaCreationStoryParser.m19780a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("hdBitrate")) {
                                    zArr[1] = true;
                                    iArr2[1] = jsonParser.E();
                                } else if (i.equals("height")) {
                                    zArr[2] = true;
                                    iArr2[2] = jsonParser.E();
                                } else if (i.equals("id")) {
                                    iArr[5] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("image")) {
                                    iArr[6] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                                } else if (i.equals("is_playable")) {
                                    zArr[3] = true;
                                    zArr2[0] = jsonParser.H();
                                } else if (i.equals("is_video_broadcast")) {
                                    zArr[4] = true;
                                    zArr2[1] = jsonParser.H();
                                } else if (i.equals("playableUrlHdString")) {
                                    iArr[9] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("playable_duration_in_ms")) {
                                    zArr[5] = true;
                                    iArr2[3] = jsonParser.E();
                                } else if (i.equals("playable_url")) {
                                    iArr[11] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("preferredPlayableUrlString")) {
                                    iArr[12] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("supports_time_slices")) {
                                    zArr[6] = true;
                                    zArr2[2] = jsonParser.H();
                                } else if (i.equals("width")) {
                                    zArr[7] = true;
                                    iArr2[4] = jsonParser.E();
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(15);
                        flatBufferBuilder.b(0, iArr[0]);
                        if (zArr[0]) {
                            flatBufferBuilder.a(1, iArr2[0], 0);
                        }
                        flatBufferBuilder.b(2, iArr[2]);
                        if (zArr[1]) {
                            flatBufferBuilder.a(3, iArr2[1], 0);
                        }
                        if (zArr[2]) {
                            flatBufferBuilder.a(4, iArr2[2], 0);
                        }
                        flatBufferBuilder.b(5, iArr[5]);
                        flatBufferBuilder.b(6, iArr[6]);
                        if (zArr[3]) {
                            flatBufferBuilder.a(7, zArr2[0]);
                        }
                        if (zArr[4]) {
                            flatBufferBuilder.a(8, zArr2[1]);
                        }
                        flatBufferBuilder.b(9, iArr[9]);
                        if (zArr[5]) {
                            flatBufferBuilder.a(10, iArr2[3], 0);
                        }
                        flatBufferBuilder.b(11, iArr[11]);
                        flatBufferBuilder.b(12, iArr[12]);
                        if (zArr[6]) {
                            flatBufferBuilder.a(13, zArr2[2]);
                        }
                        if (zArr[7]) {
                            flatBufferBuilder.a(14, iArr2[4], 0);
                        }
                        return flatBufferBuilder.d();
                    }

                    public static void m19783a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        int a = mutableFlatBuffer.a(i, 1, 0);
                        if (a != 0) {
                            jsonGenerator.a("bitrate");
                            jsonGenerator.b(a);
                        }
                        a = mutableFlatBuffer.g(i, 2);
                        if (a != 0) {
                            jsonGenerator.a("creation_story");
                            MediaCreationStoryParser.m19781a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                        }
                        a = mutableFlatBuffer.a(i, 3, 0);
                        if (a != 0) {
                            jsonGenerator.a("hdBitrate");
                            jsonGenerator.b(a);
                        }
                        a = mutableFlatBuffer.a(i, 4, 0);
                        if (a != 0) {
                            jsonGenerator.a("height");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 5) != 0) {
                            jsonGenerator.a("id");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                        }
                        a = mutableFlatBuffer.g(i, 6);
                        if (a != 0) {
                            jsonGenerator.a("image");
                            DefaultImageFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
                        }
                        boolean a2 = mutableFlatBuffer.a(i, 7);
                        if (a2) {
                            jsonGenerator.a("is_playable");
                            jsonGenerator.a(a2);
                        }
                        a2 = mutableFlatBuffer.a(i, 8);
                        if (a2) {
                            jsonGenerator.a("is_video_broadcast");
                            jsonGenerator.a(a2);
                        }
                        if (mutableFlatBuffer.g(i, 9) != 0) {
                            jsonGenerator.a("playableUrlHdString");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 9));
                        }
                        a = mutableFlatBuffer.a(i, 10, 0);
                        if (a != 0) {
                            jsonGenerator.a("playable_duration_in_ms");
                            jsonGenerator.b(a);
                        }
                        if (mutableFlatBuffer.g(i, 11) != 0) {
                            jsonGenerator.a("playable_url");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 11));
                        }
                        if (mutableFlatBuffer.g(i, 12) != 0) {
                            jsonGenerator.a("preferredPlayableUrlString");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 12));
                        }
                        a2 = mutableFlatBuffer.a(i, 13);
                        if (a2) {
                            jsonGenerator.a("supports_time_slices");
                            jsonGenerator.a(a2);
                        }
                        a = mutableFlatBuffer.a(i, 14, 0);
                        if (a != 0) {
                            jsonGenerator.a("width");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: interrupted_count */
                public final class TargetParser {

                    /* compiled from: interrupted_count */
                    public final class ApplicationParser {
                        public static int m19784a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                            int[] iArr = new int[2];
                            while (jsonParser.c() != JsonToken.END_OBJECT) {
                                String i = jsonParser.i();
                                jsonParser.c();
                                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                    if (i.equals("id")) {
                                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
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

                        public static void m19785a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                            jsonGenerator.f();
                            if (mutableFlatBuffer.g(i, 0) != 0) {
                                jsonGenerator.a("id");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                            }
                            if (mutableFlatBuffer.g(i, 1) != 0) {
                                jsonGenerator.a("name");
                                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                            }
                            jsonGenerator.g();
                        }
                    }

                    public static int m19786a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("application")) {
                                    iArr[1] = ApplicationParser.m19784a(jsonParser, flatBufferBuilder);
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

                    public static void m19787a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("application");
                            ApplicationParser.m19785a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m19789b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[6];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("media")) {
                                iArr[0] = MediaParser.m19782a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("source")) {
                                iArr[1] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("style_list")) {
                                iArr[2] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("target")) {
                                iArr[3] = TargetParser.m19786a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("title")) {
                                iArr[4] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("url")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
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

                public static int m19788a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m19789b(jsonParser, flatBufferBuilder)));
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

                public static void m19790b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("media");
                        MediaParser.m19783a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("source");
                        DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("style_list");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 2), jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("target");
                        TargetParser.m19787a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    if (mutableFlatBuffer.g(i, 4) != 0) {
                        jsonGenerator.a("title");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                    }
                    if (mutableFlatBuffer.g(i, 5) != 0) {
                        jsonGenerator.a("url");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: interrupted_count */
            public final class FeedbackParser {

                /* compiled from: interrupted_count */
                public final class CommentsParser {
                    public static int m19791a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m19792a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("count");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: interrupted_count */
                public final class LikersParser {
                    public static int m19793a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m19794a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        int a = mutableFlatBuffer.a(i, 0, 0);
                        if (a != 0) {
                            jsonGenerator.a("count");
                            jsonGenerator.b(a);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m19795a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                                iArr[3] = CommentsParser.m19791a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("does_viewer_like")) {
                                zArr[3] = true;
                                zArr2[3] = jsonParser.H();
                            } else if (i.equals("id")) {
                                iArr[5] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("legacy_api_post_id")) {
                                iArr[6] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("likers")) {
                                iArr[7] = LikersParser.m19793a(jsonParser, flatBufferBuilder);
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

                public static void m19796a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                        CommentsParser.m19792a(mutableFlatBuffer, g, jsonGenerator);
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
                        LikersParser.m19794a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: interrupted_count */
            public final class ShareableParser {
                public static int m19797a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m19798a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            public static int m19799a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[8];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("actors")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(ActorsParser.m19777b(jsonParser, flatBufferBuilder)));
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
                        } else if (i.equals("attachments")) {
                            iArr[1] = AttachmentsParser.m19788a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("feedback")) {
                            iArr[2] = FeedbackParser.m19795a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[3] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("message")) {
                            iArr[4] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("shareable")) {
                            iArr[5] = ShareableParser.m19797a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("summary")) {
                            iArr[6] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("title")) {
                            iArr[7] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                flatBufferBuilder.b(3, iArr[3]);
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                return flatBufferBuilder.d();
            }

            public static void m19800a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                int i2;
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("actors");
                    jsonGenerator.d();
                    for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ActorsParser.m19776a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    jsonGenerator.d();
                    for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        AttachmentsParser.m19790b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 2);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m19796a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 5);
                if (g != 0) {
                    jsonGenerator.a("shareable");
                    ShareableParser.m19798a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("summary");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(i, 7);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m19801a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[32];
            boolean[] zArr = new boolean[19];
            boolean[] zArr2 = new boolean[7];
            int[] iArr2 = new int[9];
            long[] jArr = new long[1];
            double[] dArr = new double[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("can_viewer_delete")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_report")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("captions_url")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("created_time")) {
                        zArr[2] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_story")) {
                        iArr[4] = CreationStoryParser.m19799a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guided_tour")) {
                        iArr[5] = GuidedTourParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("height")) {
                        zArr[3] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("id")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("initial_view_heading_degrees")) {
                        zArr[4] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("initial_view_pitch_degrees")) {
                        zArr[5] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("initial_view_roll_degrees")) {
                        zArr[6] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("is_looping")) {
                        zArr[7] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_playable")) {
                        zArr[8] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("is_spherical")) {
                        zArr[9] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("is_video_broadcast")) {
                        zArr[10] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("loop_count")) {
                        zArr[11] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("message")) {
                        iArr[16] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("play_count")) {
                        zArr[12] = true;
                        iArr2[5] = jsonParser.E();
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[13] = true;
                        iArr2[6] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[19] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playable_url_hd")) {
                        iArr[20] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("projection_type")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalFullscreenAspectRatio")) {
                        zArr[14] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("sphericalInlineAspectRatio")) {
                        zArr[15] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("sphericalPlayableUrlHdString")) {
                        iArr[24] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPlayableUrlSdString")) {
                        iArr[25] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPreferredFov")) {
                        zArr[16] = true;
                        iArr2[7] = jsonParser.E();
                    } else if (i.equals("supports_time_slices")) {
                        zArr[17] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("title")) {
                        iArr[28] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("videoThumbnail")) {
                        iArr[29] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_captions_locales")) {
                        iArr[30] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("width")) {
                        zArr[18] = true;
                        iArr2[8] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(32);
            if (zArr[0]) {
                flatBufferBuilder.a(0, zArr2[0]);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, zArr2[1]);
            }
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[2]) {
                flatBufferBuilder.a(3, jArr[0], 0);
            }
            flatBufferBuilder.b(4, iArr[4]);
            flatBufferBuilder.b(5, iArr[5]);
            if (zArr[3]) {
                flatBufferBuilder.a(6, iArr2[0], 0);
            }
            flatBufferBuilder.b(7, iArr[7]);
            if (zArr[4]) {
                flatBufferBuilder.a(8, iArr2[1], 0);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(9, iArr2[2], 0);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(10, iArr2[3], 0);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(11, zArr2[2]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(12, zArr2[3]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(13, zArr2[4]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(14, zArr2[5]);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(15, iArr2[4], 0);
            }
            flatBufferBuilder.b(16, iArr[16]);
            if (zArr[12]) {
                flatBufferBuilder.a(17, iArr2[5], 0);
            }
            if (zArr[13]) {
                flatBufferBuilder.a(18, iArr2[6], 0);
            }
            flatBufferBuilder.b(19, iArr[19]);
            flatBufferBuilder.b(20, iArr[20]);
            flatBufferBuilder.b(21, iArr[21]);
            if (zArr[14]) {
                flatBufferBuilder.a(22, dArr[0], 0.0d);
            }
            if (zArr[15]) {
                flatBufferBuilder.a(23, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            if (zArr[16]) {
                flatBufferBuilder.a(26, iArr2[7], 0);
            }
            if (zArr[17]) {
                flatBufferBuilder.a(27, zArr2[6]);
            }
            flatBufferBuilder.b(28, iArr[28]);
            flatBufferBuilder.b(29, iArr[29]);
            flatBufferBuilder.b(30, iArr[30]);
            if (zArr[18]) {
                flatBufferBuilder.a(31, iArr2[8], 0);
            }
            return flatBufferBuilder.d();
        }

        public static int m19803b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            ArrayList arrayList = new ArrayList();
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    arrayList.add(Integer.valueOf(m19801a(jsonParser, flatBufferBuilder)));
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

        public static void m19802a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.d();
            for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                m19804b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }

        public static void m19804b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            boolean a = mutableFlatBuffer.a(i, 0);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 1);
            if (a) {
                jsonGenerator.a("can_viewer_report");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("captions_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            long a2 = mutableFlatBuffer.a(i, 3, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            int g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                CreationStoryParser.m19800a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 5);
            if (g != 0) {
                jsonGenerator.a("guided_tour");
                GuidedTourParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 6, 0);
            if (g != 0) {
                jsonGenerator.a("height");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 7) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 7));
            }
            g = mutableFlatBuffer.a(i, 8, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_heading_degrees");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 9, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_pitch_degrees");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 10, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_roll_degrees");
                jsonGenerator.b(g);
            }
            a = mutableFlatBuffer.a(i, 11);
            if (a) {
                jsonGenerator.a("is_looping");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 12);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 13);
            if (a) {
                jsonGenerator.a("is_spherical");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 14);
            if (a) {
                jsonGenerator.a("is_video_broadcast");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.a(i, 15, 0);
            if (g != 0) {
                jsonGenerator.a("loop_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 17, 0);
            if (g != 0) {
                jsonGenerator.a("play_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 18, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 19) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 19));
            }
            if (mutableFlatBuffer.g(i, 20) != 0) {
                jsonGenerator.a("playable_url_hd");
                jsonGenerator.b(mutableFlatBuffer.c(i, 20));
            }
            if (mutableFlatBuffer.g(i, 21) != 0) {
                jsonGenerator.a("projection_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 21));
            }
            double a3 = mutableFlatBuffer.a(i, 22, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalFullscreenAspectRatio");
                jsonGenerator.a(a3);
            }
            a3 = mutableFlatBuffer.a(i, 23, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalInlineAspectRatio");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 24) != 0) {
                jsonGenerator.a("sphericalPlayableUrlHdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 24));
            }
            if (mutableFlatBuffer.g(i, 25) != 0) {
                jsonGenerator.a("sphericalPlayableUrlSdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 25));
            }
            g = mutableFlatBuffer.a(i, 26, 0);
            if (g != 0) {
                jsonGenerator.a("sphericalPreferredFov");
                jsonGenerator.b(g);
            }
            a = mutableFlatBuffer.a(i, 27);
            if (a) {
                jsonGenerator.a("supports_time_slices");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 28);
            if (g != 0) {
                jsonGenerator.a("title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 29);
            if (g != 0) {
                jsonGenerator.a("videoThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 30) != 0) {
                jsonGenerator.a("video_captions_locales");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 30), jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 31, 0);
            if (g != 0) {
                jsonGenerator.a("width");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: interrupted_count */
    public final class VideoSimpleFragmentParser {
        public static int m19805b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[1];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("videoThumbnail")) {
                        iArr[0] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, iArr[0]);
            return flatBufferBuilder.d();
        }

        public static void m19806b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("videoThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: interrupted_count */
    public final class VideosUploadedByUserDetailQueryParser {

        /* compiled from: interrupted_count */
        public final class UploadedVideosParser {
            public static int m19807a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                        } else if (i.equals("nodes")) {
                            iArr[1] = VideoDetailFragmentParser.m19803b(jsonParser, flatBufferBuilder);
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

            public static void m19808a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("nodes");
                    VideoDetailFragmentParser.m19802a(mutableFlatBuffer, a, jsonGenerator, serializerProvider);
                }
                a = mutableFlatBuffer.g(i, 2);
                if (a != 0) {
                    jsonGenerator.a("page_info");
                    DefaultPageInfoFieldsParser.a(mutableFlatBuffer, a, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m19809a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
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
                    } else if (i.equals("uploaded_videos")) {
                        iArr[3] = UploadedVideosParser.m19807a(jsonParser, flatBufferBuilder);
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

    /* compiled from: interrupted_count */
    public final class VideosUploadedByUserSimpleQueryParser {

        /* compiled from: interrupted_count */
        public final class UploadedVideosParser {
            public static int m19810a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(VideoSimpleFragmentParser.m19805b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr3 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr3[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr3, true);
                            }
                            iArr[1] = i2;
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

            public static void m19811a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.g(i, 1);
                if (a != 0) {
                    jsonGenerator.a("nodes");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(a); i2++) {
                        VideoSimpleFragmentParser.m19806b(mutableFlatBuffer, mutableFlatBuffer.m(a, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m19812a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("uploaded_videos")) {
                        iArr[2] = UploadedVideosParser.m19810a(jsonParser, flatBufferBuilder);
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
