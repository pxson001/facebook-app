package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: moments_of_interest */
public class GraphQLSportsDataMatchToFactsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSportsDataMatchToFactsConnection.class, new GraphQLSportsDataMatchToFactsConnectionDeserializer());
    }

    public GraphQLSportsDataMatchToFactsConnectionDeserializer() {
        a(GraphQLSportsDataMatchToFactsConnection.class);
    }

    public Object m21795a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSportsDataMatchToFactsConnection__JsonHelper.m21797a(jsonParser);
    }
}
