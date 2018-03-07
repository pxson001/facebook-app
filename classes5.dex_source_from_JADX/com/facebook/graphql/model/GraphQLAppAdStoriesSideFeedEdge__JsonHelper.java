package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: item_price */
public final class GraphQLAppAdStoriesSideFeedEdge__JsonHelper {
    public static GraphQLAppAdStoriesSideFeedEdge m6558a(JsonParser jsonParser) {
        GraphQLAppAdStoriesSideFeedEdge graphQLAppAdStoriesSideFeedEdge = new GraphQLAppAdStoriesSideFeedEdge();
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
                graphQLAppAdStoriesSideFeedEdge.f3347d = graphQLStory;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppAdStoriesSideFeedEdge, "node", graphQLAppAdStoriesSideFeedEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLAppAdStoriesSideFeedEdge;
    }

    public static void m6559a(JsonGenerator jsonGenerator, GraphQLAppAdStoriesSideFeedEdge graphQLAppAdStoriesSideFeedEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLAppAdStoriesSideFeedEdge.m6554a() != null) {
            jsonGenerator.a("node");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLAppAdStoriesSideFeedEdge.m6554a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
