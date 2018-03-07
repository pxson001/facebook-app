package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VIDEOS_PYML */
public final class GraphQLSaleGroupsNearYouFeedUnitGroupsConnection__JsonHelper {
    public static GraphQLSaleGroupsNearYouFeedUnitGroupsConnection m21517a(JsonParser jsonParser) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection = new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection();
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
                        GraphQLSaleGroupsNearYouFeedUnitGroupsEdge a = GraphQLSaleGroupsNearYouFeedUnitGroupsEdge__JsonHelper.m21527a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLSaleGroupsNearYouFeedUnitGroupsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnitGroupsConnection, "edges", graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLSaleGroupsNearYouFeedUnitGroupsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnitGroupsConnection, "page_info", graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSaleGroupsNearYouFeedUnitGroupsConnection;
    }

    public static void m21518a(JsonGenerator jsonGenerator, GraphQLSaleGroupsNearYouFeedUnitGroupsConnection graphQLSaleGroupsNearYouFeedUnitGroupsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge : graphQLSaleGroupsNearYouFeedUnitGroupsConnection.a()) {
                if (graphQLSaleGroupsNearYouFeedUnitGroupsEdge != null) {
                    GraphQLSaleGroupsNearYouFeedUnitGroupsEdge__JsonHelper.m21528a(jsonGenerator, graphQLSaleGroupsNearYouFeedUnitGroupsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSaleGroupsNearYouFeedUnitGroupsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLSaleGroupsNearYouFeedUnitGroupsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
