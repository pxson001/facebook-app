package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: getSensorTime */
public final class GraphQLGoodwillThrowbackPromotedStoriesConnection__JsonHelper {
    public static GraphQLGoodwillThrowbackPromotedStoriesConnection m8086a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackPromotedStoriesConnection graphQLGoodwillThrowbackPromotedStoriesConnection = new GraphQLGoodwillThrowbackPromotedStoriesConnection();
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
                graphQLGoodwillThrowbackPromotedStoriesConnection.f4031d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackPromotedStoriesConnection, "nodes", graphQLGoodwillThrowbackPromotedStoriesConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackPromotedStoriesConnection;
    }

    public static void m8087a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackPromotedStoriesConnection graphQLGoodwillThrowbackPromotedStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLGoodwillThrowbackPromotedStoriesConnection.m8083a() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLGoodwillThrowbackPromotedStoriesConnection.m8083a()) {
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
