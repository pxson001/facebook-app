package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_ANNOTATION */
public class GraphQLSaleGroupsNearYouFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSaleGroupsNearYouFeedUnit.class, new GraphQLSaleGroupsNearYouFeedUnit$Deserializer());
    }

    public Object m21508a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSaleGroupsNearYouFeedUnitDeserializer.m5843a(jsonParser, (short) 513);
        Object graphQLSaleGroupsNearYouFeedUnit = new GraphQLSaleGroupsNearYouFeedUnit();
        ((BaseModel) graphQLSaleGroupsNearYouFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSaleGroupsNearYouFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLSaleGroupsNearYouFeedUnit).a();
        }
        return graphQLSaleGroupsNearYouFeedUnit;
    }
}
