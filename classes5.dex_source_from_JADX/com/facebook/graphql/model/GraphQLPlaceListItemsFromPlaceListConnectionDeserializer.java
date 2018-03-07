package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_activity_count */
public class GraphQLPlaceListItemsFromPlaceListConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceListItemsFromPlaceListConnection.class, new GraphQLPlaceListItemsFromPlaceListConnectionDeserializer());
    }

    public GraphQLPlaceListItemsFromPlaceListConnectionDeserializer() {
        a(GraphQLPlaceListItemsFromPlaceListConnection.class);
    }

    public Object m20878a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceListItemsFromPlaceListConnection__JsonHelper.m20880a(jsonParser);
    }
}
