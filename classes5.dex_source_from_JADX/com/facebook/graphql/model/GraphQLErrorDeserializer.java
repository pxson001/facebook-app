package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_tfa */
public class GraphQLErrorDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLError.class, new GraphQLErrorDeserializer());
    }

    public GraphQLErrorDeserializer() {
        a(GraphQLError.class);
    }

    public Object m7112a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLError__JsonHelper.m7114a(jsonParser);
    }
}
