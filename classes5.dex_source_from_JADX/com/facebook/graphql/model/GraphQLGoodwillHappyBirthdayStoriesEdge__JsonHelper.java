package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: graphStoryDelete */
public final class GraphQLGoodwillHappyBirthdayStoriesEdge__JsonHelper {
    public static GraphQLGoodwillHappyBirthdayStoriesEdge m7907a(JsonParser jsonParser) {
        GraphQLGoodwillHappyBirthdayStoriesEdge graphQLGoodwillHappyBirthdayStoriesEdge = new GraphQLGoodwillHappyBirthdayStoriesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLStory graphQLStory;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLStory = null;
                } else {
                    graphQLStory = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLGoodwillHappyBirthdayStoriesEdge.f3923d = graphQLStory;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayStoriesEdge, "node", graphQLGoodwillHappyBirthdayStoriesEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillHappyBirthdayStoriesEdge;
    }

    public static void m7908a(JsonGenerator jsonGenerator, GraphQLGoodwillHappyBirthdayStoriesEdge graphQLGoodwillHappyBirthdayStoriesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillHappyBirthdayStoriesEdge.m7903a() != null) {
            jsonGenerator.a("node");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLGoodwillHappyBirthdayStoriesEdge.m7903a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
