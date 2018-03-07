package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEOS */
public final class GraphQLSaleGroupsNearYouFeedUnitGroupsEdge__JsonHelper {
    public static GraphQLSaleGroupsNearYouFeedUnitGroupsEdge m21527a(JsonParser jsonParser) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = new GraphQLSaleGroupsNearYouFeedUnitGroupsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21529a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSaleGroupsNearYouFeedUnitGroupsEdge;
    }

    private static boolean m21529a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("node".equals(str)) {
            GraphQLGroup a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGroup__JsonHelper.m8518a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLSaleGroupsNearYouFeedUnitGroupsEdge.f12953d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnitGroupsEdge, "node", graphQLSaleGroupsNearYouFeedUnitGroupsEdge.a_, 0, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnitGroupsEdge.f12954e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnitGroupsEdge, "tracking", graphQLSaleGroupsNearYouFeedUnitGroupsEdge.B_(), 1, false);
            return true;
        }
    }

    public static void m21528a(JsonGenerator jsonGenerator, GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSaleGroupsNearYouFeedUnitGroupsEdge.m21523j() != null) {
            jsonGenerator.a("node");
            GraphQLGroup__JsonHelper.m8519a(jsonGenerator, graphQLSaleGroupsNearYouFeedUnitGroupsEdge.m21523j(), true);
        }
        if (graphQLSaleGroupsNearYouFeedUnitGroupsEdge.m21524k() != null) {
            jsonGenerator.a("tracking", graphQLSaleGroupsNearYouFeedUnitGroupsEdge.m21524k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
