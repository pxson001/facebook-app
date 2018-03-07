package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: outgoing_requests */
public class GraphQLGroupMembersEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMembersEdge.class, new GraphQLGroupMembersEdgeDeserializer());
    }

    public GraphQLGroupMembersEdgeDeserializer() {
        a(GraphQLGroupMembersEdge.class);
    }

    public Object m8467a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupMembersEdge__JsonHelper.m8469a(jsonParser);
    }
}
