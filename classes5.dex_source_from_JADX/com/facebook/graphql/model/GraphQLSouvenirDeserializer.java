package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_edit */
public class GraphQLSouvenirDeserializer extends FbJsonDeserializer {
    public Object m21701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSouvenir graphQLSouvenir = new GraphQLSouvenir();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSouvenir = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLSouvenir__JsonHelper.m21751a(graphQLSouvenir, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLSouvenir;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenir.class, new GraphQLSouvenirDeserializer());
    }

    public GraphQLSouvenirDeserializer() {
        a(GraphQLSouvenir.class);
    }
}
