package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VideoGuidedTour */
public class GraphQLPrivacyOptionsContentEdgeSerializer extends JsonSerializer<GraphQLPrivacyOptionsContentEdge> {
    public final void m21016a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsContentEdge__JsonHelper.m21018a(jsonGenerator, (GraphQLPrivacyOptionsContentEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsContentEdge.class, new GraphQLPrivacyOptionsContentEdgeSerializer());
    }
}
