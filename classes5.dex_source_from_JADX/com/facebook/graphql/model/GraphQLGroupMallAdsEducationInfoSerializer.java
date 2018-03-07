package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_suggestion */
public class GraphQLGroupMallAdsEducationInfoSerializer extends JsonSerializer<GraphQLGroupMallAdsEducationInfo> {
    public final void m8435a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMallAdsEducationInfo__JsonHelper.m8437a(jsonGenerator, (GraphQLGroupMallAdsEducationInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMallAdsEducationInfo.class, new GraphQLGroupMallAdsEducationInfoSerializer());
    }
}
