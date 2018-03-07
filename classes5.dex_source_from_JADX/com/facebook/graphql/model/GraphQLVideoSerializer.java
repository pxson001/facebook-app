package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: The meta info has not been sync'd */
public class GraphQLVideoSerializer extends JsonSerializer<GraphQLVideo> {
    public final void m22467a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideo__JsonHelper.m22484a(jsonGenerator, (GraphQLVideo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideo.class, new GraphQLVideoSerializer());
    }
}
