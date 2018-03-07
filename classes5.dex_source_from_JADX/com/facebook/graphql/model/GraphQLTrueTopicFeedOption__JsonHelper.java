package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Transcode to Png invoked when isAvailable() returns false */
public final class GraphQLTrueTopicFeedOption__JsonHelper {
    public static GraphQLTrueTopicFeedOption m22319a(JsonParser jsonParser) {
        GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption = new GraphQLTrueTopicFeedOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("icon_dominant_color".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrueTopicFeedOption.f13366d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOption, "icon_dominant_color", graphQLTrueTopicFeedOption.a_, 0, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrueTopicFeedOption.f13367e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOption, "id", graphQLTrueTopicFeedOption.a_, 1, false);
            } else if ("is_checked".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLTrueTopicFeedOption.f13368f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOption, "is_checked", graphQLTrueTopicFeedOption.a_, 2, false);
            } else if ("option_icon".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "option_icon"));
                }
                graphQLTrueTopicFeedOption.f13369g = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOption, "option_icon", graphQLTrueTopicFeedOption.a_, 3, true);
            } else if ("topic_feed_option".equals(i)) {
                GraphQLTopicFeedOption graphQLTopicFeedOption;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTopicFeedOption = null;
                } else {
                    graphQLTopicFeedOption = GraphQLTopicFeedOption__JsonHelper.m22275a(FieldAccessQueryTracker.a(jsonParser, "topic_feed_option"));
                }
                graphQLTrueTopicFeedOption.f13370h = graphQLTopicFeedOption;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOption, "topic_feed_option", graphQLTrueTopicFeedOption.a_, 4, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTrueTopicFeedOption.f13371i = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOption, "url", graphQLTrueTopicFeedOption.a_, 5, false);
            }
            jsonParser.f();
        }
        return graphQLTrueTopicFeedOption;
    }

    public static void m22320a(JsonGenerator jsonGenerator, GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTrueTopicFeedOption.m22311j() != null) {
            jsonGenerator.a("icon_dominant_color", graphQLTrueTopicFeedOption.m22311j());
        }
        if (graphQLTrueTopicFeedOption.m22312k() != null) {
            jsonGenerator.a("id", graphQLTrueTopicFeedOption.m22312k());
        }
        jsonGenerator.a("is_checked", graphQLTrueTopicFeedOption.m22313l());
        if (graphQLTrueTopicFeedOption.m22314m() != null) {
            jsonGenerator.a("option_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTrueTopicFeedOption.m22314m(), true);
        }
        if (graphQLTrueTopicFeedOption.m22315n() != null) {
            jsonGenerator.a("topic_feed_option");
            GraphQLTopicFeedOption__JsonHelper.m22276a(jsonGenerator, graphQLTrueTopicFeedOption.m22315n(), true);
        }
        if (graphQLTrueTopicFeedOption.m22316o() != null) {
            jsonGenerator.a("url", graphQLTrueTopicFeedOption.m22316o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
