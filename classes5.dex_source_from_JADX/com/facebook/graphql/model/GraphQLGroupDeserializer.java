package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: overheadCorrection */
public class GraphQLGroupDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroup.class, new GraphQLGroupDeserializer());
    }

    public GraphQLGroupDeserializer() {
        a(GraphQLGroup.class);
    }

    public Object m8431a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroup__JsonHelper.m8518a(jsonParser);
    }
}
