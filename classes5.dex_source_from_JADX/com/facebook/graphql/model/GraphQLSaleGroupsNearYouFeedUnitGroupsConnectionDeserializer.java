package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: multipart/form-data; boundary= */
public class GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer());
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer() {
        a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class);
    }

    public Object m21515a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSaleGroupsNearYouFeedUnitGroupsConnection__JsonHelper.m21517a(jsonParser);
    }
}
