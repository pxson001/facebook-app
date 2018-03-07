package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: knowledge_value */
public final class GraphQLAdditionalSuggestedPostAdItemsEdge__JsonHelper {
    public static GraphQLAdditionalSuggestedPostAdItemsEdge m6462a(JsonParser jsonParser) {
        GraphQLAdditionalSuggestedPostAdItemsEdge graphQLAdditionalSuggestedPostAdItemsEdge = new GraphQLAdditionalSuggestedPostAdItemsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLStorySetItem graphQLStorySetItem;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLStorySetItem = null;
                } else {
                    graphQLStorySetItem = GraphQLStorySetItem__JsonHelper.m21903a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLAdditionalSuggestedPostAdItemsEdge.f3306d = graphQLStorySetItem;
                FieldAccessQueryTracker.a(jsonParser, graphQLAdditionalSuggestedPostAdItemsEdge, "node", graphQLAdditionalSuggestedPostAdItemsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLAdditionalSuggestedPostAdItemsEdge;
    }

    public static void m6463a(JsonGenerator jsonGenerator, GraphQLAdditionalSuggestedPostAdItemsEdge graphQLAdditionalSuggestedPostAdItemsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAdditionalSuggestedPostAdItemsEdge.m6458a() != null) {
            jsonGenerator.a("node");
            GraphQLStorySetItem__JsonHelper.m21904a(jsonGenerator, graphQLAdditionalSuggestedPostAdItemsEdge.m6458a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
