package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyEducationInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ViewParentCompat */
public class GraphQLPrivacyEducationInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyEducationInfo.class, new GraphQLPrivacyEducationInfo$Deserializer());
    }

    public Object m20983a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPrivacyEducationInfoDeserializer.m5689a(jsonParser, (short) 144);
        Object graphQLPrivacyEducationInfo = new GraphQLPrivacyEducationInfo();
        ((BaseModel) graphQLPrivacyEducationInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPrivacyEducationInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPrivacyEducationInfo).a();
        }
        return graphQLPrivacyEducationInfo;
    }
}
