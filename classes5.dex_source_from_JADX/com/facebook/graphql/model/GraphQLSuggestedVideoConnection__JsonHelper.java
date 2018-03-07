package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UPCOMING_EVENT */
public final class GraphQLSuggestedVideoConnection__JsonHelper {
    public static GraphQLSuggestedVideoConnection m22026a(JsonParser jsonParser) {
        GraphQLSuggestedVideoConnection graphQLSuggestedVideoConnection = new GraphQLSuggestedVideoConnection();
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
                graphQLSuggestedVideoConnection.f13232d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSuggestedVideoConnection, "nodes", graphQLSuggestedVideoConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSuggestedVideoConnection;
    }

    public static void m22027a(JsonGenerator jsonGenerator, GraphQLSuggestedVideoConnection graphQLSuggestedVideoConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLSuggestedVideoConnection.m22023a() != null) {
            jsonGenerator.d();
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLSuggestedVideoConnection.m22023a()) {
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
