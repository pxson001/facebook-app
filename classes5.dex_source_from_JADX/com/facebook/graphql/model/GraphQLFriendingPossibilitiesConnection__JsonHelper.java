package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: has_viewer_hidden */
public final class GraphQLFriendingPossibilitiesConnection__JsonHelper {
    public static GraphQLFriendingPossibilitiesConnection m7587a(JsonParser jsonParser) {
        GraphQLFriendingPossibilitiesConnection graphQLFriendingPossibilitiesConnection = new GraphQLFriendingPossibilitiesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7589a(graphQLFriendingPossibilitiesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFriendingPossibilitiesConnection;
    }

    private static boolean m7589a(GraphQLFriendingPossibilitiesConnection graphQLFriendingPossibilitiesConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("edges".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLFriendingPossibilitiesEdge a = GraphQLFriendingPossibilitiesEdge__JsonHelper.m7601a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
            graphQLFriendingPossibilitiesConnection.d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesConnection, "edges", graphQLFriendingPossibilitiesConnection.a_, 0, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLFriendingPossibilitiesConnection.e = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesConnection, "page_info", graphQLFriendingPossibilitiesConnection.B_(), 1, true);
            return true;
        } else if (!"total_possibility_count".equals(str)) {
            return false;
        } else {
            graphQLFriendingPossibilitiesConnection.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendingPossibilitiesConnection, "total_possibility_count", graphQLFriendingPossibilitiesConnection.B_(), 2, false);
            return true;
        }
    }

    public static void m7588a(JsonGenerator jsonGenerator, GraphQLFriendingPossibilitiesConnection graphQLFriendingPossibilitiesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLFriendingPossibilitiesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLFriendingPossibilitiesEdge graphQLFriendingPossibilitiesEdge : graphQLFriendingPossibilitiesConnection.a()) {
                if (graphQLFriendingPossibilitiesEdge != null) {
                    GraphQLFriendingPossibilitiesEdge__JsonHelper.m7602a(jsonGenerator, graphQLFriendingPossibilitiesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendingPossibilitiesConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLFriendingPossibilitiesConnection.j(), true);
        }
        jsonGenerator.a("total_possibility_count", graphQLFriendingPossibilitiesConnection.k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
