package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: menu_item_photo_suggestion_netego */
public class GraphQLWorkExperienceDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWorkExperience.class, new GraphQLWorkExperienceDeserializer());
    }

    public GraphQLWorkExperienceDeserializer() {
        a(GraphQLWorkExperience.class);
    }

    public Object m22531a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLWorkExperience__JsonHelper.m22533a(jsonParser);
    }
}
