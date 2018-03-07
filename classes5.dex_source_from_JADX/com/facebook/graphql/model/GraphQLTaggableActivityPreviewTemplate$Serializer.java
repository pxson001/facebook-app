package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityPreviewTemplateDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSELECTED */
public final class GraphQLTaggableActivityPreviewTemplate$Serializer extends JsonSerializer<GraphQLTaggableActivityPreviewTemplate> {
    public final void m22058a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivityPreviewTemplate graphQLTaggableActivityPreviewTemplate = (GraphQLTaggableActivityPreviewTemplate) obj;
        GraphQLTaggableActivityPreviewTemplateDeserializer.m6043a(graphQLTaggableActivityPreviewTemplate.w_(), graphQLTaggableActivityPreviewTemplate.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivityPreviewTemplate.class, new GraphQLTaggableActivityPreviewTemplate$Serializer());
        FbSerializerProvider.a(GraphQLTaggableActivityPreviewTemplate.class, new GraphQLTaggableActivityPreviewTemplate$Serializer());
    }
}
