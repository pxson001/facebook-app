package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: merge_via_invite */
public class GraphQLWithTagsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWithTagsConnection.class, new GraphQLWithTagsConnectionDeserializer());
    }

    public GraphQLWithTagsConnectionDeserializer() {
        a(GraphQLWithTagsConnection.class);
    }

    public Object m22498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLWithTagsConnection__JsonHelper.m22500a(jsonParser);
    }
}
