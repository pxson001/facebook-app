package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: off */
public class GraphQLOwnedEventsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOwnedEventsConnection.class, new GraphQLOwnedEventsConnectionDeserializer());
    }

    public GraphQLOwnedEventsConnectionDeserializer() {
        a(GraphQLOwnedEventsConnection.class);
    }

    public Object m9433a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLOwnedEventsConnection__JsonHelper.m9435a(jsonParser);
    }
}
