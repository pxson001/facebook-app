package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVideoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimelineAppCollectionItem */
public final class GraphQLVideo$Serializer extends JsonSerializer<GraphQLVideo> {
    public final void m22424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideo graphQLVideo = (GraphQLVideo) obj;
        GraphQLVideoDeserializer.m6186a(graphQLVideo.w_(), graphQLVideo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLVideo.class, new GraphQLVideo$Serializer());
        FbSerializerProvider.a(GraphQLVideo.class, new GraphQLVideo$Serializer());
    }
}
