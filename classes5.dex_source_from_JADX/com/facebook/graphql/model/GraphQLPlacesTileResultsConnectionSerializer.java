package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WASH_TEXTS */
public class GraphQLPlacesTileResultsConnectionSerializer extends JsonSerializer<GraphQLPlacesTileResultsConnection> {
    public final void m20930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlacesTileResultsConnection graphQLPlacesTileResultsConnection = (GraphQLPlacesTileResultsConnection) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLPlacesTileResultsConnection.m20928a() != null) {
            jsonGenerator.d();
            for (GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge : graphQLPlacesTileResultsConnection.m20928a()) {
                if (graphQLPlacesTileResultsEdge != null) {
                    GraphQLPlacesTileResultsEdge__JsonHelper.m20943a(jsonGenerator, graphQLPlacesTileResultsEdge, true);
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
        FbSerializerProvider.a(GraphQLPlacesTileResultsConnection.class, new GraphQLPlacesTileResultsConnectionSerializer());
    }
}
