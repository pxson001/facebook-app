package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_tag */
public class GraphQLAYMTTipDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAYMTTip.class, new GraphQLAYMTTipDeserializer());
    }

    public GraphQLAYMTTipDeserializer() {
        a(GraphQLAYMTTip.class);
    }

    public Object m6385a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAYMTTip__JsonHelper.m6387a(jsonParser);
    }
}
