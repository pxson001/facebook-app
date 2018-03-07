package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: outbound_click_chaining */
public class GraphQLGroupMessageChattableMembersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMessageChattableMembersConnection.class, new GraphQLGroupMessageChattableMembersConnectionDeserializer());
    }

    public GraphQLGroupMessageChattableMembersConnectionDeserializer() {
        a(GraphQLGroupMessageChattableMembersConnection.class);
    }

    public Object m8473a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupMessageChattableMembersConnection__JsonHelper.m8475a(jsonParser);
    }
}
