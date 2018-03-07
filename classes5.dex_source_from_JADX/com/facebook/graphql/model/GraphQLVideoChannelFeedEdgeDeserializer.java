package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_entry_bookmarks */
public class GraphQLVideoChannelFeedEdgeDeserializer extends FbJsonDeserializer {
    public Object m22443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLVideoChannelFeedEdge graphQLVideoChannelFeedEdge = new GraphQLVideoChannelFeedEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLVideoChannelFeedEdge = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("node".equals(i)) {
                    FeedUnit feedUnit;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        feedUnit = null;
                    } else {
                        feedUnit = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
                    }
                    graphQLVideoChannelFeedEdge.f13446d = feedUnit;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChannelFeedEdge, "node", graphQLVideoChannelFeedEdge.a_, 0, true);
                } else {
                    int i2 = 0;
                }
                jsonParser.f();
            }
        }
        return graphQLVideoChannelFeedEdge;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoChannelFeedEdge.class, new GraphQLVideoChannelFeedEdgeDeserializer());
    }

    public GraphQLVideoChannelFeedEdgeDeserializer() {
        a(GraphQLVideoChannelFeedEdge.class);
    }
}
