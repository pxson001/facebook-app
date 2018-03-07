package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: old_pin */
public class GraphQLMessengerContentSubscriptionOptionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMessengerContentSubscriptionOption.class, new GraphQLMessengerContentSubscriptionOptionDeserializer());
    }

    public GraphQLMessengerContentSubscriptionOptionDeserializer() {
        a(GraphQLMessengerContentSubscriptionOption.class);
    }

    public Object m9110a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMessengerContentSubscriptionOption__JsonHelper.m9112a(jsonParser);
    }
}
