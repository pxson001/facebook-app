package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: koshien_landing_page */
public class GraphQLAdditionalSuggestedPostAdItemsEdgeSerializer extends JsonSerializer<GraphQLAdditionalSuggestedPostAdItemsEdge> {
    public final void m6461a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAdditionalSuggestedPostAdItemsEdge__JsonHelper.m6463a(jsonGenerator, (GraphQLAdditionalSuggestedPostAdItemsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAdditionalSuggestedPostAdItemsEdge.class, new GraphQLAdditionalSuggestedPostAdItemsEdgeSerializer());
    }
}
