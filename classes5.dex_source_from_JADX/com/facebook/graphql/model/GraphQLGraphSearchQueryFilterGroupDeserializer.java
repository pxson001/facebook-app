package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_posts_card */
public class GraphQLGraphSearchQueryFilterGroupDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterGroup.class, new GraphQLGraphSearchQueryFilterGroupDeserializer());
    }

    public GraphQLGraphSearchQueryFilterGroupDeserializer() {
        a(GraphQLGraphSearchQueryFilterGroup.class);
    }

    public Object m8231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQueryFilterGroup__JsonHelper.m8233a(jsonParser);
    }
}
