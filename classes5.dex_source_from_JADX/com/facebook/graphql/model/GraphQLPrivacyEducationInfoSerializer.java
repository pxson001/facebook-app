package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewParent  */
public class GraphQLPrivacyEducationInfoSerializer extends JsonSerializer<GraphQLPrivacyEducationInfo> {
    public final void m20986a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyEducationInfo__JsonHelper.m20988a(jsonGenerator, (GraphQLPrivacyEducationInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyEducationInfo.class, new GraphQLPrivacyEducationInfoSerializer());
    }
}
