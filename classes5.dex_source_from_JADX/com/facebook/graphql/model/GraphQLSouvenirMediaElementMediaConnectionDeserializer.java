package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: movie_list_style */
public class GraphQLSouvenirMediaElementMediaConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaElementMediaConnection.class, new GraphQLSouvenirMediaElementMediaConnectionDeserializer());
    }

    public GraphQLSouvenirMediaElementMediaConnectionDeserializer() {
        a(GraphQLSouvenirMediaElementMediaConnection.class);
    }

    public Object m21734a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSouvenirMediaElementMediaConnection__JsonHelper.m21736a(jsonParser);
    }
}
