package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_retriable */
public class GraphQLAttributionEntrySerializer extends JsonSerializer<GraphQLAttributionEntry> {
    public final void m6615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAttributionEntry__JsonHelper.m6617a(jsonGenerator, (GraphQLAttributionEntry) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAttributionEntry.class, new GraphQLAttributionEntrySerializer());
    }
}
