package com.facebook.graphql.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fbLogoBadgeStyle */
public class GraphQLMapTileNodeSerializer extends JsonSerializer<GraphQLMapTileNode> {
    public final void m8999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMapTileNode graphQLMapTileNode = (GraphQLMapTileNode) obj;
        if (graphQLMapTileNode == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8998b(graphQLMapTileNode, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GraphQLMapTileNode.class, new GraphQLMapTileNodeSerializer());
    }

    private static void m8998b(GraphQLMapTileNode graphQLMapTileNode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "node", graphQLMapTileNode.tile);
    }
}
