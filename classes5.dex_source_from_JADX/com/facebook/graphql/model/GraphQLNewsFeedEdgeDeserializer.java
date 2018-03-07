package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og-tagger-click */
public class GraphQLNewsFeedEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNewsFeedEdge.class, new GraphQLNewsFeedEdgeDeserializer());
    }

    public GraphQLNewsFeedEdgeDeserializer() {
        a(GraphQLNewsFeedEdge.class);
    }

    public Object m9260a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNewsFeedEdge__JsonHelper.m9262a(jsonParser);
    }
}
