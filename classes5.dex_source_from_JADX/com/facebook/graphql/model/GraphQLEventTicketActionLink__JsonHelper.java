package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: image_uri */
public final class GraphQLEventTicketActionLink__JsonHelper {
    public static boolean m7292a(GraphQLEventTicketActionLink graphQLEventTicketActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("event".equals(str)) {
            GraphQLEvent a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLEvent__JsonHelper.m7344a(FieldAccessQueryTracker.a(jsonParser, "event"));
            }
            graphQLEventTicketActionLink.f3670d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketActionLink, "event", graphQLEventTicketActionLink.a_, 0, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventTicketActionLink.f3671e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketActionLink, "title", graphQLEventTicketActionLink.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventTicketActionLink.f3672f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventTicketActionLink, "url", graphQLEventTicketActionLink.B_(), 2, false);
            return true;
        }
    }
}
