package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityPreviewTemplateDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNSELECTED */
public class GraphQLTaggableActivityPreviewTemplate$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivityPreviewTemplate.class, new GraphQLTaggableActivityPreviewTemplate$Deserializer());
    }

    public Object m22057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTaggableActivityPreviewTemplateDeserializer.m6042a(jsonParser, (short) 200);
        Object graphQLTaggableActivityPreviewTemplate = new GraphQLTaggableActivityPreviewTemplate();
        ((BaseModel) graphQLTaggableActivityPreviewTemplate).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTaggableActivityPreviewTemplate instanceof Postprocessable) {
            return ((Postprocessable) graphQLTaggableActivityPreviewTemplate).a();
        }
        return graphQLTaggableActivityPreviewTemplate;
    }
}
