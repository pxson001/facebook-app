package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: USER_REVIEWS_LIST */
public final class GraphQLStorySetStoriesConnection__JsonHelper {
    public static GraphQLStorySetStoriesConnection m21913a(JsonParser jsonParser) {
        GraphQLStorySetStoriesConnection graphQLStorySetStoriesConnection = new GraphQLStorySetStoriesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLStorySetStoriesConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySetStoriesConnection, "count", graphQLStorySetStoriesConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
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
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLStorySetStoriesConnection.e = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySetStoriesConnection, "nodes", graphQLStorySetStoriesConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLStorySetStoriesConnection.f = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLStorySetStoriesConnection, "page_info", graphQLStorySetStoriesConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLStorySetStoriesConnection;
    }

    public static void m21914a(JsonGenerator jsonGenerator, GraphQLStorySetStoriesConnection graphQLStorySetStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLStorySetStoriesConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLStorySetStoriesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLStorySetStoriesConnection.j()) {
                if (graphQLStory != null) {
                    GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStory, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStorySetStoriesConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLStorySetStoriesConnection.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
