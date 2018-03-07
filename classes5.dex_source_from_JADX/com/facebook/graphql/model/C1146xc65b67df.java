package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.C0243x81539b2b;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WRITE_INVALID_ENTRY */
public class C1146xc65b67df extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection.class, new C1146xc65b67df());
    }

    public Object m20590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = C0243x81539b2b.m5558a(jsonParser, (short) 348);
        Object graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection = new GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection();
        ((BaseModel) graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection).a();
        }
        return graphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection;
    }
}
