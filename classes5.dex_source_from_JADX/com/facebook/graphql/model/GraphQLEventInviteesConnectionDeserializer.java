package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: payment_info */
public class GraphQLEventInviteesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventInviteesConnection.class, new GraphQLEventInviteesConnectionDeserializer());
    }

    public GraphQLEventInviteesConnectionDeserializer() {
        a(GraphQLEventInviteesConnection.class);
    }

    public Object m7204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventInviteesConnection__JsonHelper.m7206a(jsonParser);
    }
}
