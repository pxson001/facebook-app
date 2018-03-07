package com.facebook.video.videohome.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: dictionary_table */
public class VideoHomeQueryParsers {

    /* compiled from: dictionary_table */
    public final class VideoHomeBadgeQueryParser {
        public static MutableFlatBuffer m19743a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            boolean[] zArr = new boolean[3];
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("video_home_badge_check_interval_s")) {
                        zArr[0] = true;
                        iArr[0] = jsonParser.E();
                    } else if (i.equals("video_home_badge_count")) {
                        zArr[1] = true;
                        iArr[1] = jsonParser.E();
                    } else if (i.equals("video_home_max_badge_count")) {
                        zArr[2] = true;
                        iArr[2] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, iArr[1], 0);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, iArr[2], 0);
            }
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: dictionary_table */
    public final class VideoHomeCreatorYouShouldFollowParser {

        /* compiled from: dictionary_table */
        public final class PageLikersParser {
            public static int m19744a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

            public static void m19745a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                int a = mutableFlatBuffer.a(i, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("count");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: dictionary_table */
        public final class VideoChannelCuratorProfileParser {
            public static int m19746a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("profile_picture")) {
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

            public static void m19747a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static int m19748a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[7];
            boolean[] zArr = new boolean[2];
            boolean[] zArr2 = new boolean[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("page_likers")) {
                        iArr[2] = PageLikersParser.m19744a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel_can_viewer_subscribe")) {
                        zArr[0] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("video_channel_curator_profile")) {
                        iArr[4] = VideoChannelCuratorProfileParser.m19746a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel_has_viewer_subscribed")) {
                        zArr[1] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("video_channel_title")) {
                        iArr[6] = DefaultTextWithEntitiesFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            if (zArr[0]) {
                flatBufferBuilder.a(3, zArr2[0]);
            }
            flatBufferBuilder.b(4, iArr[4]);
            if (zArr[1]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            flatBufferBuilder.b(6, iArr[6]);
            return flatBufferBuilder.d();
        }

        public static void m19749a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("page_likers");
                PageLikersParser.m19745a(mutableFlatBuffer, g, jsonGenerator);
            }
            boolean a = mutableFlatBuffer.a(i, 3);
            if (a) {
                jsonGenerator.a("video_channel_can_viewer_subscribe");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 4);
            if (g != 0) {
                jsonGenerator.a("video_channel_curator_profile");
                VideoChannelCuratorProfileParser.m19747a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 5);
            if (a) {
                jsonGenerator.a("video_channel_has_viewer_subscribed");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.g(i, 6);
            if (g != 0) {
                jsonGenerator.a("video_channel_title");
                DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: dictionary_table */
    public final class VideoHomePrefetchMetadataNoBadgingQueryParser {
        public static MutableFlatBuffer m19750a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            boolean[] zArr = new boolean[3];
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("video_home_badge_check_interval_s")) {
                        zArr[0] = true;
                        iArr[0] = jsonParser.E();
                    } else if (i.equals("video_home_prefetch_unit_count")) {
                        zArr[1] = true;
                        iArr[1] = jsonParser.E();
                    } else if (i.equals("video_home_stale_data_interval_s")) {
                        zArr[2] = true;
                        iArr[2] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, iArr[1], 0);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, iArr[2], 0);
            }
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: dictionary_table */
    public final class VideoHomePrefetchMetadataQueryParser {
        public static MutableFlatBuffer m19751a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            boolean[] zArr = new boolean[3];
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("video_home_badge_count")) {
                        zArr[0] = true;
                        iArr[0] = jsonParser.E();
                    } else if (i.equals("video_home_prefetch_unit_count")) {
                        zArr[1] = true;
                        iArr[1] = jsonParser.E();
                    } else if (i.equals("video_home_stale_data_interval_s")) {
                        zArr[2] = true;
                        iArr[2] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            if (zArr[0]) {
                flatBufferBuilder.a(0, iArr[0], 0);
            }
            if (zArr[1]) {
                flatBufferBuilder.a(1, iArr[1], 0);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(2, iArr[2], 0);
            }
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }
}
