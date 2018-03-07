package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friending_radar */
public final class C0396xbb7ddb05 {
    public static GraphQLGroupCreationSuggestionDefaultMembersConnection m8425a(JsonParser jsonParser) {
        GraphQLGroupCreationSuggestionDefaultMembersConnection graphQLGroupCreationSuggestionDefaultMembersConnection = new GraphQLGroupCreationSuggestionDefaultMembersConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("nodes".equals(i)) {
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
                graphQLGroupCreationSuggestionDefaultMembersConnection.f4200d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGroupCreationSuggestionDefaultMembersConnection, "nodes", graphQLGroupCreationSuggestionDefaultMembersConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGroupCreationSuggestionDefaultMembersConnection;
    }

    public static void m8426a(JsonGenerator jsonGenerator, GraphQLGroupCreationSuggestionDefaultMembersConnection graphQLGroupCreationSuggestionDefaultMembersConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGroupCreationSuggestionDefaultMembersConnection.m8422a() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLGroupCreationSuggestionDefaultMembersConnection.m8422a()) {
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
