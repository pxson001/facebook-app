package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fallback_uri */
public class GraphQLMediaSetSerializer extends JsonSerializer<GraphQLMediaSet> {
    public final void m9075a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaSet__JsonHelper.m9077a(jsonGenerator, (GraphQLMediaSet) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaSet.class, new GraphQLMediaSetSerializer());
    }
}
