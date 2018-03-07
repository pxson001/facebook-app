package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: estimated_results */
public final class GraphQLOverlayActionLink__JsonHelper {
    public static boolean m9422a(GraphQLOverlayActionLink graphQLOverlayActionLink, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("description".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "description"));
            }
            graphQLOverlayActionLink.f4670d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayActionLink, "description", graphQLOverlayActionLink.a_, 0, true);
            return true;
        } else if ("info".equals(str)) {
            GraphQLOverlayCallToActionInfo a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLOverlayCallToActionInfo__JsonHelper.m9427a(FieldAccessQueryTracker.a(jsonParser, "info"));
            }
            graphQLOverlayActionLink.f4671e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayActionLink, "info", graphQLOverlayActionLink.B_(), 1, true);
            return true;
        } else if ("title".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOverlayActionLink.f4672f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayActionLink, "title", graphQLOverlayActionLink.B_(), 2, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOverlayActionLink.f4673g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOverlayActionLink, "url", graphQLOverlayActionLink.B_(), 3, false);
            return true;
        }
    }
}
