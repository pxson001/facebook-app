package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_payment_options */
public class GraphQLFundraiserCharityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserCharity.class, new GraphQLFundraiserCharityDeserializer());
    }

    public GraphQLFundraiserCharityDeserializer() {
        a(GraphQLFundraiserCharity.class);
    }

    public Object m7673a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFundraiserCharity__JsonHelper.m7675a(jsonParser);
    }
}
