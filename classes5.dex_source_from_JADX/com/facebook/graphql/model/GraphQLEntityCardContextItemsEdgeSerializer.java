package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: intent_extras */
public class GraphQLEntityCardContextItemsEdgeSerializer extends JsonSerializer<GraphQLEntityCardContextItemsEdge> {
    public final void m7092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEntityCardContextItemsEdge graphQLEntityCardContextItemsEdge = (GraphQLEntityCardContextItemsEdge) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEntityCardContextItemsEdge.m7089a() != null) {
            jsonGenerator.a("node");
            GraphQLEntityCardContextItem__JsonHelper.m7084a(jsonGenerator, graphQLEntityCardContextItemsEdge.m7089a(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEntityCardContextItemsEdge.class, new GraphQLEntityCardContextItemsEdgeSerializer());
    }
}
