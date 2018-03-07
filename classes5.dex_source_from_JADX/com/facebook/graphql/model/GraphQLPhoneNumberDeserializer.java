package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: noConnectivity */
public class GraphQLPhoneNumberDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhoneNumber.class, new GraphQLPhoneNumberDeserializer());
    }

    public GraphQLPhoneNumberDeserializer() {
        a(GraphQLPhoneNumber.class);
    }

    public Object m20711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhoneNumber__JsonHelper.m20713a(jsonParser);
    }
}
