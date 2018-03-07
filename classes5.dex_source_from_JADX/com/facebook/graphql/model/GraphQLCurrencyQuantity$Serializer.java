package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCurrencyQuantityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_report_duplicate */
public final class GraphQLCurrencyQuantity$Serializer extends JsonSerializer<GraphQLCurrencyQuantity> {
    public final void m6921a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCurrencyQuantity graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) obj;
        GraphQLCurrencyQuantityDeserializer.m4702a(graphQLCurrencyQuantity.w_(), graphQLCurrencyQuantity.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLCurrencyQuantity.class, new GraphQLCurrencyQuantity$Serializer());
        FbSerializerProvider.a(GraphQLCurrencyQuantity.class, new GraphQLCurrencyQuantity$Serializer());
    }
}
