package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TaggableActivity */
public final class GraphQLWorkCommunityTrendingFeedUnitItem__JsonHelper {
    public static GraphQLWorkCommunityTrendingFeedUnitItem m22513a(JsonParser jsonParser) {
        GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem = new GraphQLWorkCommunityTrendingFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22515a(graphQLWorkCommunityTrendingFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLWorkCommunityTrendingFeedUnitItem;
    }

    private static boolean m22515a(GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("story".equals(str)) {
            GraphQLStory a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "story"));
            }
            graphQLWorkCommunityTrendingFeedUnitItem.f13457d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnitItem, "story", graphQLWorkCommunityTrendingFeedUnitItem.a_, 0, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLWorkCommunityTrendingFeedUnitItem.f13458e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLWorkCommunityTrendingFeedUnitItem, "title", graphQLWorkCommunityTrendingFeedUnitItem.B_(), 1, false);
            return true;
        }
    }

    public static void m22514a(JsonGenerator jsonGenerator, GraphQLWorkCommunityTrendingFeedUnitItem graphQLWorkCommunityTrendingFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLWorkCommunityTrendingFeedUnitItem.m22509j() != null) {
            jsonGenerator.a("story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLWorkCommunityTrendingFeedUnitItem.m22509j(), true);
        }
        if (graphQLWorkCommunityTrendingFeedUnitItem.m22510k() != null) {
            jsonGenerator.a("title", graphQLWorkCommunityTrendingFeedUnitItem.m22510k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
