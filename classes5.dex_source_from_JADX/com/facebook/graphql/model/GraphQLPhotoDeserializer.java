package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: no suitable creator method found to deserialize from JSON integer number */
public class GraphQLPhotoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhoto.class, new GraphQLPhotoDeserializer());
    }

    public GraphQLPhotoDeserializer() {
        a(GraphQLPhoto.class);
    }

    public Object m20718a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhoto__JsonHelper.m20764a(jsonParser);
    }
}
