package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: iterator moved past last element in queue. */
public final class GraphQLAppAdStoriesSideFeedConnection__JsonHelper {
    public static GraphQLAppAdStoriesSideFeedConnection m6549a(JsonParser jsonParser) {
        GraphQLAppAdStoriesSideFeedConnection graphQLAppAdStoriesSideFeedConnection = new GraphQLAppAdStoriesSideFeedConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLAppAdStoriesSideFeedEdge a = GraphQLAppAdStoriesSideFeedEdge__JsonHelper.m6558a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLAppAdStoriesSideFeedConnection.f3346d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppAdStoriesSideFeedConnection, "edges", graphQLAppAdStoriesSideFeedConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLAppAdStoriesSideFeedConnection;
    }

    public static void m6550a(JsonGenerator jsonGenerator, GraphQLAppAdStoriesSideFeedConnection graphQLAppAdStoriesSideFeedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLAppAdStoriesSideFeedConnection.m6546a() != null) {
            jsonGenerator.d();
            for (GraphQLAppAdStoriesSideFeedEdge graphQLAppAdStoriesSideFeedEdge : graphQLAppAdStoriesSideFeedConnection.m6546a()) {
                if (graphQLAppAdStoriesSideFeedEdge != null) {
                    GraphQLAppAdStoriesSideFeedEdge__JsonHelper.m6559a(jsonGenerator, graphQLAppAdStoriesSideFeedEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
