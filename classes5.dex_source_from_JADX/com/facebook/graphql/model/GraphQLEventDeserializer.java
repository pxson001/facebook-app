package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_event */
public class GraphQLEventDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEvent.class, new GraphQLEventDeserializer());
    }

    public GraphQLEventDeserializer() {
        a(GraphQLEvent.class);
    }

    public Object m7186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEvent__JsonHelper.m7344a(jsonParser);
    }
}
