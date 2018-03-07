package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_entry_profile */
public class GraphQLVect2Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVect2.class, new GraphQLVect2Deserializer());
    }

    public GraphQLVect2Deserializer() {
        a(GraphQLVect2.class);
    }

    public Object m22419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVect2__JsonHelper.m22421a(jsonParser);
    }
}
