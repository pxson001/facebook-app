package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_TEAM */
public class C1159x998cd9f2 extends JsonSerializer<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection> {
    public final void m20622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        C1160xc690a2f6.m20624a(jsonGenerator, (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.class, new C1159x998cd9f2());
    }
}
