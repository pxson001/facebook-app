package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_remix_source */
public class GraphQLCommentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLComment.class, new GraphQLCommentDeserializer());
    }

    public GraphQLCommentDeserializer() {
        a(GraphQLComment.class);
    }

    public Object m6804a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLComment__JsonHelper.a(jsonParser);
    }
}
