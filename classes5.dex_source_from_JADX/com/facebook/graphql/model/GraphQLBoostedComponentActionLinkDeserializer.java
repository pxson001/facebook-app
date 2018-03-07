package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phrases_analysis */
public class GraphQLBoostedComponentActionLinkDeserializer extends FbJsonDeserializer {
    public Object m6643a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLBoostedComponentActionLink graphQLBoostedComponentActionLink = new GraphQLBoostedComponentActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLBoostedComponentActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLBoostedComponentActionLink__JsonHelper.m6645a(graphQLBoostedComponentActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLBoostedComponentActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBoostedComponentActionLink.class, new GraphQLBoostedComponentActionLinkDeserializer());
    }

    public GraphQLBoostedComponentActionLinkDeserializer() {
        a(GraphQLBoostedComponentActionLink.class);
    }
}
