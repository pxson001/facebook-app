package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: original_post_time */
public class GraphQLHashtagDeserializer extends FbJsonDeserializer {
    public Object m8593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLHashtag graphQLHashtag = new GraphQLHashtag();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLHashtag = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLHashtag__JsonHelper.m8604a(graphQLHashtag, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLHashtag;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLHashtag.class, new GraphQLHashtagDeserializer());
    }

    public GraphQLHashtagDeserializer() {
        a(GraphQLHashtag.class);
    }
}
