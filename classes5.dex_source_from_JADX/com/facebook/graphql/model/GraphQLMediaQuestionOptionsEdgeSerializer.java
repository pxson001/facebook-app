package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: favorited_bookmark_id */
public class GraphQLMediaQuestionOptionsEdgeSerializer extends JsonSerializer<GraphQLMediaQuestionOptionsEdge> {
    public final void m9057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaQuestionOptionsEdge__JsonHelper.m9059a(jsonGenerator, (GraphQLMediaQuestionOptionsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaQuestionOptionsEdge.class, new GraphQLMediaQuestionOptionsEdgeSerializer());
    }
}
