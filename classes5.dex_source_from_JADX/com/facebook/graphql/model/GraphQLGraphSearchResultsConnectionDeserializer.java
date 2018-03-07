package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_engagement_card */
public class GraphQLGraphSearchResultsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchResultsConnection.class, new GraphQLGraphSearchResultsConnectionDeserializer());
    }

    public GraphQLGraphSearchResultsConnectionDeserializer() {
        a(GraphQLGraphSearchResultsConnection.class);
    }

    public Object m8295a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchResultsConnection__JsonHelper.m8297a(jsonParser);
    }
}
