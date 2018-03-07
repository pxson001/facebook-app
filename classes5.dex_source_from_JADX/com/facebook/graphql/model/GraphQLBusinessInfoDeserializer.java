package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photos_tab */
public class GraphQLBusinessInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBusinessInfo.class, new GraphQLBusinessInfoDeserializer());
    }

    public GraphQLBusinessInfoDeserializer() {
        a(GraphQLBusinessInfo.class);
    }

    public Object m6703a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBusinessInfo__JsonHelper.m6705a(jsonParser);
    }
}
