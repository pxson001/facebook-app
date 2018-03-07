package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: option_id */
public class GraphQLInterestingRepliesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInterestingRepliesConnection.class, new GraphQLInterestingRepliesConnectionDeserializer());
    }

    public GraphQLInterestingRepliesConnectionDeserializer() {
        a(GraphQLInterestingRepliesConnection.class);
    }

    public Object m8749a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInterestingRepliesConnection__JsonHelper.a(jsonParser);
    }
}
