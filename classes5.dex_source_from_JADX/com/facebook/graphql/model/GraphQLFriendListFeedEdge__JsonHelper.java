package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: hc_event_guest */
public final class GraphQLFriendListFeedEdge__JsonHelper {
    public static GraphQLFriendListFeedEdge m7560a(JsonParser jsonParser) {
        GraphQLFriendListFeedEdge graphQLFriendListFeedEdge = new GraphQLFriendListFeedEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7562a(graphQLFriendListFeedEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFriendListFeedEdge;
    }

    private static boolean m7562a(GraphQLFriendListFeedEdge graphQLFriendListFeedEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("cursor".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFriendListFeedEdge.f3776d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendListFeedEdge, "cursor", graphQLFriendListFeedEdge.a_, 0, false);
            return true;
        } else if ("node".equals(str)) {
            FeedUnit a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLFriendListFeedEdge.f3777e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendListFeedEdge, "node", graphQLFriendListFeedEdge.B_(), 1, true);
            return true;
        } else if (!"sort_key".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFriendListFeedEdge.f3778f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFriendListFeedEdge, "sort_key", graphQLFriendListFeedEdge.B_(), 2, false);
            return true;
        }
    }

    public static void m7561a(JsonGenerator jsonGenerator, GraphQLFriendListFeedEdge graphQLFriendListFeedEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFriendListFeedEdge.m7555a() != null) {
            jsonGenerator.a("cursor", graphQLFriendListFeedEdge.m7555a());
        }
        if (graphQLFriendListFeedEdge.m7556j() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLFriendListFeedEdge.m7556j());
        }
        if (graphQLFriendListFeedEdge.m7557k() != null) {
            jsonGenerator.a("sort_key", graphQLFriendListFeedEdge.m7557k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
