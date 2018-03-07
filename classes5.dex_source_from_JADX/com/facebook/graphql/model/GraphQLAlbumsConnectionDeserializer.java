package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_holder */
public class GraphQLAlbumsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAlbumsConnection.class, new GraphQLAlbumsConnectionDeserializer());
    }

    public GraphQLAlbumsConnectionDeserializer() {
        a(GraphQLAlbumsConnection.class);
    }

    public Object m6516a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAlbumsConnection__JsonHelper.m6518a(jsonParser);
    }
}
