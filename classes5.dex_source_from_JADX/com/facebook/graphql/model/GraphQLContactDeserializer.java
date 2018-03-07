package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_attachments */
public class GraphQLContactDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLContact.class, new GraphQLContactDeserializer());
    }

    public GraphQLContactDeserializer() {
        a(GraphQLContact.class);
    }

    public Object m6863a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLContact__JsonHelper.m6884a(jsonParser);
    }
}
