package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: flight_label */
public class GraphQLImageSerializer extends JsonSerializer<GraphQLImage> {
    public final void m8633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImage__JsonHelper.a(jsonGenerator, (GraphQLImage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLImage.class, new GraphQLImageSerializer());
    }
}
