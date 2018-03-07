package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFundraiserCharityDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: groups_rhc_module */
public class GraphQLFundraiserCharity$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserCharity.class, new GraphQLFundraiserCharity$Deserializer());
    }

    public Object m7671a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFundraiserCharityDeserializer.m4976a(jsonParser, (short) 511);
        Object graphQLFundraiserCharity = new GraphQLFundraiserCharity();
        ((BaseModel) graphQLFundraiserCharity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFundraiserCharity instanceof Postprocessable) {
            return ((Postprocessable) graphQLFundraiserCharity).a();
        }
        return graphQLFundraiserCharity;
    }
}
