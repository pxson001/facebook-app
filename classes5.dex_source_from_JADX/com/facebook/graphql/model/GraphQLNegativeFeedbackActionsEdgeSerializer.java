package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: events_list */
public class GraphQLNegativeFeedbackActionsEdgeSerializer extends JsonSerializer<GraphQLNegativeFeedbackActionsEdge> {
    public final void m9248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNegativeFeedbackActionsEdge__JsonHelper.m9250a(jsonGenerator, (GraphQLNegativeFeedbackActionsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNegativeFeedbackActionsEdge.class, new GraphQLNegativeFeedbackActionsEdgeSerializer());
    }
}
