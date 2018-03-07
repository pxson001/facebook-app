package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_insights_card */
public class GraphQLGraphSearchQueryTitleDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryTitle.class, new GraphQLGraphSearchQueryTitleDeserializer());
    }

    public GraphQLGraphSearchQueryTitleDeserializer() {
        a(GraphQLGraphSearchQueryTitle.class);
    }

    public Object m8261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQueryTitle__JsonHelper.m8263a(jsonParser);
    }
}
