package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WEBP */
public final class GraphQLPlaceListItemToRecommendingCommentsConnection__JsonHelper {
    public static GraphQLPlaceListItemToRecommendingCommentsConnection m20870a(JsonParser jsonParser) {
        GraphQLPlaceListItemToRecommendingCommentsConnection graphQLPlaceListItemToRecommendingCommentsConnection = new GraphQLPlaceListItemToRecommendingCommentsConnection();
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
                        GraphQLComment a = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLPlaceListItemToRecommendingCommentsConnection.f12651d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceListItemToRecommendingCommentsConnection, "nodes", graphQLPlaceListItemToRecommendingCommentsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLPlaceListItemToRecommendingCommentsConnection;
    }

    public static void m20871a(JsonGenerator jsonGenerator, GraphQLPlaceListItemToRecommendingCommentsConnection graphQLPlaceListItemToRecommendingCommentsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLPlaceListItemToRecommendingCommentsConnection.m20867a() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment : graphQLPlaceListItemToRecommendingCommentsConnection.m20867a()) {
                if (graphQLComment != null) {
                    GraphQLComment__JsonHelper.a(jsonGenerator, graphQLComment, true);
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
