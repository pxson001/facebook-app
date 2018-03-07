package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: modified_edge */
public class GraphQLStatelessLargeImagePLAsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStatelessLargeImagePLAsConnection.class, new GraphQLStatelessLargeImagePLAsConnectionDeserializer());
    }

    public GraphQLStatelessLargeImagePLAsConnectionDeserializer() {
        a(GraphQLStatelessLargeImagePLAsConnection.class);
    }

    public Object m21819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStatelessLargeImagePLAsConnection__JsonHelper.m21821a(jsonParser);
    }
}
