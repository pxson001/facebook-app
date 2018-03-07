package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_invitation */
public class GraphQLGroupMemberWelcomeCallToActionInfoSerializer extends JsonSerializer<GraphQLGroupMemberWelcomeCallToActionInfo> {
    public final void m8453a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMemberWelcomeCallToActionInfo graphQLGroupMemberWelcomeCallToActionInfo = (GraphQLGroupMemberWelcomeCallToActionInfo) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGroupMemberWelcomeCallToActionInfo.m8451a() != null) {
            jsonGenerator.a("group_id", graphQLGroupMemberWelcomeCallToActionInfo.m8451a());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMemberWelcomeCallToActionInfo.class, new GraphQLGroupMemberWelcomeCallToActionInfoSerializer());
    }
}
