package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLUserDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TopicCustomizationStory */
public final class GraphQLUser$Serializer extends JsonSerializer<GraphQLUser> {
    public final void m22383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUser graphQLUser = (GraphQLUser) obj;
        GraphQLUserDeserializer.m6152b(graphQLUser.w_(), graphQLUser.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLUser.class, new GraphQLUser$Serializer());
        FbSerializerProvider.a(GraphQLUser.class, new GraphQLUser$Serializer());
    }
}
