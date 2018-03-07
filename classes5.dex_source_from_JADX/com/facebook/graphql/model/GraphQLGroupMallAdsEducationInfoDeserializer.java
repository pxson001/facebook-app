package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: overall_star_rating */
public class GraphQLGroupMallAdsEducationInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMallAdsEducationInfo.class, new GraphQLGroupMallAdsEducationInfoDeserializer());
    }

    public GraphQLGroupMallAdsEducationInfoDeserializer() {
        a(GraphQLGroupMallAdsEducationInfo.class);
    }

    public Object m8434a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupMallAdsEducationInfo__JsonHelper.m8436a(jsonParser);
    }
}
