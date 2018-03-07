package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offending_view */
public class GraphQLOverlayActionLinkDeserializer extends FbJsonDeserializer {
    public Object m9420a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLOverlayActionLink graphQLOverlayActionLink = new GraphQLOverlayActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLOverlayActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLOverlayActionLink__JsonHelper.m9422a(graphQLOverlayActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLOverlayActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOverlayActionLink.class, new GraphQLOverlayActionLinkDeserializer());
    }

    public GraphQLOverlayActionLinkDeserializer() {
        a(GraphQLOverlayActionLink.class);
    }
}
