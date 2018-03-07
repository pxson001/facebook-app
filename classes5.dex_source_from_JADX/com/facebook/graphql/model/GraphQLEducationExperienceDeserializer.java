package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: period_flex */
public class GraphQLEducationExperienceDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEducationExperience.class, new GraphQLEducationExperienceDeserializer());
    }

    public GraphQLEducationExperienceDeserializer() {
        a(GraphQLEducationExperience.class);
    }

    public Object m6981a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEducationExperience__JsonHelper.m6983a(jsonParser);
    }
}
