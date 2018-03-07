package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VENDING_MACHINE_SERVICE */
public final class GraphQLSideFeedEdge__JsonHelper {
    public static GraphQLSideFeedEdge m21646a(JsonParser jsonParser) {
        GraphQLSideFeedEdge graphQLSideFeedEdge = new GraphQLSideFeedEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLSideFeedUnit graphQLSideFeedUnit;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLSideFeedUnit = null;
                } else {
                    graphQLSideFeedUnit = GraphQLSideFeedUnit__JsonHelper.m21656a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLSideFeedEdge.f13020d = graphQLSideFeedUnit;
                FieldAccessQueryTracker.a(jsonParser, graphQLSideFeedEdge, "node", graphQLSideFeedEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSideFeedEdge;
    }

    public static void m21647a(JsonGenerator jsonGenerator, GraphQLSideFeedEdge graphQLSideFeedEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSideFeedEdge.m21642a() != null) {
            jsonGenerator.a("node");
            GraphQLSideFeedUnit__JsonHelper.m21657a(jsonGenerator, graphQLSideFeedEdge.m21642a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
