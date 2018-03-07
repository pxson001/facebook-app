package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nux_title */
public class GraphQLPageCallToActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageCallToAction.class, new GraphQLPageCallToActionDeserializer());
    }

    public GraphQLPageCallToActionDeserializer() {
        a(GraphQLPageCallToAction.class);
    }

    public Object m9482a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageCallToAction__JsonHelper.m9484a(jsonParser);
    }
}
