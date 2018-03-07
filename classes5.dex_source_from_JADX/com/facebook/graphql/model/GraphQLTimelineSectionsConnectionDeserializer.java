package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: missing property ' */
public class GraphQLTimelineSectionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineSectionsConnection.class, new GraphQLTimelineSectionsConnectionDeserializer());
    }

    public GraphQLTimelineSectionsConnectionDeserializer() {
        a(GraphQLTimelineSectionsConnection.class);
    }

    public Object m22221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineSectionsConnection__JsonHelper.m22223a(jsonParser);
    }
}
