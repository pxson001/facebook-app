package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_phrase */
public class GraphQLMobileStoreObjectDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMobileStoreObject.class, new GraphQLMobileStoreObjectDeserializer());
    }

    public GraphQLMobileStoreObjectDeserializer() {
        a(GraphQLMobileStoreObject.class);
    }

    public Object m9136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMobileStoreObject__JsonHelper.m9138a(jsonParser);
    }
}
