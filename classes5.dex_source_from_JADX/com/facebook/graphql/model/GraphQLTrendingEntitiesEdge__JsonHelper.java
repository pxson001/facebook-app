package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TrendingTopicData */
public final class GraphQLTrendingEntitiesEdge__JsonHelper {
    public static boolean m22296a(GraphQLTrendingEntitiesEdge graphQLTrendingEntitiesEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("node".equals(str)) {
            GraphQLProfile a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLTrendingEntitiesEdge.f13362d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTrendingEntitiesEdge, "node", graphQLTrendingEntitiesEdge.a_, 0, true);
            return true;
        } else if ("promote_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTrendingEntitiesEdge.f13363e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTrendingEntitiesEdge, "promote_text", graphQLTrendingEntitiesEdge.B_(), 1, false);
            return true;
        } else if ("query".equals(str)) {
            GraphQLGraphSearchQuery a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGraphSearchQuery__JsonHelper.m8265a(FieldAccessQueryTracker.a(jsonParser, "query"));
            }
            graphQLTrendingEntitiesEdge.f13364f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTrendingEntitiesEdge, "query", graphQLTrendingEntitiesEdge.B_(), 2, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTrendingEntitiesEdge.f13365g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTrendingEntitiesEdge, "tracking", graphQLTrendingEntitiesEdge.B_(), 3, false);
            return true;
        }
    }
}
