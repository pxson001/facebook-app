package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogSuggestionMechanism */
public class GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class, new GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer());
    }

    public GraphQLNearbyPlacesBrowsePlaceResultsConnectionDeserializer() {
        a(GraphQLNearbyPlacesBrowsePlaceResultsConnection.class);
    }

    public Object m9206a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNearbyPlacesBrowsePlaceResultsConnection__JsonHelper.m9208a(jsonParser);
    }
}
