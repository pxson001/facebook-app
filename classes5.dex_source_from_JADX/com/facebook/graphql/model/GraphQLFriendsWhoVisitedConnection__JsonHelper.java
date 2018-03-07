package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: gysjTitle */
public final class GraphQLFriendsWhoVisitedConnection__JsonHelper {
    public static GraphQLFriendsWhoVisitedConnection m7647a(JsonParser jsonParser) {
        GraphQLFriendsWhoVisitedConnection graphQLFriendsWhoVisitedConnection = new GraphQLFriendsWhoVisitedConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLFriendsWhoVisitedConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoVisitedConnection, "count", graphQLFriendsWhoVisitedConnection.a_, 0, false);
                i2 = 1;
            } else if ("edges".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    r4 = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLFriendsWhoVisitedEdge a = GraphQLFriendsWhoVisitedEdge__JsonHelper.m7656a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLFriendsWhoVisitedConnection.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoVisitedConnection, "edges", graphQLFriendsWhoVisitedConnection.a_, 1, true);
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
                graphQLFriendsWhoVisitedConnection.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoVisitedConnection, "nodes", graphQLFriendsWhoVisitedConnection.a_, 2, true);
                i2 = 1;
            } else if ("social_context".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
                }
                graphQLFriendsWhoVisitedConnection.g = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLFriendsWhoVisitedConnection, "social_context", graphQLFriendsWhoVisitedConnection.a_, 3, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLFriendsWhoVisitedConnection;
    }

    public static void m7648a(JsonGenerator jsonGenerator, GraphQLFriendsWhoVisitedConnection graphQLFriendsWhoVisitedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLFriendsWhoVisitedConnection.a());
        jsonGenerator.a("edges");
        if (graphQLFriendsWhoVisitedConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLFriendsWhoVisitedEdge graphQLFriendsWhoVisitedEdge : graphQLFriendsWhoVisitedConnection.j()) {
                if (graphQLFriendsWhoVisitedEdge != null) {
                    GraphQLFriendsWhoVisitedEdge__JsonHelper.m7657a(jsonGenerator, graphQLFriendsWhoVisitedEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("nodes");
        if (graphQLFriendsWhoVisitedConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLFriendsWhoVisitedConnection.k()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendsWhoVisitedConnection.l() != null) {
            jsonGenerator.a("social_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFriendsWhoVisitedConnection.l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
