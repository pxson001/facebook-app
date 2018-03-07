package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: needsInitialFetch */
public class GraphQLQuantityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuantity.class, new GraphQLQuantityDeserializer());
    }

    public GraphQLQuantityDeserializer() {
        a(GraphQLQuantity.class);
    }

    public Object m21147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLQuantity__JsonHelper.m21149a(jsonParser);
    }
}
