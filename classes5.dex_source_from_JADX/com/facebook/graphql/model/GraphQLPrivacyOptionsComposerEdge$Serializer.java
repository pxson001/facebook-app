package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsComposerEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: View Hierarchy Debug Info */
public final class GraphQLPrivacyOptionsComposerEdge$Serializer extends JsonSerializer<GraphQLPrivacyOptionsComposerEdge> {
    public final void m21000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsComposerEdge graphQLPrivacyOptionsComposerEdge = (GraphQLPrivacyOptionsComposerEdge) obj;
        GraphQLPrivacyOptionsComposerEdgeDeserializer.m5696b(graphQLPrivacyOptionsComposerEdge.w_(), graphQLPrivacyOptionsComposerEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsComposerEdge.class, new GraphQLPrivacyOptionsComposerEdge$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyOptionsComposerEdge.class, new GraphQLPrivacyOptionsComposerEdge$Serializer());
    }
}
