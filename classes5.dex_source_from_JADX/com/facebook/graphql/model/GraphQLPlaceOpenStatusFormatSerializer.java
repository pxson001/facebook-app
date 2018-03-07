package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEATHER */
public class GraphQLPlaceOpenStatusFormatSerializer extends JsonSerializer<GraphQLPlaceOpenStatusFormat> {
    public final void m20885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceOpenStatusFormat__JsonHelper.m20887a(jsonGenerator, (GraphQLPlaceOpenStatusFormat) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceOpenStatusFormat.class, new GraphQLPlaceOpenStatusFormatSerializer());
    }
}
