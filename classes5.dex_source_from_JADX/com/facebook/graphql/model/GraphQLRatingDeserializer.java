package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_store_object */
public class GraphQLRatingDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRating.class, new GraphQLRatingDeserializer());
    }

    public GraphQLRatingDeserializer() {
        a(GraphQLRating.class);
    }

    public Object m21308a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLRating__JsonHelper.m21310a(jsonParser);
    }
}
