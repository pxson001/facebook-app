package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: on_this_day_promo */
public class GraphQLMailingAddressDeserializer extends FbJsonDeserializer {
    public Object m8982a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLMailingAddress graphQLMailingAddress = new GraphQLMailingAddress();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLMailingAddress = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLMailingAddress__JsonHelper.m8984a(graphQLMailingAddress, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLMailingAddress;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMailingAddress.class, new GraphQLMailingAddressDeserializer());
    }

    public GraphQLMailingAddressDeserializer() {
        a(GraphQLMailingAddress.class);
    }
}
