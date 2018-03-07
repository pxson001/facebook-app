package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_browser */
public final class GraphQLGroupOwnerAuthoredStoriesConnection$Serializer extends JsonSerializer<GraphQLGroupOwnerAuthoredStoriesConnection> {
    public final void m8487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupOwnerAuthoredStoriesConnection graphQLGroupOwnerAuthoredStoriesConnection = (GraphQLGroupOwnerAuthoredStoriesConnection) obj;
        GraphQLGroupOwnerAuthoredStoriesConnectionDeserializer.m5184a(graphQLGroupOwnerAuthoredStoriesConnection.w_(), graphQLGroupOwnerAuthoredStoriesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupOwnerAuthoredStoriesConnection.class, new GraphQLGroupOwnerAuthoredStoriesConnection$Serializer());
        FbSerializerProvider.a(GraphQLGroupOwnerAuthoredStoriesConnection.class, new GraphQLGroupOwnerAuthoredStoriesConnection$Serializer());
    }
}
