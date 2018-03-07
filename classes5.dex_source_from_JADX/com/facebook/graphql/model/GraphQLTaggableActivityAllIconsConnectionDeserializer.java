package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_graph_editor_url */
public class GraphQLTaggableActivityAllIconsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivityAllIconsConnection.class, new GraphQLTaggableActivityAllIconsConnectionDeserializer());
    }

    public GraphQLTaggableActivityAllIconsConnectionDeserializer() {
        a(GraphQLTaggableActivityAllIconsConnection.class);
    }

    public Object m22044a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTaggableActivityAllIconsConnection__JsonHelper.m22046a(jsonParser);
    }
}
