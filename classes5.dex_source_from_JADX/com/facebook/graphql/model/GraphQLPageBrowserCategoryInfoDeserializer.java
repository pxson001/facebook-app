package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: oauth */
public class GraphQLPageBrowserCategoryInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageBrowserCategoryInfo.class, new GraphQLPageBrowserCategoryInfoDeserializer());
    }

    public GraphQLPageBrowserCategoryInfoDeserializer() {
        a(GraphQLPageBrowserCategoryInfo.class);
    }

    public Object m9476a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageBrowserCategoryInfo__JsonHelper.m9478a(jsonParser);
    }
}
