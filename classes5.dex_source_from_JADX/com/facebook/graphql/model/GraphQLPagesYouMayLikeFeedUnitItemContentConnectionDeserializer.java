package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: null tags */
public class GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class, new GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer());
    }

    public GraphQLPagesYouMayLikeFeedUnitItemContentConnectionDeserializer() {
        a(GraphQLPagesYouMayLikeFeedUnitItemContentConnection.class);
    }

    public Object m20573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPagesYouMayLikeFeedUnitItemContentConnection__JsonHelper.m20575a(jsonParser);
    }
}
