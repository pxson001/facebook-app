package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPlaceListItemsFromPlaceListConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEATHER_FORECAST */
public final class GraphQLPlaceListItemsFromPlaceListConnection$Serializer extends JsonSerializer<GraphQLPlaceListItemsFromPlaceListConnection> {
    public final void m20877a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceListItemsFromPlaceListConnection graphQLPlaceListItemsFromPlaceListConnection = (GraphQLPlaceListItemsFromPlaceListConnection) obj;
        GraphQLPlaceListItemsFromPlaceListConnectionDeserializer.m5654a(graphQLPlaceListItemsFromPlaceListConnection.w_(), graphQLPlaceListItemsFromPlaceListConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceListItemsFromPlaceListConnection.class, new GraphQLPlaceListItemsFromPlaceListConnection$Serializer());
        FbSerializerProvider.a(GraphQLPlaceListItemsFromPlaceListConnection.class, new GraphQLPlaceListItemsFromPlaceListConnection$Serializer());
    }
}
