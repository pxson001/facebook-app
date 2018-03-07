package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: jewel_divebar_promotion_fragment */
public class GraphQLAlbumsConnectionSerializer extends JsonSerializer<GraphQLAlbumsConnection> {
    public final void m6517a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAlbumsConnection__JsonHelper.m6519a(jsonGenerator, (GraphQLAlbumsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAlbumsConnection.class, new GraphQLAlbumsConnectionSerializer());
    }
}
