package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offsetX */
public class GraphQLNoteDeserializer extends FbJsonDeserializer {
    public Object m9327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNote graphQLNote = new GraphQLNote();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNote = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLNote__JsonHelper.m9329a(graphQLNote, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLNote;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNote.class, new GraphQLNoteDeserializer());
    }

    public GraphQLNoteDeserializer() {
        a(GraphQLNote.class);
    }
}
