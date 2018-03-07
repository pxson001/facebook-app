package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pinterest.com */
public class GraphQLAttachmentPropertyDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAttachmentProperty.class, new GraphQLAttachmentPropertyDeserializer());
    }

    public GraphQLAttachmentPropertyDeserializer() {
        a(GraphQLAttachmentProperty.class);
    }

    public Object m6607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAttachmentProperty__JsonHelper.m6609a(jsonParser);
    }
}
