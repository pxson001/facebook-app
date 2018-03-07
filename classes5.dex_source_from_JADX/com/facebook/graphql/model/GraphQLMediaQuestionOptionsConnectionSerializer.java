package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb4a.debug.digraph.running */
public class GraphQLMediaQuestionOptionsConnectionSerializer extends JsonSerializer<GraphQLMediaQuestionOptionsConnection> {
    public final void m9048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaQuestionOptionsConnection__JsonHelper.m9050a(jsonGenerator, (GraphQLMediaQuestionOptionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaQuestionOptionsConnection.class, new GraphQLMediaQuestionOptionsConnectionSerializer());
    }
}
