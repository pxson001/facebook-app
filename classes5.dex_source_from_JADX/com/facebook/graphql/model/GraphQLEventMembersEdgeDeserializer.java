package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: passenger_names_label */
public class GraphQLEventMembersEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventMembersEdge.class, new GraphQLEventMembersEdgeDeserializer());
    }

    public GraphQLEventMembersEdgeDeserializer() {
        a(GraphQLEventMembersEdge.class);
    }

    public Object m7256a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventMembersEdge__JsonHelper.m7258a(jsonParser);
    }
}
