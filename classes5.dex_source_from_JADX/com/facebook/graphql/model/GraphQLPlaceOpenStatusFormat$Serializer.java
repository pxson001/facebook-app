package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPlaceOpenStatusFormatDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEATHER_CONDITION_ALERT */
public final class GraphQLPlaceOpenStatusFormat$Serializer extends JsonSerializer<GraphQLPlaceOpenStatusFormat> {
    public final void m20883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceOpenStatusFormat graphQLPlaceOpenStatusFormat = (GraphQLPlaceOpenStatusFormat) obj;
        GraphQLPlaceOpenStatusFormatDeserializer.m5659b(graphQLPlaceOpenStatusFormat.w_(), graphQLPlaceOpenStatusFormat.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceOpenStatusFormat.class, new GraphQLPlaceOpenStatusFormat$Serializer());
        FbSerializerProvider.a(GraphQLPlaceOpenStatusFormat.class, new GraphQLPlaceOpenStatusFormat$Serializer());
    }
}
