package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPlaceDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEB_SEARCH */
public final class GraphQLPlace$Serializer extends JsonSerializer<GraphQLPlace> {
    public final void m20835a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlace graphQLPlace = (GraphQLPlace) obj;
        GraphQLPlaceDeserializer.m5640a(graphQLPlace.w_(), graphQLPlace.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPlace.class, new GraphQLPlace$Serializer());
        FbSerializerProvider.a(GraphQLPlace.class, new GraphQLPlace$Serializer());
    }
}
