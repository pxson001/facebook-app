package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_ids */
public class GraphQLAlbumDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAlbum.class, new GraphQLAlbumDeserializer());
    }

    public GraphQLAlbumDeserializer() {
        a(GraphQLAlbum.class);
    }

    public Object m6508a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAlbum__JsonHelper.m6510a(jsonParser);
    }
}
