package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGroupsYouShouldCreateFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: frames_cta */
public class GraphQLGroupsYouShouldCreateFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldCreateFeedUnit.class, new GraphQLGroupsYouShouldCreateFeedUnit$Deserializer());
    }

    public Object m8521a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGroupsYouShouldCreateFeedUnitDeserializer.m5195a(jsonParser, (short) 113);
        Object graphQLGroupsYouShouldCreateFeedUnit = new GraphQLGroupsYouShouldCreateFeedUnit();
        ((BaseModel) graphQLGroupsYouShouldCreateFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGroupsYouShouldCreateFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLGroupsYouShouldCreateFeedUnit).a();
        }
        return graphQLGroupsYouShouldCreateFeedUnit;
    }
}
