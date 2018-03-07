package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayInviteFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WORK_MANAGER_GROUP */
public class GraphQLPeopleYouMayInviteFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayInviteFeedUnit.class, new GraphQLPeopleYouMayInviteFeedUnit$Deserializer());
    }

    public Object m20644a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPeopleYouMayInviteFeedUnitDeserializer.m5582a(jsonParser, (short) 36);
        Object graphQLPeopleYouMayInviteFeedUnit = new GraphQLPeopleYouMayInviteFeedUnit();
        ((BaseModel) graphQLPeopleYouMayInviteFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPeopleYouMayInviteFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPeopleYouMayInviteFeedUnit).a();
        }
        return graphQLPeopleYouMayInviteFeedUnit;
    }
}
