package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_likes */
public class GraphQLEventCreateActionLinkDeserializer extends FbJsonDeserializer {
    public Object m7162a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEventCreateActionLink graphQLEventCreateActionLink = new GraphQLEventCreateActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEventCreateActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLEventCreateActionLink__JsonHelper.m7164a(graphQLEventCreateActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLEventCreateActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventCreateActionLink.class, new GraphQLEventCreateActionLinkDeserializer());
    }

    public GraphQLEventCreateActionLinkDeserializer() {
        a(GraphQLEventCreateActionLink.class);
    }
}
