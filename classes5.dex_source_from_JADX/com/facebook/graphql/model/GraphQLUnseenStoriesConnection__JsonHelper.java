package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Total FB power */
public final class GraphQLUnseenStoriesConnection__JsonHelper {
    public static GraphQLUnseenStoriesConnection m22356a(JsonParser jsonParser) {
        GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection = new GraphQLUnseenStoriesConnection();
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
                        GraphQLStory a = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLUnseenStoriesConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesConnection, "nodes", graphQLUnseenStoriesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLUnseenStoriesConnection;
    }

    public static void m22357a(JsonGenerator jsonGenerator, GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLUnseenStoriesConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLUnseenStoriesConnection.a()) {
                if (graphQLStory != null) {
                    GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStory, true);
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
