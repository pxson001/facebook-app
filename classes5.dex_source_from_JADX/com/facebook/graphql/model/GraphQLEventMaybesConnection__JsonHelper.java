package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: includeAs can not be null */
public final class GraphQLEventMaybesConnection__JsonHelper {
    public static GraphQLEventMaybesConnection m7224a(JsonParser jsonParser) {
        GraphQLEventMaybesConnection graphQLEventMaybesConnection = new GraphQLEventMaybesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7226a(graphQLEventMaybesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventMaybesConnection;
    }

    private static boolean m7226a(GraphQLEventMaybesConnection graphQLEventMaybesConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLEventMaybesConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesConnection, "count", graphQLEventMaybesConnection.a_, 0, false);
            return true;
        } else if ("edges".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEventMaybesEdge a = GraphQLEventMaybesEdge__JsonHelper.m7237a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
            graphQLEventMaybesConnection.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesConnection, "edges", graphQLEventMaybesConnection.B_(), 1, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLEventMaybesConnection.f = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesConnection, "page_info", graphQLEventMaybesConnection.B_(), 2, true);
            return true;
        } else if ("viewer_friend_count".equals(str)) {
            graphQLEventMaybesConnection.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesConnection, "viewer_friend_count", graphQLEventMaybesConnection.B_(), 3, false);
            return true;
        } else if (!"viewer_non_friend_count".equals(str)) {
            return false;
        } else {
            graphQLEventMaybesConnection.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMaybesConnection, "viewer_non_friend_count", graphQLEventMaybesConnection.B_(), 4, false);
            return true;
        }
    }

    public static void m7225a(JsonGenerator jsonGenerator, GraphQLEventMaybesConnection graphQLEventMaybesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEventMaybesConnection.a());
        jsonGenerator.a("edges");
        if (graphQLEventMaybesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEventMaybesEdge graphQLEventMaybesEdge : graphQLEventMaybesConnection.j()) {
                if (graphQLEventMaybesEdge != null) {
                    GraphQLEventMaybesEdge__JsonHelper.m7238a(jsonGenerator, graphQLEventMaybesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEventMaybesConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLEventMaybesConnection.k(), true);
        }
        jsonGenerator.a("viewer_friend_count", graphQLEventMaybesConnection.l());
        jsonGenerator.a("viewer_non_friend_count", graphQLEventMaybesConnection.m());
        if (z) {
            jsonGenerator.g();
        }
    }
}
