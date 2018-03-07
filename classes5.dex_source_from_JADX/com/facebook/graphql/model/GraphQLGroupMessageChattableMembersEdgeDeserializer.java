package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: other_count */
public class GraphQLGroupMessageChattableMembersEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMessageChattableMembersEdge.class, new GraphQLGroupMessageChattableMembersEdgeDeserializer());
    }

    public GraphQLGroupMessageChattableMembersEdgeDeserializer() {
        a(GraphQLGroupMessageChattableMembersEdge.class);
    }

    public Object m8482a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupMessageChattableMembersEdge__JsonHelper.m8484a(jsonParser);
    }
}
