package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UnwrappingBeanSerializer for  */
public class GraphQLSouvenirMediaEdgeSerializer extends JsonSerializer<GraphQLSouvenirMediaEdge> {
    public final void m21714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSouvenirMediaEdge__JsonHelper.m21716a(jsonGenerator, (GraphQLSouvenirMediaEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSouvenirMediaEdge.class, new GraphQLSouvenirMediaEdgeSerializer());
    }
}
