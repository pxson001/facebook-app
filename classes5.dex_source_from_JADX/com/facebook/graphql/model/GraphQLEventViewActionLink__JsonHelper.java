package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: imageTallCover */
public final class GraphQLEventViewActionLink__JsonHelper {
    public static boolean m7321a(GraphQLEventViewActionLink graphQLEventViewActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("event".equals(str)) {
            GraphQLEvent a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLEvent__JsonHelper.m7344a(FieldAccessQueryTracker.a(jsonParser, "event"));
            }
            graphQLEventViewActionLink.f3674d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventViewActionLink, "event", graphQLEventViewActionLink.a_, 0, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventViewActionLink.f3675e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventViewActionLink, "title", graphQLEventViewActionLink.B_(), 1, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLEventViewActionLink.f3676f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLEventViewActionLink, "url", graphQLEventViewActionLink.B_(), 2, false);
            return true;
        }
    }
}
