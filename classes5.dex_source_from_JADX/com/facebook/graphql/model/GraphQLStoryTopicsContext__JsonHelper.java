package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: USER_FORCED */
public final class GraphQLStoryTopicsContext__JsonHelper {
    public static GraphQLStoryTopicsContext m21920a(JsonParser jsonParser) {
        GraphQLStoryTopicsContext graphQLStoryTopicsContext = new GraphQLStoryTopicsContext();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            Collection arrayList;
            GraphQLTopic a;
            if ("pivotal_topics".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        a = GraphQLTopic__JsonHelper.m22278a(FieldAccessQueryTracker.a(jsonParser, "pivotal_topics"));
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
                graphQLStoryTopicsContext.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryTopicsContext, "pivotal_topics", graphQLStoryTopicsContext.a_, 0, true);
            } else if ("trending_topics".equals(i)) {
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        a = GraphQLTopic__JsonHelper.m22278a(FieldAccessQueryTracker.a(jsonParser, "trending_topics"));
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
                graphQLStoryTopicsContext.e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLStoryTopicsContext, "trending_topics", graphQLStoryTopicsContext.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLStoryTopicsContext;
    }

    public static void m21921a(JsonGenerator jsonGenerator, GraphQLStoryTopicsContext graphQLStoryTopicsContext, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("pivotal_topics");
        if (graphQLStoryTopicsContext.a() != null) {
            jsonGenerator.d();
            for (GraphQLTopic graphQLTopic : graphQLStoryTopicsContext.a()) {
                if (graphQLTopic != null) {
                    GraphQLTopic__JsonHelper.m22279a(jsonGenerator, graphQLTopic, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("trending_topics");
        if (graphQLStoryTopicsContext.j() != null) {
            jsonGenerator.d();
            for (GraphQLTopic graphQLTopic2 : graphQLStoryTopicsContext.j()) {
                if (graphQLTopic2 != null) {
                    GraphQLTopic__JsonHelper.m22279a(jsonGenerator, graphQLTopic2, true);
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
