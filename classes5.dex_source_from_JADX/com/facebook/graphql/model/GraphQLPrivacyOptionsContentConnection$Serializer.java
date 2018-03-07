package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VideoTimestampedCommentsEdge */
public final class GraphQLPrivacyOptionsContentConnection$Serializer extends JsonSerializer<GraphQLPrivacyOptionsContentConnection> {
    public final void m21006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsContentConnection graphQLPrivacyOptionsContentConnection = (GraphQLPrivacyOptionsContentConnection) obj;
        GraphQLPrivacyOptionsContentConnectionDeserializer.m5699a(graphQLPrivacyOptionsContentConnection.w_(), graphQLPrivacyOptionsContentConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsContentConnection.class, new GraphQLPrivacyOptionsContentConnection$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyOptionsContentConnection.class, new GraphQLPrivacyOptionsContentConnection$Serializer());
    }
}
