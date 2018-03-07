package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_WEBSITE */
public class GraphQLQuantitySerializer extends JsonSerializer<GraphQLQuantity> {
    public final void m21148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuantity graphQLQuantity = (GraphQLQuantity) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLQuantity.m21144a() != null) {
            jsonGenerator.a("unit", graphQLQuantity.m21144a());
        }
        jsonGenerator.a("value", graphQLQuantity.m21146j());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLQuantity.class, new GraphQLQuantitySerializer());
    }
}
