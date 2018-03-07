package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nm */
public class GraphQLPhotoTagsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPhotoTagsConnection.class, new GraphQLPhotoTagsConnectionDeserializer());
    }

    public GraphQLPhotoTagsConnectionDeserializer() {
        a(GraphQLPhotoTagsConnection.class);
    }

    public Object m20749a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPhotoTagsConnection__JsonHelper.m20751a(jsonParser);
    }
}
