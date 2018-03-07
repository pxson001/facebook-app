package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimelineSectionUnitsConnection */
public class GraphQLUserWorkExperiencesEdgeSerializer extends JsonSerializer<GraphQLUserWorkExperiencesEdge> {
    public final void m22413a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUserWorkExperiencesEdge__JsonHelper.m22415a(jsonGenerator, (GraphQLUserWorkExperiencesEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLUserWorkExperiencesEdge.class, new GraphQLUserWorkExperiencesEdgeSerializer());
    }
}
