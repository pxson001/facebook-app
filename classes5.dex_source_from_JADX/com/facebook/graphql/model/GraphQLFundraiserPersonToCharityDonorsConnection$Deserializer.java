package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: group_owner_authored_stories */
public class GraphQLFundraiserPersonToCharityDonorsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserPersonToCharityDonorsConnection.class, new GraphQLFundraiserPersonToCharityDonorsConnection$Deserializer());
    }

    public Object m7725a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFundraiserPersonToCharityDonorsConnectionDeserializer.m4985a(jsonParser, (short) 524);
        Object graphQLFundraiserPersonToCharityDonorsConnection = new GraphQLFundraiserPersonToCharityDonorsConnection();
        ((BaseModel) graphQLFundraiserPersonToCharityDonorsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFundraiserPersonToCharityDonorsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFundraiserPersonToCharityDonorsConnection).a();
        }
        return graphQLFundraiserPersonToCharityDonorsConnection;
    }
}
