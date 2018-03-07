package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending_place */
public class GraphQLEntityCardContextItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItem.class, new GraphQLEntityCardContextItemDeserializer());
    }

    public GraphQLEntityCardContextItemDeserializer() {
        a(GraphQLEntityCardContextItem.class);
    }

    public Object m7059a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEntityCardContextItem__JsonHelper.m7083a(jsonParser);
    }
}
