package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLRelevantReactorsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_LIST */
public final class GraphQLRelevantReactorsConnection$Serializer extends JsonSerializer<GraphQLRelevantReactorsConnection> {
    public final void m21385a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRelevantReactorsConnection graphQLRelevantReactorsConnection = (GraphQLRelevantReactorsConnection) obj;
        GraphQLRelevantReactorsConnectionDeserializer.m5806a(graphQLRelevantReactorsConnection.w_(), graphQLRelevantReactorsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLRelevantReactorsConnection.class, new GraphQLRelevantReactorsConnection$Serializer());
        FbSerializerProvider.a(GraphQLRelevantReactorsConnection.class, new GraphQLRelevantReactorsConnection$Serializer());
    }
}
