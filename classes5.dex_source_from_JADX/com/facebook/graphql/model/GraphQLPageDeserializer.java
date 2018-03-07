package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nux_megaphone */
public class GraphQLPageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPage.class, new GraphQLPageDeserializer());
    }

    public GraphQLPageDeserializer() {
        a(GraphQLPage.class);
    }

    public Object m9486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPage__JsonHelper.m9553a(jsonParser);
    }
}
