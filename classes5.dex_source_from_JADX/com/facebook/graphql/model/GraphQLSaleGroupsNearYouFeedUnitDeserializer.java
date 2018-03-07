package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: music_object */
public class GraphQLSaleGroupsNearYouFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m21510a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit = new GraphQLSaleGroupsNearYouFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLSaleGroupsNearYouFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLSaleGroupsNearYouFeedUnit__JsonHelper.m21531a(graphQLSaleGroupsNearYouFeedUnit, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLSaleGroupsNearYouFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSaleGroupsNearYouFeedUnit.class, new GraphQLSaleGroupsNearYouFeedUnitDeserializer());
    }

    public GraphQLSaleGroupsNearYouFeedUnitDeserializer() {
        a(GraphQLSaleGroupsNearYouFeedUnit.class);
    }
}
