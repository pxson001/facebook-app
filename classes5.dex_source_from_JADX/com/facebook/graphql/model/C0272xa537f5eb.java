package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: is_viewer_admin */
public final class C0272xa537f5eb {
    public static GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection m6580a(JsonParser jsonParser) {
        GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection = new GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection, "count", graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLUser a = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    list = ImmutableList.copyOf(arrayList);
                }
                graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection, "nodes", graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection;
    }

    public static void m6581a(JsonGenerator jsonGenerator, GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.j()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
