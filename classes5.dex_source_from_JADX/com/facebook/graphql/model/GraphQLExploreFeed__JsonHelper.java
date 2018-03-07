package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: idType can not be null */
public final class GraphQLExploreFeed__JsonHelper {
    public static GraphQLExploreFeed m7404a(JsonParser jsonParser) {
        GraphQLExploreFeed graphQLExploreFeed = new GraphQLExploreFeed();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7406a(graphQLExploreFeed, i, jsonParser);
            jsonParser.f();
        }
        return graphQLExploreFeed;
    }

    private static boolean m7406a(GraphQLExploreFeed graphQLExploreFeed, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("customizable".equals(str)) {
            boolean z;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                z = false;
            } else {
                z = jsonParser.H();
            }
            graphQLExploreFeed.f3713d = z;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "customizable", graphQLExploreFeed.a_, 0, false);
            return true;
        } else if ("disabled_favorite_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "disabled_favorite_icon"));
            }
            graphQLExploreFeed.f3714e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "disabled_favorite_icon", graphQLExploreFeed.B_(), 1, true);
            return true;
        } else if ("enabled_favorite_icon".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "enabled_favorite_icon"));
            }
            graphQLExploreFeed.f3715f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "enabled_favorite_icon", graphQLExploreFeed.B_(), 2, true);
            return true;
        } else if ("header_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "header_image"));
            }
            graphQLExploreFeed.f3716g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "header_image", graphQLExploreFeed.B_(), 3, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLExploreFeed.f3717h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "id", graphQLExploreFeed.B_(), 5, false);
            return true;
        } else if ("is_favorited".equals(str)) {
            graphQLExploreFeed.f3718i = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "is_favorited", graphQLExploreFeed.B_(), 6, false);
            return true;
        } else if ("live_video_count".equals(str)) {
            graphQLExploreFeed.f3719j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "live_video_count", graphQLExploreFeed.B_(), 7, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLExploreFeed.f3720k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "name", graphQLExploreFeed.B_(), 8, false);
            return true;
        } else if ("searchable".equals(str)) {
            graphQLExploreFeed.f3721l = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "searchable", graphQLExploreFeed.B_(), 9, false);
            return true;
        } else if ("square_header_image".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "square_header_image"));
            }
            graphQLExploreFeed.f3722m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "square_header_image", graphQLExploreFeed.B_(), 10, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLExploreFeed.f3723n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "url", graphQLExploreFeed.B_(), 11, false);
            return true;
        } else if ("video_channel_can_viewer_follow".equals(str)) {
            graphQLExploreFeed.f3724o = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_can_viewer_follow", graphQLExploreFeed.B_(), 12, false);
            return true;
        } else if ("video_channel_can_viewer_pin".equals(str)) {
            graphQLExploreFeed.f3725p = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_can_viewer_pin", graphQLExploreFeed.B_(), 13, false);
            return true;
        } else if ("video_channel_can_viewer_subscribe".equals(str)) {
            graphQLExploreFeed.f3726q = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_can_viewer_subscribe", graphQLExploreFeed.B_(), 14, false);
            return true;
        } else if ("video_channel_curator_profile".equals(str)) {
            GraphQLProfile a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "video_channel_curator_profile"));
            }
            graphQLExploreFeed.f3727r = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_curator_profile", graphQLExploreFeed.B_(), 15, true);
            return true;
        } else if ("video_channel_has_new".equals(str)) {
            graphQLExploreFeed.f3728s = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_has_new", graphQLExploreFeed.B_(), 16, false);
            return true;
        } else if ("video_channel_has_viewer_subscribed".equals(str)) {
            graphQLExploreFeed.f3729t = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_has_viewer_subscribed", graphQLExploreFeed.B_(), 17, false);
            return true;
        } else if ("video_channel_is_viewer_following".equals(str)) {
            graphQLExploreFeed.f3730u = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_is_viewer_following", graphQLExploreFeed.B_(), 18, false);
            return true;
        } else if ("video_channel_is_viewer_pinned".equals(str)) {
            graphQLExploreFeed.f3731v = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_is_viewer_pinned", graphQLExploreFeed.B_(), 19, false);
            return true;
        } else if ("video_channel_max_new_count".equals(str)) {
            graphQLExploreFeed.f3732w = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_max_new_count", graphQLExploreFeed.B_(), 20, false);
            return true;
        } else if ("video_channel_new_count".equals(str)) {
            graphQLExploreFeed.f3733x = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_new_count", graphQLExploreFeed.B_(), 21, false);
            return true;
        } else if ("video_channel_subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_subtitle"));
            }
            graphQLExploreFeed.f3734y = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_subtitle", graphQLExploreFeed.B_(), 22, true);
            return true;
        } else if ("video_channel_title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "video_channel_title"));
            }
            graphQLExploreFeed.f3735z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "video_channel_title", graphQLExploreFeed.B_(), 23, true);
            return true;
        } else if (!"composer_placeholder_text".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLExploreFeed.f3712A = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLExploreFeed, "composer_placeholder_text", graphQLExploreFeed.B_(), 24, false);
            return true;
        }
    }

    public static void m7405a(JsonGenerator jsonGenerator, GraphQLExploreFeed graphQLExploreFeed, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("customizable", graphQLExploreFeed.m7385j());
        if (graphQLExploreFeed.m7386k() != null) {
            jsonGenerator.a("disabled_favorite_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLExploreFeed.m7386k(), true);
        }
        if (graphQLExploreFeed.m7387l() != null) {
            jsonGenerator.a("enabled_favorite_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLExploreFeed.m7387l(), true);
        }
        if (graphQLExploreFeed.m7388m() != null) {
            jsonGenerator.a("header_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLExploreFeed.m7388m(), true);
        }
        if (graphQLExploreFeed.m7389n() != null) {
            jsonGenerator.a("id", graphQLExploreFeed.m7389n());
        }
        jsonGenerator.a("is_favorited", graphQLExploreFeed.m7390o());
        jsonGenerator.a("live_video_count", graphQLExploreFeed.m7391p());
        if (graphQLExploreFeed.m7392q() != null) {
            jsonGenerator.a("name", graphQLExploreFeed.m7392q());
        }
        jsonGenerator.a("searchable", graphQLExploreFeed.m7393r());
        if (graphQLExploreFeed.m7394s() != null) {
            jsonGenerator.a("square_header_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLExploreFeed.m7394s(), true);
        }
        if (graphQLExploreFeed.m7395t() != null) {
            jsonGenerator.a("url", graphQLExploreFeed.m7395t());
        }
        jsonGenerator.a("video_channel_can_viewer_follow", graphQLExploreFeed.m7396u());
        jsonGenerator.a("video_channel_can_viewer_pin", graphQLExploreFeed.m7397v());
        jsonGenerator.a("video_channel_can_viewer_subscribe", graphQLExploreFeed.m7398w());
        if (graphQLExploreFeed.m7399x() != null) {
            jsonGenerator.a("video_channel_curator_profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLExploreFeed.m7399x(), true);
        }
        jsonGenerator.a("video_channel_has_new", graphQLExploreFeed.m7400y());
        jsonGenerator.a("video_channel_has_viewer_subscribed", graphQLExploreFeed.m7401z());
        jsonGenerator.a("video_channel_is_viewer_following", graphQLExploreFeed.m7372A());
        jsonGenerator.a("video_channel_is_viewer_pinned", graphQLExploreFeed.m7373B());
        jsonGenerator.a("video_channel_max_new_count", graphQLExploreFeed.m7374C());
        jsonGenerator.a("video_channel_new_count", graphQLExploreFeed.m7375D());
        if (graphQLExploreFeed.m7376E() != null) {
            jsonGenerator.a("video_channel_subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExploreFeed.m7376E(), true);
        }
        if (graphQLExploreFeed.m7377F() != null) {
            jsonGenerator.a("video_channel_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLExploreFeed.m7377F(), true);
        }
        if (graphQLExploreFeed.m7378G() != null) {
            jsonGenerator.a("composer_placeholder_text", graphQLExploreFeed.m7378G());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
