package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupsYouShouldJoinFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fqlMultiQueryMethod */
public class GraphQLGroupsYouShouldJoinFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldJoinFeedUnit.class, new GraphQLGroupsYouShouldJoinFeedUnit$Deserializer());
    }

    public Object m8543a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupsYouShouldJoinFeedUnitDeserializer.m5203a(jsonParser, (short) 114);
        Object graphQLGroupsYouShouldJoinFeedUnit = new GraphQLGroupsYouShouldJoinFeedUnit();
        ((BaseModel) graphQLGroupsYouShouldJoinFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupsYouShouldJoinFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupsYouShouldJoinFeedUnit).a();
        }
        return graphQLGroupsYouShouldJoinFeedUnit;
    }
}
