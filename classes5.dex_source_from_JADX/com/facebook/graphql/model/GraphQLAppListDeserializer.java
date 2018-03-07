package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_attachment_removed */
public class GraphQLAppListDeserializer extends FbJsonDeserializer {
    public Object m6567a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLAppList graphQLAppList = new GraphQLAppList();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLAppList = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLAppList__JsonHelper.m6569a(graphQLAppList, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLAppList;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppList.class, new GraphQLAppListDeserializer());
    }

    public GraphQLAppListDeserializer() {
        a(GraphQLAppList.class);
    }
}
