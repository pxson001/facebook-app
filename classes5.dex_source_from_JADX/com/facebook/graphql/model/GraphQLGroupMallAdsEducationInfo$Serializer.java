package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupMallAdsEducationInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_to_subscriber */
public final class GraphQLGroupMallAdsEducationInfo$Serializer extends JsonSerializer<GraphQLGroupMallAdsEducationInfo> {
    public final void m8433a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMallAdsEducationInfo graphQLGroupMallAdsEducationInfo = (GraphQLGroupMallAdsEducationInfo) obj;
        GraphQLGroupMallAdsEducationInfoDeserializer.m5162a(graphQLGroupMallAdsEducationInfo.w_(), graphQLGroupMallAdsEducationInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMallAdsEducationInfo.class, new GraphQLGroupMallAdsEducationInfo$Serializer());
        FbSerializerProvider.a(GraphQLGroupMallAdsEducationInfo.class, new GraphQLGroupMallAdsEducationInfo$Serializer());
    }
}
