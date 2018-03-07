package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: no suitable creator method found to deserialize from JSON floating-point number */
public class GraphQLPhotoEncodingDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoEncoding.class, new GraphQLPhotoEncodingDeserializer());
    }

    public GraphQLPhotoEncodingDeserializer() {
        a(GraphQLPhotoEncoding.class);
    }

    public Object m20721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhotoEncoding__JsonHelper.m20723a(jsonParser);
    }
}
