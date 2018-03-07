package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_identity_card */
public class GraphQLGraphSearchResultDecorationDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchResultDecoration.class, new GraphQLGraphSearchResultDecorationDeserializer());
    }

    public GraphQLGraphSearchResultDecorationDeserializer() {
        a(GraphQLGraphSearchResultDecoration.class);
    }

    public Object m8281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchResultDecoration__JsonHelper.m8283a(jsonParser);
    }
}
