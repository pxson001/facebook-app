package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_post_suggest_edits_upsell */
public class GraphQLCurrencyQuantitySerializer extends JsonSerializer<GraphQLCurrencyQuantity> {
    public final void m6923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCurrencyQuantity__JsonHelper.m6925a(jsonGenerator, (GraphQLCurrencyQuantity) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCurrencyQuantity.class, new GraphQLCurrencyQuantitySerializer());
    }
}
