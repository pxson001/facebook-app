package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ToolbarWidgetWrapper */
public class GraphQLUserEducationExperiencesEdgeSerializer extends JsonSerializer<GraphQLUserEducationExperiencesEdge> {
    public final void m22397a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUserEducationExperiencesEdge__JsonHelper.m22399a(jsonGenerator, (GraphQLUserEducationExperiencesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLUserEducationExperiencesEdge.class, new GraphQLUserEducationExperiencesEdgeSerializer());
    }
}
