package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_pyml */
public class GraphQLFriendsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsConnection.class, new GraphQLFriendsConnectionDeserializer());
    }

    public GraphQLFriendsConnectionDeserializer() {
        a(GraphQLFriendsConnection.class);
    }

    public Object m7606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendsConnection__JsonHelper.m7608a(jsonParser);
    }
}
