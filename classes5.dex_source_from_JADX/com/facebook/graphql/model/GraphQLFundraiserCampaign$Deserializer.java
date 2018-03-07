package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFundraiserCampaignDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: guest_status */
public class GraphQLFundraiserCampaign$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserCampaign.class, new GraphQLFundraiserCampaign$Deserializer());
    }

    public Object m7664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFundraiserCampaignDeserializer.m4973a(jsonParser, (short) 98);
        Object graphQLFundraiserCampaign = new GraphQLFundraiserCampaign();
        ((BaseModel) graphQLFundraiserCampaign).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFundraiserCampaign instanceof Postprocessable) {
            return ((Postprocessable) graphQLFundraiserCampaign).a();
        }
        return graphQLFundraiserCampaign;
    }
}
