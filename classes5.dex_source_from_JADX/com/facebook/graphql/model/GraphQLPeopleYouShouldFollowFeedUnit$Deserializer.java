package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPeopleYouShouldFollowFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WIZARD_SEARCH */
public class GraphQLPeopleYouShouldFollowFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouShouldFollowFeedUnit.class, new GraphQLPeopleYouShouldFollowFeedUnit$Deserializer());
    }

    public Object m20692a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPeopleYouShouldFollowFeedUnitDeserializer.m5593a(jsonParser, (short) 38);
        Object graphQLPeopleYouShouldFollowFeedUnit = new GraphQLPeopleYouShouldFollowFeedUnit();
        ((BaseModel) graphQLPeopleYouShouldFollowFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPeopleYouShouldFollowFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPeopleYouShouldFollowFeedUnit).a();
        }
        return graphQLPeopleYouShouldFollowFeedUnit;
    }
}
