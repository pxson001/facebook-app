package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_product_id */
public class GraphQLFriendsLocationsClusterDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFriendsLocationsCluster.class, new GraphQLFriendsLocationsClusterDeserializer());
    }

    public GraphQLFriendsLocationsClusterDeserializer() {
        a(GraphQLFriendsLocationsCluster.class);
    }

    public Object m7628a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFriendsLocationsCluster__JsonHelper.m7630a(jsonParser);
    }
}
