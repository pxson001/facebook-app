package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: extraData */
public class GraphQLNativeTemplateBundleSerializer extends JsonSerializer<GraphQLNativeTemplateBundle> {
    public final void m9162a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNativeTemplateBundle__JsonHelper.m9164a(jsonGenerator, (GraphQLNativeTemplateBundle) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNativeTemplateBundle.class, new GraphQLNativeTemplateBundleSerializer());
    }
}
