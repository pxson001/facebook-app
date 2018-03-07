package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEventWatchersConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imagePortrait */
public final class GraphQLEventWatchersConnection$Serializer extends JsonSerializer<GraphQLEventWatchersConnection> {
    public final void m7329a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventWatchersConnection graphQLEventWatchersConnection = (GraphQLEventWatchersConnection) obj;
        GraphQLEventWatchersConnectionDeserializer.m4847a(graphQLEventWatchersConnection.w_(), graphQLEventWatchersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEventWatchersConnection.class, new GraphQLEventWatchersConnection$Serializer());
        FbSerializerProvider.a(GraphQLEventWatchersConnection.class, new GraphQLEventWatchersConnection$Serializer());
    }
}
