package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryTopicsContextDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_INTERACTIONS */
public final class GraphQLStoryTopicsContext$Serializer extends JsonSerializer<GraphQLStoryTopicsContext> {
    public final void m21917a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryTopicsContext graphQLStoryTopicsContext = (GraphQLStoryTopicsContext) obj;
        GraphQLStoryTopicsContextDeserializer.m5990a(graphQLStoryTopicsContext.w_(), graphQLStoryTopicsContext.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryTopicsContext.class, new GraphQLStoryTopicsContext$Serializer());
        FbSerializerProvider.a(GraphQLStoryTopicsContext.class, new GraphQLStoryTopicsContext$Serializer());
    }
}
