package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_suggest_edits */
public class GraphQLSideFeedUnitDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSideFeedUnit.class, new GraphQLSideFeedUnitDeserializer());
    }

    public GraphQLSideFeedUnitDeserializer() {
        a(GraphQLSideFeedUnit.class);
    }

    public Object m21654a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSideFeedUnit__JsonHelper.m21656a(jsonParser);
    }
}
