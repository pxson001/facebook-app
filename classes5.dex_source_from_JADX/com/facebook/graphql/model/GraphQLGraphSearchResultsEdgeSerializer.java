package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: full_relevant_comments */
public class GraphQLGraphSearchResultsEdgeSerializer extends JsonSerializer<GraphQLGraphSearchResultsEdge> {
    public final void m8308a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchResultsEdge__JsonHelper.m8310a(jsonGenerator, (GraphQLGraphSearchResultsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchResultsEdge.class, new GraphQLGraphSearchResultsEdgeSerializer());
    }
}
