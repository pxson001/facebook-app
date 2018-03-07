package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_encodings */
public class GraphQLConfigurationDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLConfiguration.class, new GraphQLConfigurationDeserializer());
    }

    public GraphQLConfigurationDeserializer() {
        a(GraphQLConfiguration.class);
    }

    public Object m6857a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLConfiguration__JsonHelper.m6859a(jsonParser);
    }
}
