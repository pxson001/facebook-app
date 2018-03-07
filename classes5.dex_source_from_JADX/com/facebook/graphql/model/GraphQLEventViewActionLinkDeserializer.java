package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parent_child_migration */
public class GraphQLEventViewActionLinkDeserializer extends FbJsonDeserializer {
    public Object m7319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEventViewActionLink graphQLEventViewActionLink = new GraphQLEventViewActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEventViewActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLEventViewActionLink__JsonHelper.m7321a(graphQLEventViewActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLEventViewActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventViewActionLink.class, new GraphQLEventViewActionLinkDeserializer());
    }

    public GraphQLEventViewActionLinkDeserializer() {
        a(GraphQLEventViewActionLink.class);
    }
}
