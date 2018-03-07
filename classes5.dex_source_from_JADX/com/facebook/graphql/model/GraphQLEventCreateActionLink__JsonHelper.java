package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: inline_feed */
public final class GraphQLEventCreateActionLink__JsonHelper {
    public static boolean m7164a(GraphQLEventCreateActionLink graphQLEventCreateActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("temporal_event_info".equals(str)) {
            GraphQLTemporalEventInfo a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTemporalEventInfo__JsonHelper.m22103a(FieldAccessQueryTracker.a(jsonParser, "temporal_event_info"));
            }
            graphQLEventCreateActionLink.f3626d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventCreateActionLink, "temporal_event_info", graphQLEventCreateActionLink.a_, 0, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventCreateActionLink.f3627e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventCreateActionLink, "title", graphQLEventCreateActionLink.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventCreateActionLink.f3628f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventCreateActionLink, "url", graphQLEventCreateActionLink.B_(), 2, false);
            return true;
        }
    }
}
