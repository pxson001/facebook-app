package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_entry_chat_head */
public class GraphQLVideoChannelDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoChannel.class, new GraphQLVideoChannelDeserializer());
    }

    public GraphQLVideoChannelDeserializer() {
        a(GraphQLVideoChannel.class);
    }

    public Object m22437a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideoChannel__JsonHelper.m22446a(jsonParser);
    }
}
