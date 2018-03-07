package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_stories */
public class GraphQLFocusedPhotoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFocusedPhoto.class, new GraphQLFocusedPhotoDeserializer());
    }

    public GraphQLFocusedPhotoDeserializer() {
        a(GraphQLFocusedPhoto.class);
    }

    public Object m7524a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFocusedPhoto__JsonHelper.m7526a(jsonParser);
    }
}
