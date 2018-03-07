package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLParsers.NewsFeedDefaultsFeedbackParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.AttributionAppMediaMetadataParser.AttributionAppParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.VideoChannelIdForVideoFragmentParser.VideoChannelParser;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.DeserializerHelpers;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: api_error_response */
public class NewsFeedDefaultsMediaGraphQLParsers {

    /* compiled from: api_error_response */
    public final class AttachmentMediaParser {

        /* compiled from: api_error_response */
        public final class CreationStoryParser {

            /* compiled from: api_error_response */
            public final class ActorsParser {
                public static int m16046b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static int m16044a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m16046b(jsonParser, flatBufferBuilder)));
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

                public static void m16045a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            /* compiled from: api_error_response */
            public final class AttachmentsParser {

                /* compiled from: api_error_response */
                public final class MediaParser {
                    public static int m16047a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[3];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("id")) {
                                    iArr[1] = flatBufferBuilder.b(jsonParser.o());
                                } else if (i.equals("image")) {
                                    iArr[2] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
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

                    public static void m16048a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
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
                            jsonGenerator.a("image");
                            DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: api_error_response */
                public final class SourceParser {
                    public static int m16049a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                    public static void m16050a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("text");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                /* compiled from: api_error_response */
                public final class TargetParser {

                    /* compiled from: api_error_response */
                    public final class ApplicationParser {
                        public static int m16051a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                        public static void m16052a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

                    public static int m16053a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[2];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("__type__")) {
                                    iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                                } else if (i.equals("application")) {
                                    iArr[1] = ApplicationParser.m16051a(jsonParser, flatBufferBuilder);
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

                    public static void m16054a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("__type__");
                            SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
                        }
                        int g = mutableFlatBuffer.g(i, 1);
                        if (g != 0) {
                            jsonGenerator.a("application");
                            ApplicationParser.m16052a(mutableFlatBuffer, g, jsonGenerator);
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m16056b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[6];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("media")) {
                                iArr[0] = MediaParser.m16047a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("source")) {
                                iArr[1] = SourceParser.m16049a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("style_list")) {
                                iArr[2] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                            } else if (i.equals("target")) {
                                iArr[3] = TargetParser.m16053a(jsonParser, flatBufferBuilder);
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

                public static int m16055a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    ArrayList arrayList = new ArrayList();
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            arrayList.add(Integer.valueOf(m16056b(jsonParser, flatBufferBuilder)));
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

                public static void m16057b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("media");
                        MediaParser.m16048a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("source");
                        SourceParser.m16050a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    if (mutableFlatBuffer.g(i, 2) != 0) {
                        jsonGenerator.a("style_list");
                        SerializerHelpers.a(mutableFlatBuffer.f(i, 2), jsonGenerator);
                    }
                    g = mutableFlatBuffer.g(i, 3);
                    if (g != 0) {
                        jsonGenerator.a("target");
                        TargetParser.m16054a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
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

            /* compiled from: api_error_response */
            public final class ShareableParser {
                public static int m16058a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
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

                public static void m16059a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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

            public static int m16060a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[8];
                boolean[] zArr = new boolean[1];
                long[] jArr = new long[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("actors")) {
                            iArr[0] = ActorsParser.m16044a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("attachments")) {
                            iArr[1] = AttachmentsParser.m16055a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("cache_id")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("creation_time")) {
                            zArr[0] = true;
                            jArr[0] = jsonParser.F();
                        } else if (i.equals("feedback")) {
                            iArr[4] = NewsFeedDefaultsFeedbackParser.m16377a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("id")) {
                            iArr[5] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("shareable")) {
                            iArr[6] = ShareableParser.m16058a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("tracking")) {
                            iArr[7] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                flatBufferBuilder.b(2, iArr[2]);
                if (zArr[0]) {
                    flatBufferBuilder.a(3, jArr[0], 0);
                }
                flatBufferBuilder.b(4, iArr[4]);
                flatBufferBuilder.b(5, iArr[5]);
                flatBufferBuilder.b(6, iArr[6]);
                flatBufferBuilder.b(7, iArr[7]);
                return flatBufferBuilder.d();
            }

            public static void m16061a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                int i2;
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("actors");
                    jsonGenerator.d();
                    for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        ActorsParser.m16045a(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    jsonGenerator.d();
                    for (i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        AttachmentsParser.m16057b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("cache_id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                long a = mutableFlatBuffer.a(i, 3, 0);
                if (a != 0) {
                    jsonGenerator.a("creation_time");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(i, 4);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    NewsFeedDefaultsFeedbackParser.m16378a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(i, 5) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 5));
                }
                g = mutableFlatBuffer.g(i, 6);
                if (g != 0) {
                    jsonGenerator.a("shareable");
                    ShareableParser.m16059a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(i, 7) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 7));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: api_error_response */
        public final class OwnerParser {
            public static int m16062a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[9];
                boolean[] zArr = new boolean[5];
                boolean[] zArr2 = new boolean[5];
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
                        } else if (i.equals("live_video_subscription_status")) {
                            iArr[3] = flatBufferBuilder.a(GraphQLLiveVideoSubscriptionStatus.fromString(jsonParser.o()));
                        } else if (i.equals("name")) {
                            iArr[4] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("video_channel_can_viewer_follow")) {
                            zArr[1] = true;
                            zArr2[1] = jsonParser.H();
                        } else if (i.equals("video_channel_can_viewer_subscribe")) {
                            zArr[2] = true;
                            zArr2[2] = jsonParser.H();
                        } else if (i.equals("video_channel_has_viewer_subscribed")) {
                            zArr[3] = true;
                            zArr2[3] = jsonParser.H();
                        } else if (i.equals("video_channel_is_viewer_following")) {
                            zArr[4] = true;
                            zArr2[4] = jsonParser.H();
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
                return flatBufferBuilder.d();
            }

            public static void m16063a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
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
                    jsonGenerator.a("live_video_subscription_status");
                    jsonGenerator.b(mutableFlatBuffer.b(i, 3));
                }
                if (mutableFlatBuffer.g(i, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 4));
                }
                a = mutableFlatBuffer.a(i, 5);
                if (a) {
                    jsonGenerator.a("video_channel_can_viewer_follow");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 6);
                if (a) {
                    jsonGenerator.a("video_channel_can_viewer_subscribe");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 7);
                if (a) {
                    jsonGenerator.a("video_channel_has_viewer_subscribed");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(i, 8);
                if (a) {
                    jsonGenerator.a("video_channel_is_viewer_following");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: api_error_response */
        public final class PairedVideoParser {
            public static int m16064a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("playable_url")) {
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

            public static void m16065a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("playable_url");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                jsonGenerator.g();
            }
        }

        public static int m16066a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[71];
            boolean[] zArr = new boolean[38];
            boolean[] zArr2 = new boolean[19];
            int[] iArr2 = new int[16];
            long[] jArr = new long[1];
            double[] dArr = new double[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("animated_image")) {
                        iArr[1] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("atom_size")) {
                        zArr[0] = true;
                        iArr2[0] = jsonParser.E();
                    } else if (i.equals("attribution_app")) {
                        iArr[3] = AttributionAppParser.m16864a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("attribution_app_metadata")) {
                        iArr[4] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("bitrate")) {
                        zArr[1] = true;
                        iArr2[1] = jsonParser.E();
                    } else if (i.equals("broadcast_status")) {
                        iArr[6] = flatBufferBuilder.a(GraphQLVideoBroadcastStatus.fromString(jsonParser.o()));
                    } else if (i.equals("can_viewer_delete")) {
                        zArr[2] = true;
                        zArr2[0] = jsonParser.H();
                    } else if (i.equals("can_viewer_export")) {
                        zArr[3] = true;
                        zArr2[1] = jsonParser.H();
                    } else if (i.equals("can_viewer_report")) {
                        zArr[4] = true;
                        zArr2[2] = jsonParser.H();
                    } else if (i.equals("can_viewer_share")) {
                        zArr[5] = true;
                        zArr2[3] = jsonParser.H();
                    } else if (i.equals("captions_url")) {
                        iArr[11] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("created_time")) {
                        zArr[6] = true;
                        jArr[0] = jsonParser.F();
                    } else if (i.equals("creation_story")) {
                        iArr[13] = CreationStoryParser.m16060a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("feedback")) {
                        iArr[14] = NewsFeedDefaultsFeedbackParser.m16377a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("focus")) {
                        iArr[15] = DefaultVect2FieldsParser.m9656a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("guided_tour")) {
                        iArr[16] = GuidedTourParser.m16869a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("has_stickers")) {
                        zArr[7] = true;
                        zArr2[4] = jsonParser.H();
                    } else if (i.equals("hdAtomSize")) {
                        zArr[8] = true;
                        iArr2[2] = jsonParser.E();
                    } else if (i.equals("hdBitrate")) {
                        zArr[9] = true;
                        iArr2[3] = jsonParser.E();
                    } else if (i.equals("height")) {
                        zArr[10] = true;
                        iArr2[4] = jsonParser.E();
                    } else if (i.equals("id")) {
                        iArr[21] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("image")) {
                        iArr[22] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageHigh")) {
                        iArr[23] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLargeAspect")) {
                        iArr[24] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageLow")) {
                        iArr[25] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("imageMedium")) {
                        iArr[26] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("image_blurred")) {
                        iArr[27] = DefaultImageFieldsParser.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("initial_view_heading_degrees")) {
                        zArr[11] = true;
                        iArr2[5] = jsonParser.E();
                    } else if (i.equals("initial_view_pitch_degrees")) {
                        zArr[12] = true;
                        iArr2[6] = jsonParser.E();
                    } else if (i.equals("initial_view_roll_degrees")) {
                        zArr[13] = true;
                        iArr2[7] = jsonParser.E();
                    } else if (i.equals("is_age_restricted")) {
                        zArr[14] = true;
                        zArr2[5] = jsonParser.H();
                    } else if (i.equals("is_disturbing")) {
                        zArr[15] = true;
                        zArr2[6] = jsonParser.H();
                    } else if (i.equals("is_eligible_for_commercial_break")) {
                        zArr[16] = true;
                        zArr2[7] = jsonParser.H();
                    } else if (i.equals("is_live_streaming")) {
                        zArr[17] = true;
                        zArr2[8] = jsonParser.H();
                    } else if (i.equals("is_looping")) {
                        zArr[18] = true;
                        zArr2[9] = jsonParser.H();
                    } else if (i.equals("is_playable")) {
                        zArr[19] = true;
                        zArr2[10] = jsonParser.H();
                    } else if (i.equals("is_save_primary_action")) {
                        zArr[20] = true;
                        zArr2[11] = jsonParser.H();
                    } else if (i.equals("is_spherical")) {
                        zArr[21] = true;
                        zArr2[12] = jsonParser.H();
                    } else if (i.equals("is_video_broadcast")) {
                        zArr[22] = true;
                        zArr2[13] = jsonParser.H();
                    } else if (i.equals("loop_count")) {
                        zArr[23] = true;
                        iArr2[8] = jsonParser.E();
                    } else if (i.equals("message")) {
                        iArr[41] = DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("owner")) {
                        iArr[42] = OwnerParser.m16062a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("paired_video")) {
                        iArr[43] = PairedVideoParser.m16064a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("photo_encodings")) {
                        iArr[44] = PhotoEncodingsParser.m16070a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("play_count")) {
                        zArr[24] = true;
                        iArr2[9] = jsonParser.E();
                    } else if (i.equals("playableUrlHdString")) {
                        iArr[46] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playableUrlRtmpString")) {
                        iArr[47] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playable_duration_in_ms")) {
                        zArr[25] = true;
                        iArr2[10] = jsonParser.E();
                    } else if (i.equals("playable_url")) {
                        iArr[49] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("playlist")) {
                        iArr[50] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("post_play_count")) {
                        zArr[26] = true;
                        iArr2[11] = jsonParser.E();
                    } else if (i.equals("preferredPlayableUrlString")) {
                        iArr[52] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("projection_type")) {
                        iArr[53] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("publisher_context")) {
                        iArr[54] = DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("should_open_single_publisher")) {
                        zArr[27] = true;
                        zArr2[14] = jsonParser.H();
                    } else if (i.equals("should_show_live_subscribe")) {
                        zArr[28] = true;
                        zArr2[15] = jsonParser.H();
                    } else if (i.equals("show_video_channel_subscribe_button")) {
                        zArr[29] = true;
                        zArr2[16] = jsonParser.H();
                    } else if (i.equals("show_video_home_follow_button")) {
                        zArr[30] = true;
                        zArr2[17] = jsonParser.H();
                    } else if (i.equals("sphericalFullscreenAspectRatio")) {
                        zArr[31] = true;
                        dArr[0] = jsonParser.G();
                    } else if (i.equals("sphericalInlineAspectRatio")) {
                        zArr[32] = true;
                        dArr[1] = jsonParser.G();
                    } else if (i.equals("sphericalPlayableUrlHdString")) {
                        iArr[61] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPlayableUrlSdString")) {
                        iArr[62] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("sphericalPreferredFov")) {
                        zArr[33] = true;
                        iArr2[12] = jsonParser.E();
                    } else if (i.equals("supports_time_slices")) {
                        zArr[34] = true;
                        zArr2[18] = jsonParser.H();
                    } else if (i.equals("total_posts")) {
                        zArr[35] = true;
                        iArr2[13] = jsonParser.E();
                    } else if (i.equals("video_captions_locales")) {
                        iArr[66] = DeserializerHelpers.a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_channel")) {
                        iArr[67] = VideoChannelParser.m16873a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("video_full_size")) {
                        zArr[36] = true;
                        iArr2[14] = jsonParser.E();
                    } else if (i.equals("video_status_type")) {
                        iArr[69] = flatBufferBuilder.a(GraphQLVideoStatusType.fromString(jsonParser.o()));
                    } else if (i.equals("width")) {
                        zArr[37] = true;
                        iArr2[15] = jsonParser.E();
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(71);
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
            flatBufferBuilder.b(6, iArr[6]);
            if (zArr[2]) {
                flatBufferBuilder.a(7, zArr2[0]);
            }
            if (zArr[3]) {
                flatBufferBuilder.a(8, zArr2[1]);
            }
            if (zArr[4]) {
                flatBufferBuilder.a(9, zArr2[2]);
            }
            if (zArr[5]) {
                flatBufferBuilder.a(10, zArr2[3]);
            }
            flatBufferBuilder.b(11, iArr[11]);
            if (zArr[6]) {
                flatBufferBuilder.a(12, jArr[0], 0);
            }
            flatBufferBuilder.b(13, iArr[13]);
            flatBufferBuilder.b(14, iArr[14]);
            flatBufferBuilder.b(15, iArr[15]);
            flatBufferBuilder.b(16, iArr[16]);
            if (zArr[7]) {
                flatBufferBuilder.a(17, zArr2[4]);
            }
            if (zArr[8]) {
                flatBufferBuilder.a(18, iArr2[2], 0);
            }
            if (zArr[9]) {
                flatBufferBuilder.a(19, iArr2[3], 0);
            }
            if (zArr[10]) {
                flatBufferBuilder.a(20, iArr2[4], 0);
            }
            flatBufferBuilder.b(21, iArr[21]);
            flatBufferBuilder.b(22, iArr[22]);
            flatBufferBuilder.b(23, iArr[23]);
            flatBufferBuilder.b(24, iArr[24]);
            flatBufferBuilder.b(25, iArr[25]);
            flatBufferBuilder.b(26, iArr[26]);
            flatBufferBuilder.b(27, iArr[27]);
            if (zArr[11]) {
                flatBufferBuilder.a(28, iArr2[5], 0);
            }
            if (zArr[12]) {
                flatBufferBuilder.a(29, iArr2[6], 0);
            }
            if (zArr[13]) {
                flatBufferBuilder.a(30, iArr2[7], 0);
            }
            if (zArr[14]) {
                flatBufferBuilder.a(31, zArr2[5]);
            }
            if (zArr[15]) {
                flatBufferBuilder.a(32, zArr2[6]);
            }
            if (zArr[16]) {
                flatBufferBuilder.a(33, zArr2[7]);
            }
            if (zArr[17]) {
                flatBufferBuilder.a(34, zArr2[8]);
            }
            if (zArr[18]) {
                flatBufferBuilder.a(35, zArr2[9]);
            }
            if (zArr[19]) {
                flatBufferBuilder.a(36, zArr2[10]);
            }
            if (zArr[20]) {
                flatBufferBuilder.a(37, zArr2[11]);
            }
            if (zArr[21]) {
                flatBufferBuilder.a(38, zArr2[12]);
            }
            if (zArr[22]) {
                flatBufferBuilder.a(39, zArr2[13]);
            }
            if (zArr[23]) {
                flatBufferBuilder.a(40, iArr2[8], 0);
            }
            flatBufferBuilder.b(41, iArr[41]);
            flatBufferBuilder.b(42, iArr[42]);
            flatBufferBuilder.b(43, iArr[43]);
            flatBufferBuilder.b(44, iArr[44]);
            if (zArr[24]) {
                flatBufferBuilder.a(45, iArr2[9], 0);
            }
            flatBufferBuilder.b(46, iArr[46]);
            flatBufferBuilder.b(47, iArr[47]);
            if (zArr[25]) {
                flatBufferBuilder.a(48, iArr2[10], 0);
            }
            flatBufferBuilder.b(49, iArr[49]);
            flatBufferBuilder.b(50, iArr[50]);
            if (zArr[26]) {
                flatBufferBuilder.a(51, iArr2[11], 0);
            }
            flatBufferBuilder.b(52, iArr[52]);
            flatBufferBuilder.b(53, iArr[53]);
            flatBufferBuilder.b(54, iArr[54]);
            if (zArr[27]) {
                flatBufferBuilder.a(55, zArr2[14]);
            }
            if (zArr[28]) {
                flatBufferBuilder.a(56, zArr2[15]);
            }
            if (zArr[29]) {
                flatBufferBuilder.a(57, zArr2[16]);
            }
            if (zArr[30]) {
                flatBufferBuilder.a(58, zArr2[17]);
            }
            if (zArr[31]) {
                flatBufferBuilder.a(59, dArr[0], 0.0d);
            }
            if (zArr[32]) {
                flatBufferBuilder.a(60, dArr[1], 0.0d);
            }
            flatBufferBuilder.b(61, iArr[61]);
            flatBufferBuilder.b(62, iArr[62]);
            if (zArr[33]) {
                flatBufferBuilder.a(63, iArr2[12], 0);
            }
            if (zArr[34]) {
                flatBufferBuilder.a(64, zArr2[18]);
            }
            if (zArr[35]) {
                flatBufferBuilder.a(65, iArr2[13], 0);
            }
            flatBufferBuilder.b(66, iArr[66]);
            flatBufferBuilder.b(67, iArr[67]);
            if (zArr[36]) {
                flatBufferBuilder.a(68, iArr2[14], 0);
            }
            flatBufferBuilder.b(69, iArr[69]);
            if (zArr[37]) {
                flatBufferBuilder.a(70, iArr2[15], 0);
            }
            return flatBufferBuilder.d();
        }

        public static void m16067a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            if (mutableFlatBuffer.g(i, 0) != 0) {
                jsonGenerator.a("__type__");
                SerializerHelpers.b(mutableFlatBuffer, i, 0, jsonGenerator);
            }
            int g = mutableFlatBuffer.g(i, 1);
            if (g != 0) {
                jsonGenerator.a("animated_image");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 2, 0);
            if (g != 0) {
                jsonGenerator.a("atom_size");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 3);
            if (g != 0) {
                jsonGenerator.a("attribution_app");
                AttributionAppParser.m16865a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 4) != 0) {
                jsonGenerator.a("attribution_app_metadata");
                jsonGenerator.b(mutableFlatBuffer.c(i, 4));
            }
            g = mutableFlatBuffer.a(i, 5, 0);
            if (g != 0) {
                jsonGenerator.a("bitrate");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 6) != 0) {
                jsonGenerator.a("broadcast_status");
                jsonGenerator.b(mutableFlatBuffer.b(i, 6));
            }
            boolean a = mutableFlatBuffer.a(i, 7);
            if (a) {
                jsonGenerator.a("can_viewer_delete");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 8);
            if (a) {
                jsonGenerator.a("can_viewer_export");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 9);
            if (a) {
                jsonGenerator.a("can_viewer_report");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 10);
            if (a) {
                jsonGenerator.a("can_viewer_share");
                jsonGenerator.a(a);
            }
            if (mutableFlatBuffer.g(i, 11) != 0) {
                jsonGenerator.a("captions_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 11));
            }
            long a2 = mutableFlatBuffer.a(i, 12, 0);
            if (a2 != 0) {
                jsonGenerator.a("created_time");
                jsonGenerator.a(a2);
            }
            g = mutableFlatBuffer.g(i, 13);
            if (g != 0) {
                jsonGenerator.a("creation_story");
                CreationStoryParser.m16061a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 14);
            if (g != 0) {
                jsonGenerator.a("feedback");
                NewsFeedDefaultsFeedbackParser.m16378a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 15);
            if (g != 0) {
                jsonGenerator.a("focus");
                DefaultVect2FieldsParser.m9657a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 16);
            if (g != 0) {
                jsonGenerator.a("guided_tour");
                GuidedTourParser.m16870a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            a = mutableFlatBuffer.a(i, 17);
            if (a) {
                jsonGenerator.a("has_stickers");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.a(i, 18, 0);
            if (g != 0) {
                jsonGenerator.a("hdAtomSize");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 19, 0);
            if (g != 0) {
                jsonGenerator.a("hdBitrate");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 20, 0);
            if (g != 0) {
                jsonGenerator.a("height");
                jsonGenerator.b(g);
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
                jsonGenerator.a("imageLargeAspect");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 25);
            if (g != 0) {
                jsonGenerator.a("imageLow");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 26);
            if (g != 0) {
                jsonGenerator.a("imageMedium");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 27);
            if (g != 0) {
                jsonGenerator.a("image_blurred");
                DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 28, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_heading_degrees");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 29, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_pitch_degrees");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.a(i, 30, 0);
            if (g != 0) {
                jsonGenerator.a("initial_view_roll_degrees");
                jsonGenerator.b(g);
            }
            a = mutableFlatBuffer.a(i, 31);
            if (a) {
                jsonGenerator.a("is_age_restricted");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 32);
            if (a) {
                jsonGenerator.a("is_disturbing");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 33);
            if (a) {
                jsonGenerator.a("is_eligible_for_commercial_break");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 34);
            if (a) {
                jsonGenerator.a("is_live_streaming");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 35);
            if (a) {
                jsonGenerator.a("is_looping");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 36);
            if (a) {
                jsonGenerator.a("is_playable");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 37);
            if (a) {
                jsonGenerator.a("is_save_primary_action");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 38);
            if (a) {
                jsonGenerator.a("is_spherical");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 39);
            if (a) {
                jsonGenerator.a("is_video_broadcast");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.a(i, 40, 0);
            if (g != 0) {
                jsonGenerator.a("loop_count");
                jsonGenerator.b(g);
            }
            g = mutableFlatBuffer.g(i, 41);
            if (g != 0) {
                jsonGenerator.a("message");
                DefaultTextWithEntitiesLongFieldsParser.m9844b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.g(i, 42);
            if (g != 0) {
                jsonGenerator.a("owner");
                OwnerParser.m16063a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 43);
            if (g != 0) {
                jsonGenerator.a("paired_video");
                PairedVideoParser.m16065a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 44);
            if (g != 0) {
                jsonGenerator.a("photo_encodings");
                PhotoEncodingsParser.m16071a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            g = mutableFlatBuffer.a(i, 45, 0);
            if (g != 0) {
                jsonGenerator.a("play_count");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 46) != 0) {
                jsonGenerator.a("playableUrlHdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 46));
            }
            if (mutableFlatBuffer.g(i, 47) != 0) {
                jsonGenerator.a("playableUrlRtmpString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 47));
            }
            g = mutableFlatBuffer.a(i, 48, 0);
            if (g != 0) {
                jsonGenerator.a("playable_duration_in_ms");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 49) != 0) {
                jsonGenerator.a("playable_url");
                jsonGenerator.b(mutableFlatBuffer.c(i, 49));
            }
            if (mutableFlatBuffer.g(i, 50) != 0) {
                jsonGenerator.a("playlist");
                jsonGenerator.b(mutableFlatBuffer.c(i, 50));
            }
            g = mutableFlatBuffer.a(i, 51, 0);
            if (g != 0) {
                jsonGenerator.a("post_play_count");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 52) != 0) {
                jsonGenerator.a("preferredPlayableUrlString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 52));
            }
            if (mutableFlatBuffer.g(i, 53) != 0) {
                jsonGenerator.a("projection_type");
                jsonGenerator.b(mutableFlatBuffer.c(i, 53));
            }
            g = mutableFlatBuffer.g(i, 54);
            if (g != 0) {
                jsonGenerator.a("publisher_context");
                DefaultTextWithEntitiesFieldsParser.m9835a(mutableFlatBuffer, g, jsonGenerator);
            }
            a = mutableFlatBuffer.a(i, 55);
            if (a) {
                jsonGenerator.a("should_open_single_publisher");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 56);
            if (a) {
                jsonGenerator.a("should_show_live_subscribe");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 57);
            if (a) {
                jsonGenerator.a("show_video_channel_subscribe_button");
                jsonGenerator.a(a);
            }
            a = mutableFlatBuffer.a(i, 58);
            if (a) {
                jsonGenerator.a("show_video_home_follow_button");
                jsonGenerator.a(a);
            }
            double a3 = mutableFlatBuffer.a(i, 59, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalFullscreenAspectRatio");
                jsonGenerator.a(a3);
            }
            a3 = mutableFlatBuffer.a(i, 60, 0.0d);
            if (a3 != 0.0d) {
                jsonGenerator.a("sphericalInlineAspectRatio");
                jsonGenerator.a(a3);
            }
            if (mutableFlatBuffer.g(i, 61) != 0) {
                jsonGenerator.a("sphericalPlayableUrlHdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 61));
            }
            if (mutableFlatBuffer.g(i, 62) != 0) {
                jsonGenerator.a("sphericalPlayableUrlSdString");
                jsonGenerator.b(mutableFlatBuffer.c(i, 62));
            }
            g = mutableFlatBuffer.a(i, 63, 0);
            if (g != 0) {
                jsonGenerator.a("sphericalPreferredFov");
                jsonGenerator.b(g);
            }
            a = mutableFlatBuffer.a(i, 64);
            if (a) {
                jsonGenerator.a("supports_time_slices");
                jsonGenerator.a(a);
            }
            g = mutableFlatBuffer.a(i, 65, 0);
            if (g != 0) {
                jsonGenerator.a("total_posts");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 66) != 0) {
                jsonGenerator.a("video_captions_locales");
                SerializerHelpers.a(mutableFlatBuffer.f(i, 66), jsonGenerator);
            }
            g = mutableFlatBuffer.g(i, 67);
            if (g != 0) {
                jsonGenerator.a("video_channel");
                VideoChannelParser.m16874a(mutableFlatBuffer, g, jsonGenerator);
            }
            g = mutableFlatBuffer.a(i, 68, 0);
            if (g != 0) {
                jsonGenerator.a("video_full_size");
                jsonGenerator.b(g);
            }
            if (mutableFlatBuffer.g(i, 69) != 0) {
                jsonGenerator.a("video_status_type");
                jsonGenerator.b(mutableFlatBuffer.b(i, 69));
            }
            g = mutableFlatBuffer.a(i, 70, 0);
            if (g != 0) {
                jsonGenerator.a("width");
                jsonGenerator.b(g);
            }
            jsonGenerator.g();
        }
    }

    /* compiled from: api_error_response */
    public final class Photo360FieldsParser {

        /* compiled from: api_error_response */
        public final class PhotoEncodingsParser {

            /* compiled from: api_error_response */
            public final class SphericalMetadataParser {
                public static int m16068a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    boolean[] zArr = new boolean[10];
                    int[] iArr = new int[6];
                    double[] dArr = new double[4];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("cropped_area_image_height_pixels")) {
                                zArr[0] = true;
                                iArr[0] = jsonParser.E();
                            } else if (i.equals("cropped_area_image_width_pixels")) {
                                zArr[1] = true;
                                iArr[1] = jsonParser.E();
                            } else if (i.equals("cropped_area_left_pixels")) {
                                zArr[2] = true;
                                iArr[2] = jsonParser.E();
                            } else if (i.equals("cropped_area_top_pixels")) {
                                zArr[3] = true;
                                iArr[3] = jsonParser.E();
                            } else if (i.equals("full_pano_height_pixels")) {
                                zArr[4] = true;
                                iArr[4] = jsonParser.E();
                            } else if (i.equals("full_pano_width_pixels")) {
                                zArr[5] = true;
                                iArr[5] = jsonParser.E();
                            } else if (i.equals("initial_view_heading_degrees")) {
                                zArr[6] = true;
                                dArr[0] = jsonParser.G();
                            } else if (i.equals("initial_view_pitch_degrees")) {
                                zArr[7] = true;
                                dArr[1] = jsonParser.G();
                            } else if (i.equals("initial_view_roll_degrees")) {
                                zArr[8] = true;
                                dArr[2] = jsonParser.G();
                            } else if (i.equals("initial_view_vertical_fov_degrees")) {
                                zArr[9] = true;
                                dArr[3] = jsonParser.G();
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(10);
                    if (zArr[0]) {
                        flatBufferBuilder.a(0, iArr[0], 0);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(1, iArr[1], 0);
                    }
                    if (zArr[2]) {
                        flatBufferBuilder.a(2, iArr[2], 0);
                    }
                    if (zArr[3]) {
                        flatBufferBuilder.a(3, iArr[3], 0);
                    }
                    if (zArr[4]) {
                        flatBufferBuilder.a(4, iArr[4], 0);
                    }
                    if (zArr[5]) {
                        flatBufferBuilder.a(5, iArr[5], 0);
                    }
                    if (zArr[6]) {
                        flatBufferBuilder.a(6, dArr[0], 0.0d);
                    }
                    if (zArr[7]) {
                        flatBufferBuilder.a(7, dArr[1], 0.0d);
                    }
                    if (zArr[8]) {
                        flatBufferBuilder.a(8, dArr[2], 0.0d);
                    }
                    if (zArr[9]) {
                        flatBufferBuilder.a(9, dArr[3], 0.0d);
                    }
                    return flatBufferBuilder.d();
                }

                public static void m16069a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    int a = mutableFlatBuffer.a(i, 0, 0);
                    if (a != 0) {
                        jsonGenerator.a("cropped_area_image_height_pixels");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 1, 0);
                    if (a != 0) {
                        jsonGenerator.a("cropped_area_image_width_pixels");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 2, 0);
                    if (a != 0) {
                        jsonGenerator.a("cropped_area_left_pixels");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 3, 0);
                    if (a != 0) {
                        jsonGenerator.a("cropped_area_top_pixels");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 4, 0);
                    if (a != 0) {
                        jsonGenerator.a("full_pano_height_pixels");
                        jsonGenerator.b(a);
                    }
                    a = mutableFlatBuffer.a(i, 5, 0);
                    if (a != 0) {
                        jsonGenerator.a("full_pano_width_pixels");
                        jsonGenerator.b(a);
                    }
                    double a2 = mutableFlatBuffer.a(i, 6, 0.0d);
                    if (a2 != 0.0d) {
                        jsonGenerator.a("initial_view_heading_degrees");
                        jsonGenerator.a(a2);
                    }
                    a2 = mutableFlatBuffer.a(i, 7, 0.0d);
                    if (a2 != 0.0d) {
                        jsonGenerator.a("initial_view_pitch_degrees");
                        jsonGenerator.a(a2);
                    }
                    a2 = mutableFlatBuffer.a(i, 8, 0.0d);
                    if (a2 != 0.0d) {
                        jsonGenerator.a("initial_view_roll_degrees");
                        jsonGenerator.a(a2);
                    }
                    a2 = mutableFlatBuffer.a(i, 9, 0.0d);
                    if (a2 != 0.0d) {
                        jsonGenerator.a("initial_view_vertical_fov_degrees");
                        jsonGenerator.a(a2);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m16072b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[5];
                boolean[] zArr = new boolean[1];
                int[] iArr2 = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("cdn_uri")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("id")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("projection_type")) {
                            iArr[2] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("spherical_metadata")) {
                            iArr[3] = SphericalMetadataParser.m16068a(jsonParser, flatBufferBuilder);
                        } else if (i.equals("width")) {
                            zArr[0] = true;
                            iArr2[0] = jsonParser.E();
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
                if (zArr[0]) {
                    flatBufferBuilder.a(4, iArr2[0], 0);
                }
                return flatBufferBuilder.d();
            }

            public static int m16070a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                ArrayList arrayList = new ArrayList();
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        arrayList.add(Integer.valueOf(m16072b(jsonParser, flatBufferBuilder)));
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

            public static void m16071a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.d();
                for (int i2 = 0; i2 < mutableFlatBuffer.c(i); i2++) {
                    m16073b(mutableFlatBuffer, mutableFlatBuffer.m(i, i2), jsonGenerator, serializerProvider);
                }
                jsonGenerator.e();
            }

            public static void m16073b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("cdn_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                if (mutableFlatBuffer.g(i, 2) != 0) {
                    jsonGenerator.a("projection_type");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 2));
                }
                int g = mutableFlatBuffer.g(i, 3);
                if (g != 0) {
                    jsonGenerator.a("spherical_metadata");
                    SphericalMetadataParser.m16069a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(i, 4, 0);
                if (g != 0) {
                    jsonGenerator.a("width");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m16074a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[2];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("photo_encodings")) {
                        iArr[1] = PhotoEncodingsParser.m16070a(jsonParser, flatBufferBuilder);
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
}
