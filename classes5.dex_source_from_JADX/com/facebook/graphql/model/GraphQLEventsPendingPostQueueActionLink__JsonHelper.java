package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: igPffItems */
public final class GraphQLEventsPendingPostQueueActionLink__JsonHelper {
    public static boolean m7368a(GraphQLEventsPendingPostQueueActionLink graphQLEventsPendingPostQueueActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("event".equals(str)) {
            GraphQLEvent a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLEvent__JsonHelper.m7344a(FieldAccessQueryTracker.a(jsonParser, "event"));
            }
            graphQLEventsPendingPostQueueActionLink.f3685d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventsPendingPostQueueActionLink, "event", graphQLEventsPendingPostQueueActionLink.a_, 0, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventsPendingPostQueueActionLink.f3686e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventsPendingPostQueueActionLink, "title", graphQLEventsPendingPostQueueActionLink.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventsPendingPostQueueActionLink.f3687f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventsPendingPostQueueActionLink, "url", graphQLEventsPendingPostQueueActionLink.B_(), 2, false);
            return true;
        }
    }
}
