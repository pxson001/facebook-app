package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_photos_by_friends_at_place_page_surface */
public class GraphQLFullIndexEducationInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFullIndexEducationInfo.class, new GraphQLFullIndexEducationInfoDeserializer());
    }

    public GraphQLFullIndexEducationInfoDeserializer() {
        a(GraphQLFullIndexEducationInfo.class);
    }

    public Object m7660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFullIndexEducationInfo__JsonHelper.m7662a(jsonParser);
    }
}
