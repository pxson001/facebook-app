package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_page */
public class GraphQLReactionUnitDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReactionUnit.class, new GraphQLReactionUnitDeserializer());
    }

    public GraphQLReactionUnitDeserializer() {
        a(GraphQLReactionUnit.class);
    }

    public Object m21339a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLReactionUnit__JsonHelper.m21341a(jsonParser);
    }
}
