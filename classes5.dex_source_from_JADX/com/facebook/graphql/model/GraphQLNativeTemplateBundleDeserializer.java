package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_icon_id */
public class GraphQLNativeTemplateBundleDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateBundle.class, new GraphQLNativeTemplateBundleDeserializer());
    }

    public GraphQLNativeTemplateBundleDeserializer() {
        a(GraphQLNativeTemplateBundle.class);
    }

    public Object m9161a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNativeTemplateBundle__JsonHelper.m9163a(jsonParser);
    }
}
