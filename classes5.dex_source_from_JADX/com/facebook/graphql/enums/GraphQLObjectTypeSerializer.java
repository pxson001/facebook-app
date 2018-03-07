package com.facebook.graphql.enums;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: mLastErrorDetails */
public class GraphQLObjectTypeSerializer extends JsonSerializer<GraphQLObjectType> {
    public final void m6224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLObjectType graphQLObjectType = (GraphQLObjectType) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLObjectType.name != null) {
            jsonGenerator.a("name", graphQLObjectType.name);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLObjectType.class, new GraphQLObjectTypeSerializer());
    }
}
