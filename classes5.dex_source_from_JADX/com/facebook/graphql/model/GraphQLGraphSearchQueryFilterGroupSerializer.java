package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: generateSerializer */
public class GraphQLGraphSearchQueryFilterGroupSerializer extends JsonSerializer<GraphQLGraphSearchQueryFilterGroup> {
    public final void m8232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryFilterGroup__JsonHelper.m8234a(jsonGenerator, (GraphQLGraphSearchQueryFilterGroup) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilterGroup.class, new GraphQLGraphSearchQueryFilterGroupSerializer());
    }
}
