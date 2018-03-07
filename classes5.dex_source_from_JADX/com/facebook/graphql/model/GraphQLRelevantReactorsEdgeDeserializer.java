package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nativeMethod */
public class GraphQLRelevantReactorsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRelevantReactorsEdge.class, new GraphQLRelevantReactorsEdgeDeserializer());
    }

    public GraphQLRelevantReactorsEdgeDeserializer() {
        a(GraphQLRelevantReactorsEdge.class);
    }

    public Object m21395a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLRelevantReactorsEdge__JsonHelper.m21397a(jsonParser);
    }
}
