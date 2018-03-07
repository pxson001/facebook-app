package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsComposerConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: View Hierarchy json attached. */
public final class GraphQLPrivacyOptionsComposerConnection$Serializer extends JsonSerializer<GraphQLPrivacyOptionsComposerConnection> {
    public final void m20996a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsComposerConnection graphQLPrivacyOptionsComposerConnection = (GraphQLPrivacyOptionsComposerConnection) obj;
        GraphQLPrivacyOptionsComposerConnectionDeserializer.m5693a(graphQLPrivacyOptionsComposerConnection.w_(), graphQLPrivacyOptionsComposerConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsComposerConnection.class, new GraphQLPrivacyOptionsComposerConnection$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyOptionsComposerConnection.class, new GraphQLPrivacyOptionsComposerConnection$Serializer());
    }
}
