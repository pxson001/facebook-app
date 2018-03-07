package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: features_meta */
public final class GraphQLLikedProfilesConnection__JsonHelper {
    public static GraphQLLikedProfilesConnection m8914a(JsonParser jsonParser) {
        GraphQLLikedProfilesConnection graphQLLikedProfilesConnection = new GraphQLLikedProfilesConnection();
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
                        GraphQLProfile a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLLikedProfilesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLLikedProfilesConnection, "nodes", graphQLLikedProfilesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLLikedProfilesConnection;
    }

    public static void m8915a(JsonGenerator jsonGenerator, GraphQLLikedProfilesConnection graphQLLikedProfilesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLLikedProfilesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLProfile graphQLProfile : graphQLLikedProfilesConnection.a()) {
                if (graphQLProfile != null) {
                    GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLProfile, true);
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
