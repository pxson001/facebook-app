package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: override_details */
public class GraphQLGroupCreationSuggestionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupCreationSuggestion.class, new GraphQLGroupCreationSuggestionDeserializer());
    }

    public GraphQLGroupCreationSuggestionDeserializer() {
        a(GraphQLGroupCreationSuggestion.class);
    }

    public Object m8427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupCreationSuggestion__JsonHelper.m8429a(jsonParser);
    }
}
