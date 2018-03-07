package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_platform_native_like_button */
public class GraphQLStorySaveInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySaveInfo.class, new GraphQLStorySaveInfoDeserializer());
    }

    public GraphQLStorySaveInfoDeserializer() {
        a(GraphQLStorySaveInfo.class);
    }

    public Object m21883a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStorySaveInfo__JsonHelper.m21885a(jsonParser);
    }
}
