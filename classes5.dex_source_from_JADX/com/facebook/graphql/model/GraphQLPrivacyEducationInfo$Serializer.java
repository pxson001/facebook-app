package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyEducationInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewParentCompat */
public final class GraphQLPrivacyEducationInfo$Serializer extends JsonSerializer<GraphQLPrivacyEducationInfo> {
    public final void m20984a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo = (GraphQLPrivacyEducationInfo) obj;
        GraphQLPrivacyEducationInfoDeserializer.m5690a(graphQLPrivacyEducationInfo.w_(), graphQLPrivacyEducationInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyEducationInfo.class, new GraphQLPrivacyEducationInfo$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyEducationInfo.class, new GraphQLPrivacyEducationInfo$Serializer());
    }
}
