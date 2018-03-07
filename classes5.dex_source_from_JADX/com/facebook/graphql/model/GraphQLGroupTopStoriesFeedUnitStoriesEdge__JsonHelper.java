package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: free_photos */
public final class GraphQLGroupTopStoriesFeedUnitStoriesEdge__JsonHelper {
    public static GraphQLGroupTopStoriesFeedUnitStoriesEdge m8515a(JsonParser jsonParser) {
        GraphQLGroupTopStoriesFeedUnitStoriesEdge graphQLGroupTopStoriesFeedUnitStoriesEdge = new GraphQLGroupTopStoriesFeedUnitStoriesEdge();
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
                graphQLGroupTopStoriesFeedUnitStoriesEdge.f4210d = graphQLStory;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnitStoriesEdge, "node", graphQLGroupTopStoriesFeedUnitStoriesEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGroupTopStoriesFeedUnitStoriesEdge;
    }

    public static void m8516a(JsonGenerator jsonGenerator, GraphQLGroupTopStoriesFeedUnitStoriesEdge graphQLGroupTopStoriesFeedUnitStoriesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroupTopStoriesFeedUnitStoriesEdge.m8512j() != null) {
            jsonGenerator.a("node");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLGroupTopStoriesFeedUnitStoriesEdge.m8512j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
