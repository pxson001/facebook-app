package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: output */
public class GraphQLGroupMembersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMembersConnection.class, new GraphQLGroupMembersConnectionDeserializer());
    }

    public GraphQLGroupMembersConnectionDeserializer() {
        a(GraphQLGroupMembersConnection.class);
    }

    public Object m8456a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupMembersConnection__JsonHelper.m8458a(jsonParser);
    }
}
