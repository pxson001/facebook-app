package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_report_dialog */
public class GraphQLFriendingPossibilitiesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendingPossibilitiesConnection.class, new GraphQLFriendingPossibilitiesConnectionDeserializer());
    }

    public GraphQLFriendingPossibilitiesConnectionDeserializer() {
        a(GraphQLFriendingPossibilitiesConnection.class);
    }

    public Object m7585a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendingPossibilitiesConnection__JsonHelper.m7587a(jsonParser);
    }
}
