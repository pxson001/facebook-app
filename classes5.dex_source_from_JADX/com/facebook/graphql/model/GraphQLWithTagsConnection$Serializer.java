package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLWithTagsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TargetingDescription */
public final class GraphQLWithTagsConnection$Serializer extends JsonSerializer<GraphQLWithTagsConnection> {
    public final void m22497a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWithTagsConnection graphQLWithTagsConnection = (GraphQLWithTagsConnection) obj;
        GraphQLWithTagsConnectionDeserializer.m6207a(graphQLWithTagsConnection.w_(), graphQLWithTagsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLWithTagsConnection.class, new GraphQLWithTagsConnection$Serializer());
        FbSerializerProvider.a(GraphQLWithTagsConnection.class, new GraphQLWithTagsConnection$Serializer());
    }
}
