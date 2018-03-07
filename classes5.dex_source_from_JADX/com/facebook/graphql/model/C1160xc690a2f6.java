package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WORK_STATUS */
public final class C1160xc690a2f6 {
    public static GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection m20623a(JsonParser jsonParser) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection = new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge a = GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge__JsonHelper.m20629a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection, "edges", graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection, "page_info", graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
    }

    public static void m20624a(JsonGenerator jsonGenerator, GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge : graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.a()) {
                if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge != null) {
                    GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge__JsonHelper.m20630a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
