package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: multifeed_reports */
public class GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer());
    }

    public GraphQLSaleGroupsNearYouFeedUnitGroupsEdgeDeserializer() {
        a(GraphQLSaleGroupsNearYouFeedUnitGroupsEdge.class);
    }

    public Object m21525a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSaleGroupsNearYouFeedUnitGroupsEdge__JsonHelper.m21527a(jsonParser);
    }
}
