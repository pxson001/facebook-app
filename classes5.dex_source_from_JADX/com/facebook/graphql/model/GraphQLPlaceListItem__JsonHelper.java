package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WEBM */
public final class GraphQLPlaceListItem__JsonHelper {
    public static GraphQLPlaceListItem m20872a(JsonParser jsonParser) {
        GraphQLPlaceListItem graphQLPlaceListItem = new GraphQLPlaceListItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m20874a(graphQLPlaceListItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLPlaceListItem;
    }

    private static boolean m20874a(GraphQLPlaceListItem graphQLPlaceListItem, String str, JsonParser jsonParser) {
        GraphQLPlaceListItemToRecommendingCommentsConnection graphQLPlaceListItemToRecommendingCommentsConnection = null;
        String o;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPlaceListItem.f12646d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceListItem, "id", graphQLPlaceListItem.a_, 0, false);
            return true;
        } else if ("place_recommendation_page".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "place_recommendation_page"));
            }
            graphQLPlaceListItem.f12647e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceListItem, "place_recommendation_page", graphQLPlaceListItem.B_(), 1, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLPlaceListItem.f12648f = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceListItem, "url", graphQLPlaceListItem.B_(), 2, false);
            return true;
        } else if (!"recommending_comments".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPlaceListItemToRecommendingCommentsConnection = GraphQLPlaceListItemToRecommendingCommentsConnection__JsonHelper.m20870a(FieldAccessQueryTracker.a(jsonParser, "recommending_comments"));
            }
            graphQLPlaceListItem.f12649g = graphQLPlaceListItemToRecommendingCommentsConnection;
            FieldAccessQueryTracker.a(jsonParser, graphQLPlaceListItem, "recommending_comments", graphQLPlaceListItem.B_(), 3, true);
            return true;
        }
    }

    public static void m20873a(JsonGenerator jsonGenerator, GraphQLPlaceListItem graphQLPlaceListItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLPlaceListItem.m20856j() != null) {
            jsonGenerator.a("id", graphQLPlaceListItem.m20856j());
        }
        if (graphQLPlaceListItem.m20857k() != null) {
            jsonGenerator.a("place_recommendation_page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLPlaceListItem.m20857k(), true);
        }
        if (graphQLPlaceListItem.m20858l() != null) {
            jsonGenerator.a("url", graphQLPlaceListItem.m20858l());
        }
        if (graphQLPlaceListItem.m20859m() != null) {
            jsonGenerator.a("recommending_comments");
            GraphQLPlaceListItemToRecommendingCommentsConnection__JsonHelper.m20871a(jsonGenerator, graphQLPlaceListItem.m20859m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
