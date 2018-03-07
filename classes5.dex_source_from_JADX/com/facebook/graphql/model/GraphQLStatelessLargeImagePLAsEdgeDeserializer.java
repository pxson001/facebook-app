package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: moderator */
public class GraphQLStatelessLargeImagePLAsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStatelessLargeImagePLAsEdge.class, new GraphQLStatelessLargeImagePLAsEdgeDeserializer());
    }

    public GraphQLStatelessLargeImagePLAsEdgeDeserializer() {
        a(GraphQLStatelessLargeImagePLAsEdge.class);
    }

    public Object m21828a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLStatelessLargeImagePLAsEdge__JsonHelper.m21830a(jsonParser);
    }
}
