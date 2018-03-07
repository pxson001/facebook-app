package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: otherEventInvitees */
public class GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class, new GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer());
    }

    public GraphQLGroupTopStoriesFeedUnitStoriesEdgeDeserializer() {
        a(GraphQLGroupTopStoriesFeedUnitStoriesEdge.class);
    }

    public Object m8513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupTopStoriesFeedUnitStoriesEdge__JsonHelper.m8515a(jsonParser);
    }
}
