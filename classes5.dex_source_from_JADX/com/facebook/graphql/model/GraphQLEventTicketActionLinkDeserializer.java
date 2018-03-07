package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parent_story */
public class GraphQLEventTicketActionLinkDeserializer extends FbJsonDeserializer {
    public Object m7290a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEventTicketActionLink graphQLEventTicketActionLink = new GraphQLEventTicketActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEventTicketActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLEventTicketActionLink__JsonHelper.m7292a(graphQLEventTicketActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLEventTicketActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventTicketActionLink.class, new GraphQLEventTicketActionLinkDeserializer());
    }

    public GraphQLEventTicketActionLinkDeserializer() {
        a(GraphQLEventTicketActionLink.class);
    }
}
