package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: modeQueryName */
public class GraphQLStoryActionLinkDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryActionLink.class, new GraphQLStoryActionLinkDeserializer());
    }

    public GraphQLStoryActionLinkDeserializer() {
        a(GraphQLStoryActionLink.class);
    }

    public Object m21845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStoryActionLink__JsonHelper.m21847a(jsonParser);
    }
}
