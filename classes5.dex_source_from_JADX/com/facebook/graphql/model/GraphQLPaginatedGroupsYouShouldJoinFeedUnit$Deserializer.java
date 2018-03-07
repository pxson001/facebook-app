package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WRITE_ON_TIMELINE */
public class GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit.class, new GraphQLPaginatedGroupsYouShouldJoinFeedUnit$Deserializer());
    }

    public Object m20585a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPaginatedGroupsYouShouldJoinFeedUnitDeserializer.m5555a(jsonParser, (short) 35);
        Object graphQLPaginatedGroupsYouShouldJoinFeedUnit = new GraphQLPaginatedGroupsYouShouldJoinFeedUnit();
        ((BaseModel) graphQLPaginatedGroupsYouShouldJoinFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPaginatedGroupsYouShouldJoinFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPaginatedGroupsYouShouldJoinFeedUnit).a();
        }
        return graphQLPaginatedGroupsYouShouldJoinFeedUnit;
    }
}
