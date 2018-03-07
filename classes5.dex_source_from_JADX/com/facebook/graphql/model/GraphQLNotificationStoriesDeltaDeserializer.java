package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offers_space */
public class GraphQLNotificationStoriesDeltaDeserializer extends FbJsonDeserializer {
    public Object m9368a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNotificationStoriesDelta graphQLNotificationStoriesDelta = new GraphQLNotificationStoriesDelta();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNotificationStoriesDelta = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLNotificationStoriesDelta__JsonHelper.m9370a(graphQLNotificationStoriesDelta, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLNotificationStoriesDelta;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNotificationStoriesDelta.class, new GraphQLNotificationStoriesDeltaDeserializer());
    }

    public GraphQLNotificationStoriesDeltaDeserializer() {
        a(GraphQLNotificationStoriesDelta.class);
    }
}
