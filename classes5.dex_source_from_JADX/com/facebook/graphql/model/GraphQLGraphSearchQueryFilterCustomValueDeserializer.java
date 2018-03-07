package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_summary */
public class GraphQLGraphSearchQueryFilterCustomValueDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterCustomValue.class, new GraphQLGraphSearchQueryFilterCustomValueDeserializer());
    }

    public GraphQLGraphSearchQueryFilterCustomValueDeserializer() {
        a(GraphQLGraphSearchQueryFilterCustomValue.class);
    }

    public Object m8221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQueryFilterCustomValue__JsonHelper.m8223a(jsonParser);
    }
}
