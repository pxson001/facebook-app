package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: hookScheduleVsyncLocked */
public final class GraphQLFeedTopicContent__JsonHelper {
    public static GraphQLFeedTopicContent m7465a(JsonParser jsonParser) {
        GraphQLFeedTopicContent graphQLFeedTopicContent = new GraphQLFeedTopicContent();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            List list = null;
            if ("feed_topics".equals(i)) {
                Collection arrayList;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLExploreFeed a = GraphQLExploreFeed__JsonHelper.m7404a(FieldAccessQueryTracker.a(jsonParser, "feed_topics"));
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
                graphQLFeedTopicContent.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLFeedTopicContent, "feed_topics", graphQLFeedTopicContent.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLFeedTopicContent;
    }

    public static void m7466a(JsonGenerator jsonGenerator, GraphQLFeedTopicContent graphQLFeedTopicContent, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("feed_topics");
        if (graphQLFeedTopicContent.a() != null) {
            jsonGenerator.d();
            for (GraphQLExploreFeed graphQLExploreFeed : graphQLFeedTopicContent.a()) {
                if (graphQLExploreFeed != null) {
                    GraphQLExploreFeed__JsonHelper.m7405a(jsonGenerator, graphQLExploreFeed, true);
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
