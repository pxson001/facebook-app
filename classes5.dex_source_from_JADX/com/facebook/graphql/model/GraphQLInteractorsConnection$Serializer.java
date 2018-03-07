package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInteractorsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_typers */
public final class GraphQLInteractorsConnection$Serializer extends JsonSerializer<GraphQLInteractorsConnection> {
    public final void m8742a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInteractorsConnection graphQLInteractorsConnection = (GraphQLInteractorsConnection) obj;
        GraphQLInteractorsConnectionDeserializer.m5273a(graphQLInteractorsConnection.w_(), graphQLInteractorsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInteractorsConnection.class, new GraphQLInteractorsConnection$Serializer());
        FbSerializerProvider.a(GraphQLInteractorsConnection.class, new GraphQLInteractorsConnection$Serializer());
    }
}
