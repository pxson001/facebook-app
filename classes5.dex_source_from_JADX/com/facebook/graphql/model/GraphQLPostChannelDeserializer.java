package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_profile */
public class GraphQLPostChannelDeserializer extends FbJsonDeserializer {
    public Object m20963a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPostChannel graphQLPostChannel = new GraphQLPostChannel();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPostChannel = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLPostChannel__JsonHelper.m20965a(graphQLPostChannel, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLPostChannel;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPostChannel.class, new GraphQLPostChannelDeserializer());
    }

    public GraphQLPostChannelDeserializer() {
        a(GraphQLPostChannel.class);
    }
}
