package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_unpublished_posts_card */
public class GraphQLFeedUnitEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedUnitEdge.class, new GraphQLFeedUnitEdgeDeserializer());
    }

    public GraphQLFeedUnitEdgeDeserializer() {
        a(GraphQLFeedUnitEdge.class);
    }

    public Object m7469a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFeedUnitEdge__JsonHelper.m7471a(jsonParser);
    }
}
