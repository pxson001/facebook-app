package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_suggest_edits_url */
public class GraphQLSideFeedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSideFeedConnection.class, new GraphQLSideFeedConnectionDeserializer());
    }

    public GraphQLSideFeedConnectionDeserializer() {
        a(GraphQLSideFeedConnection.class);
    }

    public Object m21635a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSideFeedConnection__JsonHelper.m21637a(jsonParser);
    }
}
