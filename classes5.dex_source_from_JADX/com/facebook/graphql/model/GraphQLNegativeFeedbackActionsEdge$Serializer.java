package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionsEdgeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: events_occurring_here */
public final class GraphQLNegativeFeedbackActionsEdge$Serializer extends JsonSerializer<GraphQLNegativeFeedbackActionsEdge> {
    public final void m9246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) obj;
        GraphQLNegativeFeedbackActionsEdgeDeserializer.m5420b(graphQLNegativeFeedbackActionsEdge.w_(), graphQLNegativeFeedbackActionsEdge.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLNegativeFeedbackActionsEdge.class, new GraphQLNegativeFeedbackActionsEdge$Serializer());
        FbSerializerProvider.a(GraphQLNegativeFeedbackActionsEdge.class, new GraphQLNegativeFeedbackActionsEdge$Serializer());
    }
}
