package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryHeaderDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to fetch user credentials from FbSharedPreferences. */
public final class GraphQLStoryHeader$Serializer extends JsonSerializer<GraphQLStoryHeader> {
    public final void m21872a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryHeader graphQLStoryHeader = (GraphQLStoryHeader) obj;
        GraphQLStoryHeaderDeserializer.m5972a(graphQLStoryHeader.w_(), graphQLStoryHeader.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryHeader.class, new GraphQLStoryHeader$Serializer());
        FbSerializerProvider.a(GraphQLStoryHeader.class, new GraphQLStoryHeader$Serializer());
    }
}
