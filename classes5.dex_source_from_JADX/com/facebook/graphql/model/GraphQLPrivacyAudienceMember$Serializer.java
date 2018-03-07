package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyAudienceMemberDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewUtils */
public final class GraphQLPrivacyAudienceMember$Serializer extends JsonSerializer<GraphQLPrivacyAudienceMember> {
    public final void m20978a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember = (GraphQLPrivacyAudienceMember) obj;
        GraphQLPrivacyAudienceMemberDeserializer.a(graphQLPrivacyAudienceMember.w_(), graphQLPrivacyAudienceMember.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyAudienceMember.class, new GraphQLPrivacyAudienceMember$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyAudienceMember.class, new GraphQLPrivacyAudienceMember$Serializer());
    }
}
