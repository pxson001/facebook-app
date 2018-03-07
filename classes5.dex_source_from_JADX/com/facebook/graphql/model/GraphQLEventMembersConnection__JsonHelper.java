package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: impression_logging_url */
public final class GraphQLEventMembersConnection__JsonHelper {
    public static GraphQLEventMembersConnection m7245a(JsonParser jsonParser) {
        GraphQLEventMembersConnection graphQLEventMembersConnection = new GraphQLEventMembersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7247a(graphQLEventMembersConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventMembersConnection;
    }

    private static boolean m7247a(GraphQLEventMembersConnection graphQLEventMembersConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLEventMembersConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersConnection, "count", graphQLEventMembersConnection.a_, 0, false);
            return true;
        } else if ("edges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEventMembersEdge a = GraphQLEventMembersEdge__JsonHelper.m7258a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLEventMembersConnection.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersConnection, "edges", graphQLEventMembersConnection.B_(), 1, true);
            return true;
        } else if ("nodes".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLActor a2 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLEventMembersConnection.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersConnection, "nodes", graphQLEventMembersConnection.B_(), 2, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLEventMembersConnection.g = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersConnection, "page_info", graphQLEventMembersConnection.B_(), 3, true);
            return true;
        } else if ("viewer_friend_count".equals(str)) {
            graphQLEventMembersConnection.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersConnection, "viewer_friend_count", graphQLEventMembersConnection.B_(), 4, false);
            return true;
        } else if (!"viewer_non_friend_count".equals(str)) {
            return false;
        } else {
            graphQLEventMembersConnection.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventMembersConnection, "viewer_non_friend_count", graphQLEventMembersConnection.B_(), 5, false);
            return true;
        }
    }

    public static void m7246a(JsonGenerator jsonGenerator, GraphQLEventMembersConnection graphQLEventMembersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEventMembersConnection.a());
        jsonGenerator.a("edges");
        if (graphQLEventMembersConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEventMembersEdge graphQLEventMembersEdge : graphQLEventMembersConnection.j()) {
                if (graphQLEventMembersEdge != null) {
                    GraphQLEventMembersEdge__JsonHelper.m7259a(jsonGenerator, graphQLEventMembersEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLEventMembersConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLEventMembersConnection.k()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEventMembersConnection.l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLEventMembersConnection.l(), true);
        }
        jsonGenerator.a("viewer_friend_count", graphQLEventMembersConnection.m());
        jsonGenerator.a("viewer_non_friend_count", graphQLEventMembersConnection.n());
        if (z) {
            jsonGenerator.g();
        }
    }
}
