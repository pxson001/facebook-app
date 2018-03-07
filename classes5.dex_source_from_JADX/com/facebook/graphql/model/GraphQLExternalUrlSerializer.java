package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: icon_background_color */
public class GraphQLExternalUrlSerializer extends JsonSerializer<GraphQLExternalUrl> {
    public final void m7428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLExternalUrl__JsonHelper.m7430a(jsonGenerator, (GraphQLExternalUrl) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLExternalUrl.class, new GraphQLExternalUrlSerializer());
    }
}
