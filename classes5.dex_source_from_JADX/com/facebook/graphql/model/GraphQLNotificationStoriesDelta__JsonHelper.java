package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: event_cover_photo */
public final class GraphQLNotificationStoriesDelta__JsonHelper {
    public static boolean m9370a(GraphQLNotificationStoriesDelta graphQLNotificationStoriesDelta, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("modified_edge".equals(str)) {
            GraphQLNotificationStoriesEdge a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNotificationStoriesEdge__JsonHelper.m9389a(FieldAccessQueryTracker.a(jsonParser, "modified_edge"));
            }
            graphQLNotificationStoriesDelta.f4656d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesDelta, "modified_edge", graphQLNotificationStoriesDelta.a_, 0, true);
            return true;
        } else if ("removed".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLNotificationStoriesDelta.f4657e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesDelta, "removed", graphQLNotificationStoriesDelta.B_(), 1, false);
            return true;
        } else if (!"unchanged".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLNotificationStoriesDelta.f4658f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNotificationStoriesDelta, "unchanged", graphQLNotificationStoriesDelta.B_(), 2, false);
            return true;
        }
    }
}
