package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSEEN_STORIES_CHAINING */
public class GraphQLTaggableActivityPreviewTemplateSerializer extends JsonSerializer<GraphQLTaggableActivityPreviewTemplate> {
    public final void m22060a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22062a(jsonGenerator, (GraphQLTaggableActivityPreviewTemplate) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivityPreviewTemplate.class, new GraphQLTaggableActivityPreviewTemplateSerializer());
    }
}
