package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: originalScheduleVsyncLocked */
public class GraphQLHashtagFeedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLHashtagFeedConnection.class, new GraphQLHashtagFeedConnectionDeserializer());
    }

    public GraphQLHashtagFeedConnectionDeserializer() {
        a(GraphQLHashtagFeedConnection.class);
    }

    public Object m8599a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLHashtagFeedConnection__JsonHelper.m8601a(jsonParser);
    }
}
