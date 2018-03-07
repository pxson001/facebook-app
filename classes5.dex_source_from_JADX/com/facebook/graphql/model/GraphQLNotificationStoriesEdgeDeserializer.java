package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offer_code */
public class GraphQLNotificationStoriesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNotificationStoriesEdge.class, new GraphQLNotificationStoriesEdgeDeserializer());
    }

    public GraphQLNotificationStoriesEdgeDeserializer() {
        a(GraphQLNotificationStoriesEdge.class);
    }

    public Object m9387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNotificationStoriesEdge__JsonHelper.m9389a(jsonParser);
    }
}
