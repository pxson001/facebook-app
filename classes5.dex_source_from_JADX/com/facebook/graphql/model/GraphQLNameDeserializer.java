package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_netego_movie_release_date */
public class GraphQLNameDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLName.class, new GraphQLNameDeserializer());
    }

    public GraphQLNameDeserializer() {
        a(GraphQLName.class);
    }

    public Object m9150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLName__JsonHelper.a(jsonParser);
    }
}
