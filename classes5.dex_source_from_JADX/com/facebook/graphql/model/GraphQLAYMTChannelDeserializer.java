package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_topic_id */
public class GraphQLAYMTChannelDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAYMTChannel.class, new GraphQLAYMTChannelDeserializer());
    }

    public GraphQLAYMTChannelDeserializer() {
        a(GraphQLAYMTChannel.class);
    }

    public Object m6351a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAYMTChannel__JsonHelper.m6353a(jsonParser);
    }
}
