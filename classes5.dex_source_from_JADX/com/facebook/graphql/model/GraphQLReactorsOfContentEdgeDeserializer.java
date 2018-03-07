package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_event_album */
public class GraphQLReactorsOfContentEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReactorsOfContentEdge.class, new GraphQLReactorsOfContentEdgeDeserializer());
    }

    public GraphQLReactorsOfContentEdgeDeserializer() {
        a(GraphQLReactorsOfContentEdge.class);
    }

    public Object m21350a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLReactorsOfContentEdge__JsonHelper.m21352a(jsonParser);
    }
}
