package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WRAPPER_OBJECT */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedPeopleYouMayKnowFeedUnit.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnit$Deserializer());
    }

    public Object m20613a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPaginatedPeopleYouMayKnowFeedUnitDeserializer.m5564a(jsonParser, (short) 37);
        Object graphQLPaginatedPeopleYouMayKnowFeedUnit = new GraphQLPaginatedPeopleYouMayKnowFeedUnit();
        ((BaseModel) graphQLPaginatedPeopleYouMayKnowFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPaginatedPeopleYouMayKnowFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPaginatedPeopleYouMayKnowFeedUnit).a();
        }
        return graphQLPaginatedPeopleYouMayKnowFeedUnit;
    }
}
