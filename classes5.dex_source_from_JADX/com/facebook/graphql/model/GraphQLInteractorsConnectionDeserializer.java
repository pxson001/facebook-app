package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: option_numeric_value */
public class GraphQLInteractorsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInteractorsConnection.class, new GraphQLInteractorsConnectionDeserializer());
    }

    public GraphQLInteractorsConnectionDeserializer() {
        a(GraphQLInteractorsConnection.class);
    }

    public Object m8743a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInteractorsConnection__JsonHelper.m8745a(jsonParser);
    }
}
