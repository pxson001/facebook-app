package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_music_item */
public final class GraphQLBoostedComponentActionLink__JsonHelper {
    public static boolean m6645a(GraphQLBoostedComponentActionLink graphQLBoostedComponentActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("display_text".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "display_text"));
            }
            graphQLBoostedComponentActionLink.f3394d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentActionLink, "display_text", graphQLBoostedComponentActionLink.a_, 0, true);
            return true;
        } else if (!"uri".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLBoostedComponentActionLink.f3395e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLBoostedComponentActionLink, "uri", graphQLBoostedComponentActionLink.B_(), 1, false);
            return true;
        }
    }
}
