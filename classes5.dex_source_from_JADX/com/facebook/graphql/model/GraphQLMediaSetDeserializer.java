package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: onResumePreview/startPreview failed */
public class GraphQLMediaSetDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaSet.class, new GraphQLMediaSetDeserializer());
    }

    public GraphQLMediaSetDeserializer() {
        a(GraphQLMediaSet.class);
    }

    public Object m9067a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMediaSet__JsonHelper.m9076a(jsonParser);
    }
}
