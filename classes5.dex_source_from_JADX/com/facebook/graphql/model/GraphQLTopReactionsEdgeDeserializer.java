package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minutiaeTag */
public class GraphQLTopReactionsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopReactionsEdge.class, new GraphQLTopReactionsEdgeDeserializer());
    }

    public GraphQLTopReactionsEdgeDeserializer() {
        a(GraphQLTopReactionsEdge.class);
    }

    public Object m22255a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTopReactionsEdge__JsonHelper.a(jsonParser);
    }
}
