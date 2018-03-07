package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friendEventInvitees */
public final class GraphQLGroupTopStoriesFeedUnitStoriesConnection__JsonHelper {
    public static GraphQLGroupTopStoriesFeedUnitStoriesConnection m8506a(JsonParser jsonParser) {
        GraphQLGroupTopStoriesFeedUnitStoriesConnection graphQLGroupTopStoriesFeedUnitStoriesConnection = new GraphQLGroupTopStoriesFeedUnitStoriesConnection();
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
                        GraphQLGroupTopStoriesFeedUnitStoriesEdge a = GraphQLGroupTopStoriesFeedUnitStoriesEdge__JsonHelper.m8515a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLGroupTopStoriesFeedUnitStoriesConnection.f4208d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnitStoriesConnection, "edges", graphQLGroupTopStoriesFeedUnitStoriesConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLGroupTopStoriesFeedUnitStoriesConnection.f4209e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnitStoriesConnection, "page_info", graphQLGroupTopStoriesFeedUnitStoriesConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGroupTopStoriesFeedUnitStoriesConnection;
    }

    public static void m8507a(JsonGenerator jsonGenerator, GraphQLGroupTopStoriesFeedUnitStoriesConnection graphQLGroupTopStoriesFeedUnitStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLGroupTopStoriesFeedUnitStoriesConnection.m8502a() != null) {
            jsonGenerator.d();
            for (GraphQLGroupTopStoriesFeedUnitStoriesEdge graphQLGroupTopStoriesFeedUnitStoriesEdge : graphQLGroupTopStoriesFeedUnitStoriesConnection.m8502a()) {
                if (graphQLGroupTopStoriesFeedUnitStoriesEdge != null) {
                    GraphQLGroupTopStoriesFeedUnitStoriesEdge__JsonHelper.m8516a(jsonGenerator, graphQLGroupTopStoriesFeedUnitStoriesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupTopStoriesFeedUnitStoriesConnection.m8503j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLGroupTopStoriesFeedUnitStoriesConnection.m8503j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
