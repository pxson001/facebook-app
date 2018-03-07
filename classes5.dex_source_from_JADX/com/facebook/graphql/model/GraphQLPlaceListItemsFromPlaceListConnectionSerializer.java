package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEATHER_CONDITION_WIDE */
public class GraphQLPlaceListItemsFromPlaceListConnectionSerializer extends JsonSerializer<GraphQLPlaceListItemsFromPlaceListConnection> {
    public final void m20879a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceListItemsFromPlaceListConnection__JsonHelper.m20881a(jsonGenerator, (GraphQLPlaceListItemsFromPlaceListConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceListItemsFromPlaceListConnection.class, new GraphQLPlaceListItemsFromPlaceListConnectionSerializer());
    }
}
