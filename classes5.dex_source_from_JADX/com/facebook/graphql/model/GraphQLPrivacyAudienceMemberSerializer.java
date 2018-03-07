package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewStub must have a non-null ViewGroup viewParent */
public class GraphQLPrivacyAudienceMemberSerializer extends JsonSerializer<GraphQLPrivacyAudienceMember> {
    public final void m20980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyAudienceMember__JsonHelper.m20982a(jsonGenerator, (GraphQLPrivacyAudienceMember) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyAudienceMember.class, new GraphQLPrivacyAudienceMemberSerializer());
    }
}
