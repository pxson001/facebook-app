package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_notifications_tab */
public class GraphQLStreetAddressDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStreetAddress.class, new GraphQLStreetAddressDeserializer());
    }

    public GraphQLStreetAddressDeserializer() {
        a(GraphQLStreetAddress.class);
    }

    public Object m21934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStreetAddress__JsonHelper.m21936a(jsonParser);
    }
}
