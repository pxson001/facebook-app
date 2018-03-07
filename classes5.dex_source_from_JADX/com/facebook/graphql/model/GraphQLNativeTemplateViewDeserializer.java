package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogSuggestionMechansim */
public class GraphQLNativeTemplateViewDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNativeTemplateView.class, new GraphQLNativeTemplateViewDeserializer());
    }

    public GraphQLNativeTemplateViewDeserializer() {
        a(GraphQLNativeTemplateView.class);
    }

    public Object m9195a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNativeTemplateView__JsonHelper.m9197a(jsonParser);
    }
}
