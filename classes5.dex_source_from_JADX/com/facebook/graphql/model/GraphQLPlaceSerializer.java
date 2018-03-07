package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATCHED_VIDEOS */
public class GraphQLPlaceSerializer extends JsonSerializer<GraphQLPlace> {
    public final void m20913a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlace__JsonHelper.m20922a(jsonGenerator, (GraphQLPlace) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlace.class, new GraphQLPlaceSerializer());
    }
}
