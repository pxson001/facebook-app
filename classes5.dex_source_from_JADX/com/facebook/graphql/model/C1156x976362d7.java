package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.C0245xd2646133;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WORK_TOP_GROUPS_COMPOSER */
public class C1156x976362d7 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection.class, new C1156x976362d7());
    }

    public Object m20619a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = C0245xd2646133.m5567a(jsonParser, (short) 335);
        Object graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection = new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection();
        ((BaseModel) graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection).a();
        }
        return graphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
    }
}
