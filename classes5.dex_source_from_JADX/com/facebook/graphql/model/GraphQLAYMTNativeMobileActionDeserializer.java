package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_to_suggested_activity */
public class GraphQLAYMTNativeMobileActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAYMTNativeMobileAction.class, new GraphQLAYMTNativeMobileActionDeserializer());
    }

    public GraphQLAYMTNativeMobileActionDeserializer() {
        a(GraphQLAYMTNativeMobileAction.class);
    }

    public Object m6363a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAYMTNativeMobileAction__JsonHelper.m6365a(jsonParser);
    }
}
