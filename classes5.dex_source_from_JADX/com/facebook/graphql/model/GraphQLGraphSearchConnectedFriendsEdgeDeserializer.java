package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_appointment_status */
public class GraphQLGraphSearchConnectedFriendsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchConnectedFriendsEdge.class, new GraphQLGraphSearchConnectedFriendsEdgeDeserializer());
    }

    public GraphQLGraphSearchConnectedFriendsEdgeDeserializer() {
        a(GraphQLGraphSearchConnectedFriendsEdge.class);
    }

    public Object m8153a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchConnectedFriendsEdge__JsonHelper.m8155a(jsonParser);
    }
}
