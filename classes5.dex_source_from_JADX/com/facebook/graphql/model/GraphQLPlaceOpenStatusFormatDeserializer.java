package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_account_pymk_generation */
public class GraphQLPlaceOpenStatusFormatDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceOpenStatusFormat.class, new GraphQLPlaceOpenStatusFormatDeserializer());
    }

    public GraphQLPlaceOpenStatusFormatDeserializer() {
        a(GraphQLPlaceOpenStatusFormat.class);
    }

    public Object m20884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceOpenStatusFormat__JsonHelper.m20886a(jsonParser);
    }
}
