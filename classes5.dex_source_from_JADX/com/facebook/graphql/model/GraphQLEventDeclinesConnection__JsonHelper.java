package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: initializeRecorder/unlock failed */
public final class GraphQLEventDeclinesConnection__JsonHelper {
    public static GraphQLEventDeclinesConnection m7169a(JsonParser jsonParser) {
        GraphQLEventDeclinesConnection graphQLEventDeclinesConnection = new GraphQLEventDeclinesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7171a(graphQLEventDeclinesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventDeclinesConnection;
    }

    private static boolean m7171a(GraphQLEventDeclinesConnection graphQLEventDeclinesConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLEventDeclinesConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesConnection, "count", graphQLEventDeclinesConnection.a_, 0, false);
            return true;
        } else if ("edges".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEventDeclinesEdge a = GraphQLEventDeclinesEdge__JsonHelper.m7183a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
            graphQLEventDeclinesConnection.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesConnection, "edges", graphQLEventDeclinesConnection.B_(), 1, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLEventDeclinesConnection.f = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesConnection, "page_info", graphQLEventDeclinesConnection.B_(), 2, true);
            return true;
        } else if ("viewer_friend_count".equals(str)) {
            graphQLEventDeclinesConnection.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesConnection, "viewer_friend_count", graphQLEventDeclinesConnection.B_(), 3, false);
            return true;
        } else if (!"viewer_non_friend_count".equals(str)) {
            return false;
        } else {
            graphQLEventDeclinesConnection.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventDeclinesConnection, "viewer_non_friend_count", graphQLEventDeclinesConnection.B_(), 4, false);
            return true;
        }
    }

    public static void m7170a(JsonGenerator jsonGenerator, GraphQLEventDeclinesConnection graphQLEventDeclinesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEventDeclinesConnection.a());
        jsonGenerator.a("edges");
        if (graphQLEventDeclinesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEventDeclinesEdge graphQLEventDeclinesEdge : graphQLEventDeclinesConnection.j()) {
                if (graphQLEventDeclinesEdge != null) {
                    GraphQLEventDeclinesEdge__JsonHelper.m7184a(jsonGenerator, graphQLEventDeclinesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEventDeclinesConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLEventDeclinesConnection.k(), true);
        }
        jsonGenerator.a("viewer_friend_count", graphQLEventDeclinesConnection.l());
        jsonGenerator.a("viewer_non_friend_count", graphQLEventDeclinesConnection.m());
        if (z) {
            jsonGenerator.g();
        }
    }
}
