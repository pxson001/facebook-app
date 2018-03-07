package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: ios_place_question_page_context_row */
public final class GraphQLDebugFeedConnection__JsonHelper {
    public static GraphQLDebugFeedConnection m6934a(JsonParser jsonParser) {
        GraphQLDebugFeedConnection graphQLDebugFeedConnection = new GraphQLDebugFeedConnection();
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
                        GraphQLDebugFeedEdge a = GraphQLDebugFeedEdge__JsonHelper.m6940a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLDebugFeedConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedConnection, "edges", graphQLDebugFeedConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLDebugFeedConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLDebugFeedConnection, "page_info", graphQLDebugFeedConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLDebugFeedConnection;
    }

    public static void m6935a(JsonGenerator jsonGenerator, GraphQLDebugFeedConnection graphQLDebugFeedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLDebugFeedConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLDebugFeedEdge graphQLDebugFeedEdge : graphQLDebugFeedConnection.a()) {
                if (graphQLDebugFeedEdge != null) {
                    GraphQLDebugFeedEdge__JsonHelper.m6941a(jsonGenerator, graphQLDebugFeedEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLDebugFeedConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLDebugFeedConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
