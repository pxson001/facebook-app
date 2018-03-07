package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: entry_point */
public class GraphQLPYMLWithLargeImageFeedUnitsEdgeSerializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnitsEdge> {
    public final void m9457a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnitsEdge__JsonHelper.m9459a(jsonGenerator, (GraphQLPYMLWithLargeImageFeedUnitsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitsEdge.class, new GraphQLPYMLWithLargeImageFeedUnitsEdgeSerializer());
    }
}
