package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: onFailure must not return null */
public class GraphQLMegaphoneActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMegaphoneAction.class, new GraphQLMegaphoneActionDeserializer());
    }

    public GraphQLMegaphoneActionDeserializer() {
        a(GraphQLMegaphoneAction.class);
    }

    public Object m9099a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMegaphoneAction__JsonHelper.m9101a(jsonParser);
    }
}
