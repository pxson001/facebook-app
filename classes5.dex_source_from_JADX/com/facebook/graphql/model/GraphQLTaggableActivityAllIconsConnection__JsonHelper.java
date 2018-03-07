package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNSPECIFIED */
public final class GraphQLTaggableActivityAllIconsConnection__JsonHelper {
    public static GraphQLTaggableActivityAllIconsConnection m22046a(JsonParser jsonParser) {
        GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection = new GraphQLTaggableActivityAllIconsConnection();
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
                graphQLTaggableActivityAllIconsConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityAllIconsConnection, "count", graphQLTaggableActivityAllIconsConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLTaggableActivityIcon a = GraphQLTaggableActivityIcon__JsonHelper.m22054a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLTaggableActivityAllIconsConnection.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivityAllIconsConnection, "nodes", graphQLTaggableActivityAllIconsConnection.a_, 1, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLTaggableActivityAllIconsConnection;
    }

    public static void m22047a(JsonGenerator jsonGenerator, GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLTaggableActivityAllIconsConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLTaggableActivityAllIconsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLTaggableActivityIcon graphQLTaggableActivityIcon : graphQLTaggableActivityAllIconsConnection.j()) {
                if (graphQLTaggableActivityIcon != null) {
                    GraphQLTaggableActivityIcon__JsonHelper.m22055a(jsonGenerator, graphQLTaggableActivityIcon, true);
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
