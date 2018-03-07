package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: journal.bkp */
public class GraphQLAggregatedEntitiesAtRangeSerializer extends JsonSerializer<GraphQLAggregatedEntitiesAtRange> {
    public final void m6501a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAggregatedEntitiesAtRange__JsonHelper.m6503a(jsonGenerator, (GraphQLAggregatedEntitiesAtRange) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAggregatedEntitiesAtRange.class, new GraphQLAggregatedEntitiesAtRangeSerializer());
    }
}
