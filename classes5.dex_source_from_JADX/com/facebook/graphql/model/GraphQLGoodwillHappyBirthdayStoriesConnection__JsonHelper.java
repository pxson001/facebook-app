package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: graph_editor_url */
public final class GraphQLGoodwillHappyBirthdayStoriesConnection__JsonHelper {
    public static GraphQLGoodwillHappyBirthdayStoriesConnection m7898a(JsonParser jsonParser) {
        GraphQLGoodwillHappyBirthdayStoriesConnection graphQLGoodwillHappyBirthdayStoriesConnection = new GraphQLGoodwillHappyBirthdayStoriesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLGoodwillHappyBirthdayStoriesEdge a = GraphQLGoodwillHappyBirthdayStoriesEdge__JsonHelper.m7907a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLGoodwillHappyBirthdayStoriesConnection.f3921d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayStoriesConnection, "edges", graphQLGoodwillHappyBirthdayStoriesConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLGoodwillHappyBirthdayStoriesConnection.f3922e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillHappyBirthdayStoriesConnection, "page_info", graphQLGoodwillHappyBirthdayStoriesConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillHappyBirthdayStoriesConnection;
    }

    public static void m7899a(JsonGenerator jsonGenerator, GraphQLGoodwillHappyBirthdayStoriesConnection graphQLGoodwillHappyBirthdayStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLGoodwillHappyBirthdayStoriesConnection.m7894a() != null) {
            jsonGenerator.d();
            for (GraphQLGoodwillHappyBirthdayStoriesEdge graphQLGoodwillHappyBirthdayStoriesEdge : graphQLGoodwillHappyBirthdayStoriesConnection.m7894a()) {
                if (graphQLGoodwillHappyBirthdayStoriesEdge != null) {
                    GraphQLGoodwillHappyBirthdayStoriesEdge__JsonHelper.m7908a(jsonGenerator, graphQLGoodwillHappyBirthdayStoriesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGoodwillHappyBirthdayStoriesConnection.m7895j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLGoodwillHappyBirthdayStoriesConnection.m7895j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
