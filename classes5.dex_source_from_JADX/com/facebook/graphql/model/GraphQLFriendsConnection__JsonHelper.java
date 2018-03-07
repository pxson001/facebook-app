package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: has_media_fb_ids */
public final class GraphQLFriendsConnection__JsonHelper {
    public static GraphQLFriendsConnection m7608a(JsonParser jsonParser) {
        GraphQLFriendsConnection graphQLFriendsConnection = new GraphQLFriendsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7610a(graphQLFriendsConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFriendsConnection;
    }

    private static boolean m7610a(GraphQLFriendsConnection graphQLFriendsConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        Collection arrayList;
        GraphQLUser a;
        List copyOf;
        if ("birthdayPerson".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "birthdayPerson"));
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
            graphQLFriendsConnection.d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "birthdayPerson", graphQLFriendsConnection.a_, 0, true);
            return true;
        } else if ("count".equals(str)) {
            graphQLFriendsConnection.e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "count", graphQLFriendsConnection.B_(), 1, false);
            return true;
        } else if ("edges".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLFriendsEdge a2 = GraphQLFriendsEdge__JsonHelper.m7619a(FieldAccessQueryTracker.a(jsonParser, "edges"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLFriendsConnection.f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "edges", graphQLFriendsConnection.B_(), 2, true);
            return true;
        } else if ("friends_who_used_contact_importer_count".equals(str)) {
            graphQLFriendsConnection.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "friends_who_used_contact_importer_count", graphQLFriendsConnection.B_(), 3, false);
            return true;
        } else if ("friends_who_used_contact_importer_on_messenger_count".equals(str)) {
            graphQLFriendsConnection.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "friends_who_used_contact_importer_on_messenger_count", graphQLFriendsConnection.B_(), 4, false);
            return true;
        } else if ("nodes".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
            graphQLFriendsConnection.i = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "nodes", graphQLFriendsConnection.B_(), 5, true);
            return true;
        } else if (!"page_info".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLFriendsConnection.j = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendsConnection, "page_info", graphQLFriendsConnection.B_(), 6, true);
            return true;
        }
    }

    public static void m7609a(JsonGenerator jsonGenerator, GraphQLFriendsConnection graphQLFriendsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("birthdayPerson");
        if (graphQLFriendsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLFriendsConnection.a()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("count", graphQLFriendsConnection.j());
        jsonGenerator.a("edges");
        if (graphQLFriendsConnection.k() != null) {
            jsonGenerator.d();
            for (GraphQLFriendsEdge graphQLFriendsEdge : graphQLFriendsConnection.k()) {
                if (graphQLFriendsEdge != null) {
                    GraphQLFriendsEdge__JsonHelper.m7620a(jsonGenerator, graphQLFriendsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("friends_who_used_contact_importer_count", graphQLFriendsConnection.l());
        jsonGenerator.a("friends_who_used_contact_importer_on_messenger_count", graphQLFriendsConnection.m());
        jsonGenerator.a("nodes");
        if (graphQLFriendsConnection.n() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser2 : graphQLFriendsConnection.n()) {
                if (graphQLUser2 != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLFriendsConnection.o() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLFriendsConnection.o(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
