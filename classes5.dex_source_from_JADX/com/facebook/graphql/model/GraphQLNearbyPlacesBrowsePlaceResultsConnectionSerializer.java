package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: expiration_time */
public class GraphQLNearbyPlacesBrowsePlaceResultsConnectionSerializer extends JsonSerializer<GraphQLNearbyPlacesBrowsePlaceResultsConnection> {
    public final void m9207a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNearbyPlacesBrowsePlaceResultsConnection__JsonHelper.m9209a(jsonGenerator, (GraphQLNearbyPlacesBrowsePlaceResultsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class, new GraphQLNearbyPlacesBrowsePlaceResultsConnectionSerializer());
    }
}
