package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photoViews */
public class GraphQLContactPointDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLContactPoint.class, new GraphQLContactPointDeserializer());
    }

    public GraphQLContactPointDeserializer() {
        a(GraphQLContactPoint.class);
    }

    public Object m6872a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLContactPoint__JsonHelper.m6874a(jsonParser);
    }
}
