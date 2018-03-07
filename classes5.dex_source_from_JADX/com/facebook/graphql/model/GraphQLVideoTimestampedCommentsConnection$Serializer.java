package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVideoTimestampedCommentsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: The max capacity  */
public final class GraphQLVideoTimestampedCommentsConnection$Serializer extends JsonSerializer<GraphQLVideoTimestampedCommentsConnection> {
    public final void m22469a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoTimestampedCommentsConnection graphQLVideoTimestampedCommentsConnection = (GraphQLVideoTimestampedCommentsConnection) obj;
        GraphQLVideoTimestampedCommentsConnectionDeserializer.m6195a(graphQLVideoTimestampedCommentsConnection.w_(), graphQLVideoTimestampedCommentsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoTimestampedCommentsConnection.class, new GraphQLVideoTimestampedCommentsConnection$Serializer());
        FbSerializerProvider.a(GraphQLVideoTimestampedCommentsConnection.class, new GraphQLVideoTimestampedCommentsConnection$Serializer());
    }
}
