package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UPDATE %1$s SET %2$s WHERE %3$s */
public final class GraphQLSuggestedContentConnection__JsonHelper {
    public static GraphQLSuggestedContentConnection m22017a(JsonParser jsonParser) {
        GraphQLSuggestedContentConnection graphQLSuggestedContentConnection = new GraphQLSuggestedContentConnection();
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
                        GraphQLStoryAttachment a = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLSuggestedContentConnection.f13231d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSuggestedContentConnection, "nodes", graphQLSuggestedContentConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSuggestedContentConnection;
    }

    public static void m22018a(JsonGenerator jsonGenerator, GraphQLSuggestedContentConnection graphQLSuggestedContentConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLSuggestedContentConnection.m22014a() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLSuggestedContentConnection.m22014a()) {
                if (graphQLStoryAttachment != null) {
                    GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, graphQLStoryAttachment, true);
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
