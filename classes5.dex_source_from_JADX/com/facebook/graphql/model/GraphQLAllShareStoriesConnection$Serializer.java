package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAllShareStoriesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: java.util */
public final class GraphQLAllShareStoriesConnection$Serializer extends JsonSerializer<GraphQLAllShareStoriesConnection> {
    public final void m6531a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAllShareStoriesConnection graphQLAllShareStoriesConnection = (GraphQLAllShareStoriesConnection) obj;
        GraphQLAllShareStoriesConnectionDeserializer.m4560a(graphQLAllShareStoriesConnection.w_(), graphQLAllShareStoriesConnection.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLAllShareStoriesConnection.class, new GraphQLAllShareStoriesConnection$Serializer());
        FbSerializerProvider.a(GraphQLAllShareStoriesConnection.class, new GraphQLAllShareStoriesConnection$Serializer());
    }
}
