package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryActionLinkDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve version number */
public final class GraphQLStoryActionLink$Serializer extends JsonSerializer<GraphQLStoryActionLink> {
    public final void m21844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) obj;
        GraphQLStoryActionLinkDeserializer.m5952b(graphQLStoryActionLink.w_(), graphQLStoryActionLink.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryActionLink.class, new GraphQLStoryActionLink$Serializer());
        FbSerializerProvider.a(GraphQLStoryActionLink.class, new GraphQLStoryActionLink$Serializer());
    }
}
