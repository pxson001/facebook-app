package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_places_editor_single_photo_review_module */
public class GraphQLStorySetDeserializer extends FbJsonDeserializer {
    public Object m21892a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLStorySet graphQLStorySet = new GraphQLStorySet();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLStorySet = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLStorySet__JsonHelper.m21915a(graphQLStorySet, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLStorySet;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySet.class, new GraphQLStorySetDeserializer());
    }

    public GraphQLStorySetDeserializer() {
        a(GraphQLStorySet.class);
    }
}
