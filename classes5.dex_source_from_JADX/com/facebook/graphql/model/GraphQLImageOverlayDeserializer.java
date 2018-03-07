package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: origin= */
public class GraphQLImageOverlayDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImageOverlay.class, new GraphQLImageOverlayDeserializer());
    }

    public GraphQLImageOverlayDeserializer() {
        a(GraphQLImageOverlay.class);
    }

    public Object m8628a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLImageOverlay__JsonHelper.m8630a(jsonParser);
    }
}
