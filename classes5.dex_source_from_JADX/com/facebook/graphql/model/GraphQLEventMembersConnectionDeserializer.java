package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: passenger_seat_label */
public class GraphQLEventMembersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventMembersConnection.class, new GraphQLEventMembersConnectionDeserializer());
    }

    public GraphQLEventMembersConnectionDeserializer() {
        a(GraphQLEventMembersConnection.class);
    }

    public Object m7243a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventMembersConnection__JsonHelper.m7245a(jsonParser);
    }
}
