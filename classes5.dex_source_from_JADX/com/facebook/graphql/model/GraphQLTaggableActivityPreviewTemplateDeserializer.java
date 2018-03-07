package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_donate_url */
public class GraphQLTaggableActivityPreviewTemplateDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivityPreviewTemplate.class, new GraphQLTaggableActivityPreviewTemplateDeserializer());
    }

    public GraphQLTaggableActivityPreviewTemplateDeserializer() {
        a(GraphQLTaggableActivityPreviewTemplate.class);
    }

    public Object m22059a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTaggableActivityPreviewTemplate__JsonHelper.m22061a(jsonParser);
    }
}
