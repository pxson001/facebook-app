package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nux_description */
public class GraphQLPageLikersConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageLikersConnection.class, new GraphQLPageLikersConnectionDeserializer());
    }

    public GraphQLPageLikersConnectionDeserializer() {
        a(GraphQLPageLikersConnection.class);
    }

    public Object m9492a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageLikersConnection__JsonHelper.m9494a(jsonParser);
    }
}
