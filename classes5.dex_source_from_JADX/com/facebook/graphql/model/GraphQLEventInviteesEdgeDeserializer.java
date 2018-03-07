package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: payment_id */
public class GraphQLEventInviteesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventInviteesEdge.class, new GraphQLEventInviteesEdgeDeserializer());
    }

    public GraphQLEventInviteesEdgeDeserializer() {
        a(GraphQLEventInviteesEdge.class);
    }

    public Object m7215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventInviteesEdge__JsonHelper.m7217a(jsonParser);
    }
}
