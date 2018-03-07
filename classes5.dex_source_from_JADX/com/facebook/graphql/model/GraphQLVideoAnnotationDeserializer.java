package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_entry_messaging_tab */
public class GraphQLVideoAnnotationDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoAnnotation.class, new GraphQLVideoAnnotationDeserializer());
    }

    public GraphQLVideoAnnotationDeserializer() {
        a(GraphQLVideoAnnotation.class);
    }

    public Object m22427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLVideoAnnotation__JsonHelper.m22429a(jsonParser);
    }
}
