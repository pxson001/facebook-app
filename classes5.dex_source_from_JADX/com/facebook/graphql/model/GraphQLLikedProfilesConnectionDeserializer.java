package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: open_graph_metadata */
public class GraphQLLikedProfilesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLikedProfilesConnection.class, new GraphQLLikedProfilesConnectionDeserializer());
    }

    public GraphQLLikedProfilesConnectionDeserializer() {
        a(GraphQLLikedProfilesConnection.class);
    }

    public Object m8912a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLikedProfilesConnection__JsonHelper.m8914a(jsonParser);
    }
}
