package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.C0245xd2646133;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_TOP_GROUPS_COMPOSER */
public final class C1157xc8e7f496 extends JsonSerializer<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection> {
    public final void m20620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection = (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection) obj;
        C0245xd2646133.m5568a(graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.w_(), graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.class, new C1157xc8e7f496());
        FbSerializerProvider.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.class, new C1157xc8e7f496());
    }
}
