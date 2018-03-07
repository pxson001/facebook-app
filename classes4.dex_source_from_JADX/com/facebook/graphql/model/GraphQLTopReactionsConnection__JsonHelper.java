package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: same */
public final class GraphQLTopReactionsConnection__JsonHelper {
    public static GraphQLTopReactionsConnection m3256a(JsonParser jsonParser) {
        GraphQLTopReactionsConnection graphQLTopReactionsConnection = new GraphQLTopReactionsConnection();
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
                        GraphQLTopReactionsEdge a = GraphQLTopReactionsEdge__JsonHelper.m3258a(FieldAccessQueryTracker.m2235a(jsonParser, "edges"));
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
                graphQLTopReactionsConnection.d = list;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopReactionsConnection, "edges", graphQLTopReactionsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLTopReactionsConnection;
    }

    public static void m3257a(JsonGenerator jsonGenerator, GraphQLTopReactionsConnection graphQLTopReactionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLTopReactionsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLTopReactionsEdge graphQLTopReactionsEdge : graphQLTopReactionsConnection.a()) {
                if (graphQLTopReactionsEdge != null) {
                    GraphQLTopReactionsEdge__JsonHelper.m3259a(jsonGenerator, graphQLTopReactionsEdge, true);
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
