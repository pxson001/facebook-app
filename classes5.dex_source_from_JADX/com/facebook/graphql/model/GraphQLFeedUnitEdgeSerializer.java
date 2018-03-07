package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hookDoFrame */
public class GraphQLFeedUnitEdgeSerializer extends JsonSerializer<GraphQLFeedUnitEdge> {
    public final void m7470a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedUnitEdge__JsonHelper.m7472a(jsonGenerator, (GraphQLFeedUnitEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedUnitEdge.class, new GraphQLFeedUnitEdgeSerializer());
    }
}
