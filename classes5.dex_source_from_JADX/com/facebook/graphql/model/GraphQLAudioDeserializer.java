package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pickup_delivery_info */
public class GraphQLAudioDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAudio.class, new GraphQLAudioDeserializer());
    }

    public GraphQLAudioDeserializer() {
        a(GraphQLAudio.class);
    }

    public Object m6625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAudio__JsonHelper.m6627a(jsonParser);
    }
}
