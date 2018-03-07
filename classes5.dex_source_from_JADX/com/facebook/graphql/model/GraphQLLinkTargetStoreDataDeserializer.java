package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: open_fd_soft_limit */
public class GraphQLLinkTargetStoreDataDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLinkTargetStoreData.class, new GraphQLLinkTargetStoreDataDeserializer());
    }

    public GraphQLLinkTargetStoreDataDeserializer() {
        a(GraphQLLinkTargetStoreData.class);
    }

    public Object m8945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLinkTargetStoreData__JsonHelper.m8947a(jsonParser);
    }
}
