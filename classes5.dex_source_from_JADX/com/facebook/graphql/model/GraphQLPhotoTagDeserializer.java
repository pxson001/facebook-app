package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: no ComposerForVideo intent could be created */
public class GraphQLPhotoTagDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoTag.class, new GraphQLPhotoTagDeserializer());
    }

    public GraphQLPhotoTagDeserializer() {
        a(GraphQLPhotoTag.class);
    }

    public Object m20742a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhotoTag__JsonHelper.m20744a(jsonParser);
    }
}
