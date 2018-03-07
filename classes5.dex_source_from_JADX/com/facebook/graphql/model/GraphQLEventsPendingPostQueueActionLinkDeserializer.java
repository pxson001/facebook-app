package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: paired_video */
public class GraphQLEventsPendingPostQueueActionLinkDeserializer extends FbJsonDeserializer {
    public Object m7366a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEventsPendingPostQueueActionLink graphQLEventsPendingPostQueueActionLink = new GraphQLEventsPendingPostQueueActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEventsPendingPostQueueActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLEventsPendingPostQueueActionLink__JsonHelper.m7368a(graphQLEventsPendingPostQueueActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLEventsPendingPostQueueActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventsPendingPostQueueActionLink.class, new GraphQLEventsPendingPostQueueActionLinkDeserializer());
    }

    public GraphQLEventsPendingPostQueueActionLinkDeserializer() {
        a(GraphQLEventsPendingPostQueueActionLink.class);
    }
}
