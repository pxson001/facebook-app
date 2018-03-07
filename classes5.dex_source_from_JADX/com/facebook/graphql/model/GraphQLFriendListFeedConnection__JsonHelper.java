package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: hc_nux_page_suggestion */
public final class GraphQLFriendListFeedConnection__JsonHelper {
    public static GraphQLFriendListFeedConnection m7549a(JsonParser jsonParser) {
        GraphQLFriendListFeedConnection graphQLFriendListFeedConnection = new GraphQLFriendListFeedConnection();
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
                        GraphQLFriendListFeedEdge a = GraphQLFriendListFeedEdge__JsonHelper.m7560a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLFriendListFeedConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendListFeedConnection, "edges", graphQLFriendListFeedConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLFriendListFeedConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendListFeedConnection, "page_info", graphQLFriendListFeedConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFriendListFeedConnection;
    }

    public static void m7550a(JsonGenerator jsonGenerator, GraphQLFriendListFeedConnection graphQLFriendListFeedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLFriendListFeedConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLFriendListFeedEdge graphQLFriendListFeedEdge : graphQLFriendListFeedConnection.a()) {
                if (graphQLFriendListFeedEdge != null) {
                    GraphQLFriendListFeedEdge__JsonHelper.m7561a(jsonGenerator, graphQLFriendListFeedEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendListFeedConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLFriendListFeedConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
