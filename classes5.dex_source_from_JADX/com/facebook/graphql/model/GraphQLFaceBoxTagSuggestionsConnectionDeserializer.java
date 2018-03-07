package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pagelike_deleter_for_deactivated_users */
public class GraphQLFaceBoxTagSuggestionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFaceBoxTagSuggestionsConnection.class, new GraphQLFaceBoxTagSuggestionsConnectionDeserializer());
    }

    public GraphQLFaceBoxTagSuggestionsConnectionDeserializer() {
        a(GraphQLFaceBoxTagSuggestionsConnection.class);
    }

    public Object m7438a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFaceBoxTagSuggestionsConnection__JsonHelper.m7440a(jsonParser);
    }
}
