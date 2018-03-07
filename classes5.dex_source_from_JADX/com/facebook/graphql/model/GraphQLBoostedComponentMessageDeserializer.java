package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phrase_owner */
public class GraphQLBoostedComponentMessageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBoostedComponentMessage.class, new GraphQLBoostedComponentMessageDeserializer());
    }

    public GraphQLBoostedComponentMessageDeserializer() {
        a(GraphQLBoostedComponentMessage.class);
    }

    public Object m6657a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBoostedComponentMessage__JsonHelper.m6659a(jsonParser);
    }
}
