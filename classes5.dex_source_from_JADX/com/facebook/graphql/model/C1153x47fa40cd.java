package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WRITE_CREATE_DIR */
public final class C1153x47fa40cd {
    public static GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge m20606a(JsonParser jsonParser) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge = new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            C1153x47fa40cd.m20608a(graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge;
    }

    private static boolean m20608a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("node".equals(str)) {
            GraphQLGroup a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGroup__JsonHelper.m8518a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.f12421d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge, "node", graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.a_, 0, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.f12422e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge, "tracking", graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.B_(), 1, false);
            return true;
        }
    }

    public static void m20607a(JsonGenerator jsonGenerator, GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.m20603l() != null) {
            jsonGenerator.a("node");
            GraphQLGroup__JsonHelper.m8519a(jsonGenerator, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.m20603l(), true);
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.m20602k() != null) {
            jsonGenerator.a("tracking", graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge.m20602k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
