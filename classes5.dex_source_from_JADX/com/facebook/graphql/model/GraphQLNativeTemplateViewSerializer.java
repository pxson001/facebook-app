package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: explicit */
public class GraphQLNativeTemplateViewSerializer extends JsonSerializer<GraphQLNativeTemplateView> {
    public final void m9196a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNativeTemplateView__JsonHelper.m9198a(jsonGenerator, (GraphQLNativeTemplateView) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNativeTemplateView.class, new GraphQLNativeTemplateViewSerializer());
    }
}
