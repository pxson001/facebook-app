package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: employer */
public final class GraphQLPageStoriesYouMissedFeedUnitStoriesConnection__JsonHelper {
    public static GraphQLPageStoriesYouMissedFeedUnitStoriesConnection m9535a(JsonParser jsonParser) {
        GraphQLPageStoriesYouMissedFeedUnitStoriesConnection graphQLPageStoriesYouMissedFeedUnitStoriesConnection = new GraphQLPageStoriesYouMissedFeedUnitStoriesConnection();
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
                        GraphQLPageStoriesYouMissedFeedUnitStoriesEdge a = GraphQLPageStoriesYouMissedFeedUnitStoriesEdge__JsonHelper.m9544a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLPageStoriesYouMissedFeedUnitStoriesConnection.f4756d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnitStoriesConnection, "edges", graphQLPageStoriesYouMissedFeedUnitStoriesConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLPageStoriesYouMissedFeedUnitStoriesConnection.f4757e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnitStoriesConnection, "page_info", graphQLPageStoriesYouMissedFeedUnitStoriesConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPageStoriesYouMissedFeedUnitStoriesConnection;
    }

    public static void m9536a(JsonGenerator jsonGenerator, GraphQLPageStoriesYouMissedFeedUnitStoriesConnection graphQLPageStoriesYouMissedFeedUnitStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPageStoriesYouMissedFeedUnitStoriesConnection.m9531a() != null) {
            jsonGenerator.d();
            for (GraphQLPageStoriesYouMissedFeedUnitStoriesEdge graphQLPageStoriesYouMissedFeedUnitStoriesEdge : graphQLPageStoriesYouMissedFeedUnitStoriesConnection.m9531a()) {
                if (graphQLPageStoriesYouMissedFeedUnitStoriesEdge != null) {
                    GraphQLPageStoriesYouMissedFeedUnitStoriesEdge__JsonHelper.m9545a(jsonGenerator, graphQLPageStoriesYouMissedFeedUnitStoriesEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPageStoriesYouMissedFeedUnitStoriesConnection.m9532j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLPageStoriesYouMissedFeedUnitStoriesConnection.m9532j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
