package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photos_and_albums */
public class GraphQLClashUnitDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLClashUnit.class, new GraphQLClashUnitDeserializer());
    }

    public GraphQLClashUnitDeserializer() {
        a(GraphQLClashUnit.class);
    }

    public Object m6770a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLClashUnit__JsonHelper.m6772a(jsonParser);
    }
}
