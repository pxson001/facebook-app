package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: item_type */
public class GraphQLAppAdStoriesSideFeedEdgeSerializer extends JsonSerializer<GraphQLAppAdStoriesSideFeedEdge> {
    public final void m6557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAppAdStoriesSideFeedEdge__JsonHelper.m6559a(jsonGenerator, (GraphQLAppAdStoriesSideFeedEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAppAdStoriesSideFeedEdge.class, new GraphQLAppAdStoriesSideFeedEdgeSerializer());
    }
}
