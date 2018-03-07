package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_ADS_FOR_COMMERCIAL_BREAK */
public class GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSaleGroupsNearYouFeedUnitGroupsConnection.class, new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection$Deserializer());
    }

    public Object m21513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLSaleGroupsNearYouFeedUnitGroupsConnectionDeserializer.m5846a(jsonParser, (short) 514);
        Object graphQLSaleGroupsNearYouFeedUnitGroupsConnection = new GraphQLSaleGroupsNearYouFeedUnitGroupsConnection();
        ((BaseModel) graphQLSaleGroupsNearYouFeedUnitGroupsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLSaleGroupsNearYouFeedUnitGroupsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLSaleGroupsNearYouFeedUnitGroupsConnection).a();
        }
        return graphQLSaleGroupsNearYouFeedUnitGroupsConnection;
    }
}
