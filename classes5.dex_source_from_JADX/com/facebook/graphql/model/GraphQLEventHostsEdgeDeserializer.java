package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: payment_request_id */
public class GraphQLEventHostsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventHostsEdge.class, new GraphQLEventHostsEdgeDeserializer());
    }

    public GraphQLEventHostsEdgeDeserializer() {
        a(GraphQLEventHostsEdge.class);
    }

    public Object m7198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventHostsEdge__JsonHelper.m7200a(jsonParser);
    }
}
