package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: is_always_open */
public final class GraphQLCommentPlaceInfoToPlaceListItemsConnection__JsonHelper {
    public static GraphQLCommentPlaceInfoToPlaceListItemsConnection m6810a(JsonParser jsonParser) {
        GraphQLCommentPlaceInfoToPlaceListItemsConnection graphQLCommentPlaceInfoToPlaceListItemsConnection = new GraphQLCommentPlaceInfoToPlaceListItemsConnection();
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
                        GraphQLPlaceListItem a = GraphQLPlaceListItem__JsonHelper.m20872a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLCommentPlaceInfoToPlaceListItemsConnection.d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLCommentPlaceInfoToPlaceListItemsConnection, "nodes", graphQLCommentPlaceInfoToPlaceListItemsConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLCommentPlaceInfoToPlaceListItemsConnection;
    }

    public static void m6811a(JsonGenerator jsonGenerator, GraphQLCommentPlaceInfoToPlaceListItemsConnection graphQLCommentPlaceInfoToPlaceListItemsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLCommentPlaceInfoToPlaceListItemsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLPlaceListItem graphQLPlaceListItem : graphQLCommentPlaceInfoToPlaceListItemsConnection.a()) {
                if (graphQLPlaceListItem != null) {
                    GraphQLPlaceListItem__JsonHelper.m20873a(jsonGenerator, graphQLPlaceListItem, true);
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
