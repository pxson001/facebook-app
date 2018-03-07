package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPeopleYouMayKnowFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WORKPLACE_OFFICE */
public class GraphQLPeopleYouMayKnowFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayKnowFeedUnit.class, new GraphQLPeopleYouMayKnowFeedUnit$Deserializer());
    }

    public Object m20673a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPeopleYouMayKnowFeedUnitDeserializer.m5585a(jsonParser, (short) 120);
        Object graphQLPeopleYouMayKnowFeedUnit = new GraphQLPeopleYouMayKnowFeedUnit();
        ((BaseModel) graphQLPeopleYouMayKnowFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPeopleYouMayKnowFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLPeopleYouMayKnowFeedUnit).a();
        }
        return graphQLPeopleYouMayKnowFeedUnit;
    }
}
