package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: multifeed_afro_actions */
public class GraphQLSavedCollectionFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = new GraphQLSavedCollectionFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSavedCollectionFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLSavedCollectionFeedUnit__JsonHelper.m21552a(graphQLSavedCollectionFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLSavedCollectionFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSavedCollectionFeedUnit.class, new GraphQLSavedCollectionFeedUnitDeserializer());
    }

    public GraphQLSavedCollectionFeedUnitDeserializer() {
        a(GraphQLSavedCollectionFeedUnit.class);
    }
}
