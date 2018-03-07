package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pickupDeliveryInfo */
public class GraphQLBackdatedTimeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBackdatedTime.class, new GraphQLBackdatedTimeDeserializer());
    }

    public GraphQLBackdatedTimeDeserializer() {
        a(GraphQLBackdatedTime.class);
    }

    public Object m6631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBackdatedTime__JsonHelper.m6633a(jsonParser);
    }
}
