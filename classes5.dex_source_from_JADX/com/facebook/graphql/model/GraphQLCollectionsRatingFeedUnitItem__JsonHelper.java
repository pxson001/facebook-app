package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_backout_draft */
public final class GraphQLCollectionsRatingFeedUnitItem__JsonHelper {
    public static boolean m6798a(GraphQLCollectionsRatingFeedUnitItem graphQLCollectionsRatingFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("profile".equals(str)) {
            GraphQLProfile a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLCollectionsRatingFeedUnitItem.f3447d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLCollectionsRatingFeedUnitItem, "profile", graphQLCollectionsRatingFeedUnitItem.a_, 0, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCollectionsRatingFeedUnitItem.f3448e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCollectionsRatingFeedUnitItem, "tracking", graphQLCollectionsRatingFeedUnitItem.B_(), 1, false);
            return true;
        }
    }
}
