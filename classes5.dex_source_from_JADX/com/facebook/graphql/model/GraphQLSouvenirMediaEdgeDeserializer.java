package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_about_page_suggest_edits */
public class GraphQLSouvenirMediaEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaEdge.class, new GraphQLSouvenirMediaEdgeDeserializer());
    }

    public GraphQLSouvenirMediaEdgeDeserializer() {
        a(GraphQLSouvenirMediaEdge.class);
    }

    public Object m21713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSouvenirMediaEdge__JsonHelper.m21715a(jsonParser);
    }
}
