package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLikersOfContentConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: featured_video_attachments */
public final class GraphQLLikersOfContentConnection$Serializer extends JsonSerializer<GraphQLLikersOfContentConnection> {
    public final void m8917a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection = (GraphQLLikersOfContentConnection) obj;
        GraphQLLikersOfContentConnectionDeserializer.m5320a(graphQLLikersOfContentConnection.w_(), graphQLLikersOfContentConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLLikersOfContentConnection.class, new GraphQLLikersOfContentConnection$Serializer());
        FbSerializerProvider.a(GraphQLLikersOfContentConnection.class, new GraphQLLikersOfContentConnection$Serializer());
    }
}
