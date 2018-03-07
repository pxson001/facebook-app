package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: objective */
public class GraphQLPYMLWithLargeImageFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnitItem.class, new GraphQLPYMLWithLargeImageFeedUnitItemDeserializer());
    }

    public GraphQLPYMLWithLargeImageFeedUnitItemDeserializer() {
        a(GraphQLPYMLWithLargeImageFeedUnitItem.class);
    }

    public Object m9442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9444a(jsonParser);
    }
}
