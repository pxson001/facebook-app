package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UI-thread */
public class GraphQLTopReactionsEdgeSerializer extends JsonSerializer<GraphQLTopReactionsEdge> {
    public final void m22256a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopReactionsEdge__JsonHelper.a(jsonGenerator, (GraphQLTopReactionsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTopReactionsEdge.class, new GraphQLTopReactionsEdgeSerializer());
    }
}
