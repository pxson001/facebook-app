package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: more_posts_query */
public class GraphQLSouvenirMediaElementMediaEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaElementMediaEdge.class, new GraphQLSouvenirMediaElementMediaEdgeDeserializer());
    }

    public GraphQLSouvenirMediaElementMediaEdgeDeserializer() {
        a(GraphQLSouvenirMediaElementMediaEdge.class);
    }

    public Object m21743a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSouvenirMediaElementMediaEdge__JsonHelper.m21745a(jsonParser);
    }
}
