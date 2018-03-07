package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: info_fields_data */
public final class GraphQLEventInviteesConnection__JsonHelper {
    public static GraphQLEventInviteesConnection m7206a(JsonParser jsonParser) {
        GraphQLEventInviteesConnection graphQLEventInviteesConnection = new GraphQLEventInviteesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7208a(graphQLEventInviteesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLEventInviteesConnection;
    }

    private static boolean m7208a(GraphQLEventInviteesConnection graphQLEventInviteesConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLEventInviteesConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesConnection, "count", graphQLEventInviteesConnection.a_, 0, false);
            return true;
        } else if ("edges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEventInviteesEdge a = GraphQLEventInviteesEdge__JsonHelper.m7217a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
            graphQLEventInviteesConnection.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesConnection, "edges", graphQLEventInviteesConnection.B_(), 1, true);
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
            graphQLEventInviteesConnection.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesConnection, "nodes", graphQLEventInviteesConnection.B_(), 2, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLEventInviteesConnection.g = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesConnection, "page_info", graphQLEventInviteesConnection.B_(), 3, true);
            return true;
        } else if ("viewer_friend_count".equals(str)) {
            graphQLEventInviteesConnection.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesConnection, "viewer_friend_count", graphQLEventInviteesConnection.B_(), 4, false);
            return true;
        } else if (!"viewer_non_friend_count".equals(str)) {
            return false;
        } else {
            graphQLEventInviteesConnection.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLEventInviteesConnection, "viewer_non_friend_count", graphQLEventInviteesConnection.B_(), 5, false);
            return true;
        }
    }

    public static void m7207a(JsonGenerator jsonGenerator, GraphQLEventInviteesConnection graphQLEventInviteesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLEventInviteesConnection.a());
        jsonGenerator.a("edges");
        if (graphQLEventInviteesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLEventInviteesEdge graphQLEventInviteesEdge : graphQLEventInviteesConnection.j()) {
                if (graphQLEventInviteesEdge != null) {
                    GraphQLEventInviteesEdge__JsonHelper.m7218a(jsonGenerator, graphQLEventInviteesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLEventInviteesConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLActor graphQLActor : graphQLEventInviteesConnection.k()) {
                if (graphQLActor != null) {
                    GraphQLActor__JsonHelper.a(jsonGenerator, graphQLActor, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLEventInviteesConnection.l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLEventInviteesConnection.l(), true);
        }
        jsonGenerator.a("viewer_friend_count", graphQLEventInviteesConnection.m());
        jsonGenerator.a("viewer_non_friend_count", graphQLEventInviteesConnection.n());
        if (z) {
            jsonGenerator.g();
        }
    }
}
