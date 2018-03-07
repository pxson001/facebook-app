package com.facebook.search.results.protocol.video;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: menu_photo_tap */
public class SearchResultsVideoParsers {

    /* compiled from: menu_photo_tap */
    public final class SearchResultsVideoParser {

        /* compiled from: menu_photo_tap */
        public final class OwnerParser {
            public static int m10568a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[3];
                boolean[] zArr = new boolean[1];
                boolean[] zArr2 = new boolean[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("__type__")) {
                            iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                        } else if (i.equals("is_verified")) {
                            zArr[0] = true;
                            zArr2[0] = jsonParser.H();
                        } else if (i.equals("name")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, iArr[0]);
                if (zArr[0]) {
                    flatBufferBuilder.a(1, zArr2[0]);
                }
                flatBufferBuilder.b(2, iArr[2]);
                return flatBufferBuilder.d();
            }

            public static void m10569a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(i, 1);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                jsonGenerator.g();
            }
        }

        public static int m10570a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[31];
            boolean[] zArr = new boolean[20];
            boolean[] zArr2 = new boolean[7];
            int[] iArr2 = new int[10];
            long[] jArr = new long[1];
            double[] dArr = new double[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("broadcast_status")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLVideoBroadcastStatus.fromString(jsonParser.o()));
                    } else if (i.equals("created_time")) {
                        zArr[0] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_story")) {
                        iArr[2] = GraphQLStoryDeserializer.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guided_tour")) {
                        iArr[3] = GuidedTourParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("has_viewer_viewed")) {
                        zArr[1] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("has_viewer_watched_video")) {
                        zArr[2] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("height")) {
                        zArr[3] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("id")) {
                        iArr[7] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("imageVideoThumbnail")) {
                        iArr[8] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("initial_view_heading_degrees")) {
                        zArr[4] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("initial_view_pitch_degrees")) {
                        zArr[5] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("initial_view_roll_degrees")) {
                        zArr[6] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("is_live_streaming")) {
                        zArr[7] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("is_looping")) {
                        zArr[8] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("is_spherical")) {
                        zArr[9] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("is_video_broadcast")) {
                        zArr[10] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("live_viewer_count_read_only")) {
                        zArr[11] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("loop_count")) {
                        zArr[12] = true;
                        iArr2[5] = jsonParser.E();
                    } else if (i.equals("message")) {
                        iArr[18] = DefaultTextWithEntitiesLongFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("owner")) {
                        iArr[19] = OwnerParser.m10568a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("play_count")) {
                        zArr[13] = true;
                        iArr2[6] = jsonParser.E();
                    } else if (i.equals("playable_duration")) {
                        zArr[14] = true;
                        iArr2[7] = jsonParser.E();
                    } else if (i.equals("playlist")) {
                        iArr[22] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("projection_type")) {
                        iArr[23] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalFullscreenAspectRatio")) {
                        zArr[15] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("sphericalInlineAspectRatio")) {
                        zArr[16] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("sphericalPlayableUrlHdString")) {
                        iArr[26] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPlayableUrlSdString")) {
                        iArr[27] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPreferredFov")) {
                        zArr[17] = true;
                        iArr2[8] = jsonParser.E();
                    } else if (i.equals("supports_time_slices")) {
                        zArr[18] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("width")) {
                        zArr[19] = true;
                        iArr2[9] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(31);
            flatBufferBuilder.b(0, iArr[0]);
            if (zArr[0]) {
                flatBufferBuilder.a(1, jArr[0], 0);
            }
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.b(3, iArr[3]);
            if (zArr[1]) {
                flatBufferBuilder.a(4, zArr2[0]);
            }
            if (zArr[2]) {
                flatBufferBuilder.a(5, zArr2[1]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(6, iArr2[0], 0);
            }
            flatBufferBuilder.b(7, iArr[7]);
            flatBufferBuilder.b(8, iArr[8]);
            if (zArr[4]) {
                flatBufferBuilder.a(9, iArr2[1], 0);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(10, iArr2[2], 0);
            }
            if (zArr[6]) {
                flatBufferBuilder.a(11, iArr2[3], 0);
            }
            if (zArr[7]) {
                flatBufferBuilder.a(12, zArr2[2]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(13, zArr2[3]);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(14, zArr2[4]);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(15, zArr2[5]);
            }
            if (zArr[11]) {
                flatBufferBuilder.a(16, iArr2[4], 0);
            }
            if (zArr[12]) {
                flatBufferBuilder.a(17, iArr2[5], 0);
            }
            flatBufferBuilder.b(18, iArr[18]);
            flatBufferBuilder.b(19, iArr[19]);
            if (zArr[13]) {
                flatBufferBuilder.a(20, iArr2[6], 0);
            }
            if (zArr[14]) {
                flatBufferBuilder.a(21, iArr2[7], 0);
            }
            flatBufferBuilder.b(22, iArr[22]);
            flatBufferBuilder.b(23, iArr[23]);
            if (zArr[15]) {
                flatBufferBuilder.a(24, dArr[0], 0.0d);
            }
            if (zArr[16]) {
                flatBufferBuilder.a(25, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            if (zArr[17]) {
                flatBufferBuilder.a(28, iArr2[8], 0);
            }
            if (zArr[18]) {
                flatBufferBuilder.a(29, zArr2[6]);
            }
            if (zArr[19]) {
                flatBufferBuilder.a(30, iArr2[9], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m10571a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("broadcast_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 0));
            }
            long a = mutableFlatBuffer.a(i, 1, 0);
            if (a != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a);
            }
            int g = mutableFlatBuffer.g(i, 2);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                GraphQLStoryDeserializer.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("guided_tour");
                GuidedTourParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            boolean a2 = mutableFlatBuffer.a(i, 4);
            if (a2) {
                jsonGenerator.a("has_viewer_viewed");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 5);
            if (a2) {
                jsonGenerator.a("has_viewer_watched_video");
                jsonGenerator.a(a2);
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
            g = mutableFlatBuffer.g(i, 8);
            if (g != 0) {
                jsonGenerator.a("imageVideoThumbnail");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 9, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_heading_degrees");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 10, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_pitch_degrees");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 11, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_roll_degrees");
                jsonGenerator.b(g);
            }
            a2 = mutableFlatBuffer.a(i, 12);
            if (a2) {
                jsonGenerator.a("is_live_streaming");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 13);
            if (a2) {
                jsonGenerator.a("is_looping");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 14);
            if (a2) {
                jsonGenerator.a("is_spherical");
                jsonGenerator.a(a2);
            }
            a2 = mutableFlatBuffer.a(i, 15);
            if (a2) {
                jsonGenerator.a("is_video_broadcast");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.a(i, 16, 0);
            if (g != 0) {
                jsonGenerator.a("live_viewer_count_read_only");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 17, 0);
            if (g != 0) {
                jsonGenerator.a("loop_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 18);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 19);
            if (g != 0) {
                jsonGenerator.a("owner");
                OwnerParser.m10569a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 20, 0);
            if (g != 0) {
                jsonGenerator.a("play_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 21, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 22) != 0) {
                jsonGenerator.a("playlist");
                jsonGenerator.b(mutableFlatBuffer.c(i, 22));
            }
            if (mutableFlatBuffer.g(i, 23) != 0) {
                jsonGenerator.a("projection_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 23));
            }
            double a3 = mutableFlatBuffer.a(i, 24, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalFullscreenAspectRatio");
                jsonGenerator.a(a3);
            }
            a3 = mutableFlatBuffer.a(i, 25, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalInlineAspectRatio");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 26) != 0) {
                jsonGenerator.a("sphericalPlayableUrlHdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 26));
            }
            if (mutableFlatBuffer.g(i, 27) != 0) {
                jsonGenerator.a("sphericalPlayableUrlSdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 27));
            }
            g = mutableFlatBuffer.a(i, 28, 0);
            if (g != 0) {
                jsonGenerator.a("sphericalPreferredFov");
                jsonGenerator.b(g);
            }
            a2 = mutableFlatBuffer.a(i, 29);
            if (a2) {
                jsonGenerator.a("supports_time_slices");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.a(i, 30, 0);
            if (g != 0) {
                jsonGenerator.a("width");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }
}
