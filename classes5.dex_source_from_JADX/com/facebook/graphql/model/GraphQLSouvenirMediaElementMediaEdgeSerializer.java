package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unsupported */
public class GraphQLSouvenirMediaElementMediaEdgeSerializer extends JsonSerializer<GraphQLSouvenirMediaElementMediaEdge> {
    public final void m21744a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenirMediaElementMediaEdge__JsonHelper.m21746a(jsonGenerator, (GraphQLSouvenirMediaElementMediaEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenirMediaElementMediaEdge.class, new GraphQLSouvenirMediaElementMediaEdgeSerializer());
    }
}
