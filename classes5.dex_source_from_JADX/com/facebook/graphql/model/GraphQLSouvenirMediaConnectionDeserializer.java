package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_checkin_prompt */
public class GraphQLSouvenirMediaConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaConnection.class, new GraphQLSouvenirMediaConnectionDeserializer());
    }

    public GraphQLSouvenirMediaConnectionDeserializer() {
        a(GraphQLSouvenirMediaConnection.class);
    }

    public Object m21704a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSouvenirMediaConnection__JsonHelper.m21706a(jsonParser);
    }
}
