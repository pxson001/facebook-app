package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Thread Settings */
public final class GraphQLVideoChannel__JsonHelper {
    public static GraphQLVideoChannel m22446a(JsonParser jsonParser) {
        GraphQLVideoChannel graphQLVideoChannel = new GraphQLVideoChannel();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLVideoChannel.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "__type__", graphQLVideoChannel.a_, 0, false);
            } else if ("id".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLVideoChannel.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "id", graphQLVideoChannel.a_, 1, false);
            } else if ("live_video_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLVideoChannel.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "live_video_count", graphQLVideoChannel.a_, 2, false);
            } else if ("square_header_image".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "square_header_image"));
                }
                graphQLVideoChannel.g = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "square_header_image", graphQLVideoChannel.a_, 3, true);
            } else if ("video_channel_can_viewer_follow".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_can_viewer_follow", graphQLVideoChannel.a_, 4, false);
            } else if ("video_channel_can_viewer_pin".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_can_viewer_pin", graphQLVideoChannel.a_, 5, false);
            } else if ("video_channel_can_viewer_subscribe".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_can_viewer_subscribe", graphQLVideoChannel.a_, 6, false);
            } else if ("video_channel_curator_profile".equals(i)) {
                GraphQLProfile graphQLProfile;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLProfile = null;
                } else {
                    graphQLProfile = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "video_channel_curator_profile"));
                }
                graphQLVideoChannel.k = graphQLProfile;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_curator_profile", graphQLVideoChannel.a_, 7, true);
            } else if ("video_channel_has_new".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.l = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_has_new", graphQLVideoChannel.a_, 8, false);
            } else if ("video_channel_has_viewer_subscribed".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.m = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_has_viewer_subscribed", graphQLVideoChannel.a_, 9, false);
            } else if ("video_channel_is_viewer_following".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_is_viewer_following", graphQLVideoChannel.a_, 10, false);
            } else if ("video_channel_is_viewer_pinned".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLVideoChannel.o = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_is_viewer_pinned", graphQLVideoChannel.a_, 11, false);
            } else if ("video_channel_max_new_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLVideoChannel.p = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_max_new_count", graphQLVideoChannel.a_, 12, false);
            } else if ("video_channel_new_count".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = 0;
                } else {
                    r3 = jsonParser.E();
                }
                graphQLVideoChannel.q = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_new_count", graphQLVideoChannel.a_, 13, false);
            } else if ("video_channel_subtitle".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_subtitle"));
                }
                graphQLVideoChannel.r = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_subtitle", graphQLVideoChannel.a_, 14, true);
            } else if ("video_channel_title".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_title"));
                }
                graphQLVideoChannel.s = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "video_channel_title", graphQLVideoChannel.a_, 15, true);
            } else if ("page_likers".equals(i)) {
                GraphQLPageLikersConnection graphQLPageLikersConnection;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPageLikersConnection = null;
                } else {
                    graphQLPageLikersConnection = GraphQLPageLikersConnection__JsonHelper.m9494a(FieldAccessQueryTracker.a(jsonParser, "page_likers"));
                }
                graphQLVideoChannel.t = graphQLPageLikersConnection;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "page_likers", graphQLVideoChannel.a_, 16, true);
            } else if ("subscribe_status".equals(i)) {
                graphQLVideoChannel.u = GraphQLSubscribeStatus.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannel, "subscribe_status", graphQLVideoChannel.a_, 17, false);
            }
            jsonParser.f();
        }
        return graphQLVideoChannel;
    }

    public static void m22447a(JsonGenerator jsonGenerator, GraphQLVideoChannel graphQLVideoChannel, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLVideoChannel.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLVideoChannel.j().e());
            jsonGenerator.g();
        }
        if (graphQLVideoChannel.k() != null) {
            jsonGenerator.a("id", graphQLVideoChannel.k());
        }
        jsonGenerator.a("live_video_count", graphQLVideoChannel.l());
        if (graphQLVideoChannel.m() != null) {
            jsonGenerator.a("square_header_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLVideoChannel.m(), true);
        }
        jsonGenerator.a("video_channel_can_viewer_follow", graphQLVideoChannel.n());
        jsonGenerator.a("video_channel_can_viewer_pin", graphQLVideoChannel.o());
        jsonGenerator.a("video_channel_can_viewer_subscribe", graphQLVideoChannel.p());
        if (graphQLVideoChannel.q() != null) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLVideoChannel.q(), true);
        }
        jsonGenerator.a("video_channel_has_new", graphQLVideoChannel.r());
        jsonGenerator.a("video_channel_has_viewer_subscribed", graphQLVideoChannel.s());
        jsonGenerator.a("video_channel_is_viewer_following", graphQLVideoChannel.t());
        jsonGenerator.a("video_channel_is_viewer_pinned", graphQLVideoChannel.u());
        jsonGenerator.a("video_channel_max_new_count", graphQLVideoChannel.v());
        jsonGenerator.a("video_channel_new_count", graphQLVideoChannel.w());
        if (graphQLVideoChannel.x() != null) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideoChannel.x(), true);
        }
        if (graphQLVideoChannel.y() != null) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideoChannel.y(), true);
        }
        if (graphQLVideoChannel.z() != null) {
            jsonGenerator.a("page_likers");
            GraphQLPageLikersConnection__JsonHelper.m9495a(jsonGenerator, graphQLVideoChannel.z(), true);
        }
        if (graphQLVideoChannel.A() != null) {
            jsonGenerator.a("subscribe_status", graphQLVideoChannel.A().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
