package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WORK_PROJECT */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge__JsonHelper {
    public static GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge m20629a(JsonParser jsonParser) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge = new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20631a(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge;
    }

    private static boolean m20631a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("node".equals(str)) {
            GraphQLUser a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, "node", graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.a_, 0, true);
            return true;
        } else if ("social_context".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, "social_context", graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.B_(), 1, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, "tracking", graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m20630a(JsonGenerator jsonGenerator, GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m() != null) {
            jsonGenerator.a("node");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.m(), true);
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.n() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.n(), true);
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.k() != null) {
            jsonGenerator.a("tracking", graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
