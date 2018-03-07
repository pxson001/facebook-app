package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: image_blurred */
public class GraphQLEventUserBlockResponsePayloadSerializer extends JsonSerializer<GraphQLEventUserBlockResponsePayload> {
    public final void m7311a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventUserBlockResponsePayload graphQLEventUserBlockResponsePayload = (GraphQLEventUserBlockResponsePayload) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEventUserBlockResponsePayload.m7308a() != null) {
            jsonGenerator.a("user");
            GraphQLUser__JsonHelper.a(jsonGenerator, graphQLEventUserBlockResponsePayload.m7308a(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEventUserBlockResponsePayload.class, new GraphQLEventUserBlockResponsePayloadSerializer());
    }
}
