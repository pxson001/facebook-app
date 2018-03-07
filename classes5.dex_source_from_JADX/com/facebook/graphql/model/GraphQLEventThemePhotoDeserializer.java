package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: passenger_name_label */
public class GraphQLEventThemePhotoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventThemePhoto.class, new GraphQLEventThemePhotoDeserializer());
    }

    public GraphQLEventThemePhotoDeserializer() {
        a(GraphQLEventThemePhoto.class);
    }

    public Object m7278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventThemePhoto__JsonHelper.m7280a(jsonParser);
    }
}
