package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSeenByConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_EDIT_BUTTON */
public final class GraphQLSeenByConnection$Serializer extends JsonSerializer<GraphQLSeenByConnection> {
    public final void m21630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSeenByConnection graphQLSeenByConnection = (GraphQLSeenByConnection) obj;
        GraphQLSeenByConnectionDeserializer.m5879a(graphQLSeenByConnection.w_(), graphQLSeenByConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSeenByConnection.class, new GraphQLSeenByConnection$Serializer());
        FbSerializerProvider.a(GraphQLSeenByConnection.class, new GraphQLSeenByConnection$Serializer());
    }
}
