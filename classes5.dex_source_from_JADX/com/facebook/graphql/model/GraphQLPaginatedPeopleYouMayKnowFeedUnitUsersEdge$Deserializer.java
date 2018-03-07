package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WORK_SOCIAL */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge$Deserializer());
    }

    public Object m20625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer.m5570a(jsonParser, (short) 336);
        Object graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge = new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge();
        ((BaseModel) graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge).a();
        }
        return graphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge;
    }
}
