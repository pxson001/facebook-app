package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_link */
public class GraphQLReactorsOfContentConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReactorsOfContentConnection.class, new GraphQLReactorsOfContentConnectionDeserializer());
    }

    public GraphQLReactorsOfContentConnectionDeserializer() {
        a(GraphQLReactorsOfContentConnection.class);
    }

    public Object m21345a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLReactorsOfContentConnection__JsonHelper.a(jsonParser);
    }
}
