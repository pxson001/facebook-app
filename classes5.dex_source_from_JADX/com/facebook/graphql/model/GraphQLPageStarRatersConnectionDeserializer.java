package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: number_of_copy_pastes */
public class GraphQLPageStarRatersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageStarRatersConnection.class, new GraphQLPageStarRatersConnectionDeserializer());
    }

    public GraphQLPageStarRatersConnectionDeserializer() {
        a(GraphQLPageStarRatersConnection.class);
    }

    public Object m9519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageStarRatersConnection__JsonHelper.m9521a(jsonParser);
    }
}
