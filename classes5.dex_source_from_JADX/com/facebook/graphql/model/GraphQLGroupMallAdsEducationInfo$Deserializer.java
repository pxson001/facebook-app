package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupMallAdsEducationInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: friend_to_subscriber */
public class GraphQLGroupMallAdsEducationInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupMallAdsEducationInfo.class, new GraphQLGroupMallAdsEducationInfo$Deserializer());
    }

    public Object m8432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupMallAdsEducationInfoDeserializer.m5161a(jsonParser, (short) 557);
        Object graphQLGroupMallAdsEducationInfo = new GraphQLGroupMallAdsEducationInfo();
        ((BaseModel) graphQLGroupMallAdsEducationInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupMallAdsEducationInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupMallAdsEducationInfo).a();
        }
        return graphQLGroupMallAdsEducationInfo;
    }
}
