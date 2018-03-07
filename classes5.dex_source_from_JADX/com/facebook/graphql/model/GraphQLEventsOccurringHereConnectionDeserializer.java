package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parameterType */
public class GraphQLEventsOccurringHereConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventsOccurringHereConnection.class, new GraphQLEventsOccurringHereConnectionDeserializer());
    }

    public GraphQLEventsOccurringHereConnectionDeserializer() {
        a(GraphQLEventsOccurringHereConnection.class);
    }

    public Object m7355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventsOccurringHereConnection__JsonHelper.m7357a(jsonParser);
    }
}
