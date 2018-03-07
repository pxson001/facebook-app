package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: imageMidRes */
public final class GraphQLEventWatchersConnection__JsonHelper {
    public static GraphQLEventWatchersConnection m7332a(JsonParser jsonParser) {
        GraphQLEventWatchersConnection graphQLEventWatchersConnection = new GraphQLEventWatchersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7334a(graphQLEventWatchersConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventWatchersConnection;
    }

    private static boolean m7334a(GraphQLEventWatchersConnection graphQLEventWatchersConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLEventWatchersConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersConnection, "count", graphQLEventWatchersConnection.a_, 0, false);
            return true;
        } else if ("edges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEventWatchersEdge a = GraphQLEventWatchersEdge__JsonHelper.m7342a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
            graphQLEventWatchersConnection.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersConnection, "edges", graphQLEventWatchersConnection.B_(), 1, true);
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
            graphQLEventWatchersConnection.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersConnection, "nodes", graphQLEventWatchersConnection.B_(), 2, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLEventWatchersConnection.g = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersConnection, "page_info", graphQLEventWatchersConnection.B_(), 3, true);
            return true;
        } else if ("viewer_friend_count".equals(str)) {
            graphQLEventWatchersConnection.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersConnection, "viewer_friend_count", graphQLEventWatchersConnection.B_(), 4, false);
            return true;
        } else if (!"viewer_non_friend_count".equals(str)) {
            return false;
        } else {
            graphQLEventWatchersConnection.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersConnection, "viewer_non_friend_count", graphQLEventWatchersConnection.B_(), 5, false);
            return true;
        }
    }

    public static void m7333a(JsonGenerator jsonGenerator, GraphQLEventWatchersConnection graphQLEventWatchersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEventWatchersConnection.a());
        jsonGenerator.a("edges");
        if (graphQLEventWatchersConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEventWatchersEdge graphQLEventWatchersEdge : graphQLEventWatchersConnection.j()) {
                if (graphQLEventWatchersEdge != null) {
                    GraphQLEventWatchersEdge__JsonHelper.m7343a(jsonGenerator, graphQLEventWatchersEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLEventWatchersConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLEventWatchersConnection.k()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEventWatchersConnection.l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLEventWatchersConnection.l(), true);
        }
        jsonGenerator.a("viewer_friend_count", graphQLEventWatchersConnection.m());
        jsonGenerator.a("viewer_non_friend_count", graphQLEventWatchersConnection.n());
        if (z) {
            jsonGenerator.g();
        }
    }
}
