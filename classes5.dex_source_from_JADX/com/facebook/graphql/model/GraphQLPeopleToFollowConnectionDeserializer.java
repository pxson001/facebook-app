package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: not a valid number */
public class GraphQLPeopleToFollowConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleToFollowConnection.class, new GraphQLPeopleToFollowConnectionDeserializer());
    }

    public GraphQLPeopleToFollowConnectionDeserializer() {
        a(GraphQLPeopleToFollowConnection.class);
    }

    public Object m20638a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPeopleToFollowConnection__JsonHelper.m20640a(jsonParser);
    }
}
