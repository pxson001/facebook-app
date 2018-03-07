package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offset (%s) may not be negative */
public class GraphQLNotifOptionRowDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNotifOptionRow.class, new GraphQLNotifOptionRowDeserializer());
    }

    public GraphQLNotifOptionRowDeserializer() {
        a(GraphQLNotifOptionRow.class);
    }

    public Object m9340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNotifOptionRow__JsonHelper.m9358a(jsonParser);
    }
}
