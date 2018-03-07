package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: item_context */
public final class GraphQLAppList__JsonHelper {
    public static boolean m6569a(GraphQLAppList graphQLAppList, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLAppList.f3348d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAppList, "id", graphQLAppList.a_, 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLAppList.f3349e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLAppList, "url", graphQLAppList.B_(), 3, false);
            return true;
        }
    }
}
