package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionsContentEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VideoGuidedTourKeyframe */
public final class GraphQLPrivacyOptionsContentEdge$Serializer extends JsonSerializer<GraphQLPrivacyOptionsContentEdge> {
    public final void m21014a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge = (GraphQLPrivacyOptionsContentEdge) obj;
        GraphQLPrivacyOptionsContentEdgeDeserializer.m5704b(graphQLPrivacyOptionsContentEdge.w_(), graphQLPrivacyOptionsContentEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsContentEdge.class, new GraphQLPrivacyOptionsContentEdge$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyOptionsContentEdge.class, new GraphQLPrivacyOptionsContentEdge$Serializer());
    }
}
