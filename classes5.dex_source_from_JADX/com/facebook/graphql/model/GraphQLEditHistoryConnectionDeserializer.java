package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: permalink_action_bar */
public class GraphQLEditHistoryConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEditHistoryConnection.class, new GraphQLEditHistoryConnectionDeserializer());
    }

    public GraphQLEditHistoryConnectionDeserializer() {
        a(GraphQLEditHistoryConnection.class);
    }

    public Object m6966a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEditHistoryConnection__JsonHelper.a(jsonParser);
    }
}
