package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: emotional_analysis */
public final class GraphQLPageStoriesYouMissedFeedUnitStoriesEdge__JsonHelper {
    public static GraphQLPageStoriesYouMissedFeedUnitStoriesEdge m9544a(JsonParser jsonParser) {
        GraphQLPageStoriesYouMissedFeedUnitStoriesEdge graphQLPageStoriesYouMissedFeedUnitStoriesEdge = new GraphQLPageStoriesYouMissedFeedUnitStoriesEdge();
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
                graphQLPageStoriesYouMissedFeedUnitStoriesEdge.f4758d = graphQLStory;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnitStoriesEdge, "node", graphQLPageStoriesYouMissedFeedUnitStoriesEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPageStoriesYouMissedFeedUnitStoriesEdge;
    }

    public static void m9545a(JsonGenerator jsonGenerator, GraphQLPageStoriesYouMissedFeedUnitStoriesEdge graphQLPageStoriesYouMissedFeedUnitStoriesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPageStoriesYouMissedFeedUnitStoriesEdge.m9540a() != null) {
            jsonGenerator.a("node");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLPageStoriesYouMissedFeedUnitStoriesEdge.m9540a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
