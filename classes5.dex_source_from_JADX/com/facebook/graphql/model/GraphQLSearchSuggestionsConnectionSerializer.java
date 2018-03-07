package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_INLINE_CONFIRMATION */
public class GraphQLSearchSuggestionsConnectionSerializer extends JsonSerializer<GraphQLSearchSuggestionsConnection> {
    public final void m21616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSearchSuggestionsConnection graphQLSearchSuggestionsConnection = (GraphQLSearchSuggestionsConnection) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLSearchSuggestionsConnection.m21614a() != null) {
            jsonGenerator.d();
            for (GraphQLSearchSuggestionsEdge graphQLSearchSuggestionsEdge : graphQLSearchSuggestionsConnection.m21614a()) {
                if (graphQLSearchSuggestionsEdge != null) {
                    GraphQLSearchSuggestionsEdge__JsonHelper.m21627a(jsonGenerator, graphQLSearchSuggestionsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSearchSuggestionsConnection.class, new GraphQLSearchSuggestionsConnectionSerializer());
    }
}
