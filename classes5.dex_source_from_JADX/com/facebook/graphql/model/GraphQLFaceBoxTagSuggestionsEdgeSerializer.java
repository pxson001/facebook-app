package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: http.connection */
public class GraphQLFaceBoxTagSuggestionsEdgeSerializer extends JsonSerializer<GraphQLFaceBoxTagSuggestionsEdge> {
    public final void m7449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFaceBoxTagSuggestionsEdge__JsonHelper.m7451a(jsonGenerator, (GraphQLFaceBoxTagSuggestionsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFaceBoxTagSuggestionsEdge.class, new GraphQLFaceBoxTagSuggestionsEdgeSerializer());
    }
}
