package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLOpenGraphMetadataDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_action_history */
public final class GraphQLOpenGraphMetadata$Serializer extends JsonSerializer<GraphQLOpenGraphMetadata> {
    public final void m9399a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOpenGraphMetadata graphQLOpenGraphMetadata = (GraphQLOpenGraphMetadata) obj;
        GraphQLOpenGraphMetadataDeserializer.m5464a(graphQLOpenGraphMetadata.w_(), graphQLOpenGraphMetadata.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLOpenGraphMetadata.class, new GraphQLOpenGraphMetadata$Serializer());
        FbSerializerProvider.a(GraphQLOpenGraphMetadata.class, new GraphQLOpenGraphMetadata$Serializer());
    }
}
