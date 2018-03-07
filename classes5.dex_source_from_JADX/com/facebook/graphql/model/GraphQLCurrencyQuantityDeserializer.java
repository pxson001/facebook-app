package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phone_screenshots */
public class GraphQLCurrencyQuantityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCurrencyQuantity.class, new GraphQLCurrencyQuantityDeserializer());
    }

    public GraphQLCurrencyQuantityDeserializer() {
        a(GraphQLCurrencyQuantity.class);
    }

    public Object m6922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCurrencyQuantity__JsonHelper.m6924a(jsonParser);
    }
}
