package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msgs */
public class GraphQLSouvenirMediaElementDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaElement.class, new GraphQLSouvenirMediaElementDeserializer());
    }

    public GraphQLSouvenirMediaElementDeserializer() {
        a(GraphQLSouvenirMediaElement.class);
    }

    public Object m21728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSouvenirMediaElement__JsonHelper.m21748a(jsonParser);
    }
}
