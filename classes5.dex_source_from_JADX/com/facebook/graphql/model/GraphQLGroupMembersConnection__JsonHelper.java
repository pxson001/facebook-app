package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: friend_confirmed_notif_email */
public final class GraphQLGroupMembersConnection__JsonHelper {
    public static GraphQLGroupMembersConnection m8458a(JsonParser jsonParser) {
        GraphQLGroupMembersConnection graphQLGroupMembersConnection = new GraphQLGroupMembersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLGroupMembersConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMembersConnection, "count", graphQLGroupMembersConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r4 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLGroupMembersEdge a = GraphQLGroupMembersEdge__JsonHelper.m8469a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                        if (a != null) {
                            r4.add(a);
                        }
                    }
                } else {
                    r4 = null;
                }
                if (r4 != null) {
                    r3 = ImmutableList.copyOf(r4);
                }
                graphQLGroupMembersConnection.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMembersConnection, "edges", graphQLGroupMembersConnection.a_, 1, true);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r4 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a2 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
                        if (a2 != null) {
                            r4.add(a2);
                        }
                    }
                } else {
                    r4 = null;
                }
                if (r4 != null) {
                    r3 = ImmutableList.copyOf(r4);
                }
                graphQLGroupMembersConnection.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMembersConnection, "nodes", graphQLGroupMembersConnection.a_, 2, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLGroupMembersConnection.g = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupMembersConnection, "page_info", graphQLGroupMembersConnection.a_, 3, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLGroupMembersConnection;
    }

    public static void m8459a(JsonGenerator jsonGenerator, GraphQLGroupMembersConnection graphQLGroupMembersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLGroupMembersConnection.a());
        jsonGenerator.a("edges");
        if (graphQLGroupMembersConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLGroupMembersEdge graphQLGroupMembersEdge : graphQLGroupMembersConnection.j()) {
                if (graphQLGroupMembersEdge != null) {
                    GraphQLGroupMembersEdge__JsonHelper.m8470a(jsonGenerator, graphQLGroupMembersEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLGroupMembersConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLGroupMembersConnection.k()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupMembersConnection.l() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLGroupMembersConnection.l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
