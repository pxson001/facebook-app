package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: onAccountValidationComplete can be called only once per call to validateAccount */
public class GraphQLMegaphoneDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMegaphone.class, new GraphQLMegaphoneDeserializer());
    }

    public GraphQLMegaphoneDeserializer() {
        a(GraphQLMegaphone.class);
    }

    public Object m9103a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLMegaphone__JsonHelper.m9105a(jsonParser);
    }
}
