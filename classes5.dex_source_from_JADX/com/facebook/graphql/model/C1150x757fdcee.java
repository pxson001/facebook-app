package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WRITE_GROUP_DESCRIPTION */
public final class C1150x757fdcee {
    public static GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection m20594a(JsonParser jsonParser) {
        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection = new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection();
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
                        GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge a = C1153x47fa40cd.m20606a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection, "edges", graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection, "page_info", graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection;
    }

    public static void m20595a(JsonGenerator jsonGenerator, GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge : graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.a()) {
                if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge != null) {
                    C1153x47fa40cd.m20607a(jsonGenerator, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
