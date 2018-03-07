package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_suggest_edits_bookmark */
public class GraphQLSideFeedEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSideFeedEdge.class, new GraphQLSideFeedEdgeDeserializer());
    }

    public GraphQLSideFeedEdgeDeserializer() {
        a(GraphQLSideFeedEdge.class);
    }

    public Object m21644a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSideFeedEdge__JsonHelper.m21646a(jsonParser);
    }
}
