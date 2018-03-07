package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TWO_PLAYER_MATCH */
public final class GraphQLWriteReviewActionLink__JsonHelper {
    public static boolean m22547a(GraphQLWriteReviewActionLink graphQLWriteReviewActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("page".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
            }
            graphQLWriteReviewActionLink.f13469d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLWriteReviewActionLink, "page", graphQLWriteReviewActionLink.a_, 0, true);
            return true;
        } else if ("rating".equals(str)) {
            graphQLWriteReviewActionLink.f13470e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLWriteReviewActionLink, "rating", graphQLWriteReviewActionLink.B_(), 1, false);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLWriteReviewActionLink.f13471f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLWriteReviewActionLink, "title", graphQLWriteReviewActionLink.B_(), 2, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLWriteReviewActionLink.f13472g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLWriteReviewActionLink, "url", graphQLWriteReviewActionLink.B_(), 3, false);
            return true;
        }
    }
}
