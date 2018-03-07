package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: message_permalink */
public class GraphQLVideoTimestampedCommentsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoTimestampedCommentsEdge.class, new GraphQLVideoTimestampedCommentsEdgeDeserializer());
    }

    public GraphQLVideoTimestampedCommentsEdgeDeserializer() {
        a(GraphQLVideoTimestampedCommentsEdge.class);
    }

    public Object m22479a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideoTimestampedCommentsEdge__JsonHelper.m22481a(jsonParser);
    }
}
