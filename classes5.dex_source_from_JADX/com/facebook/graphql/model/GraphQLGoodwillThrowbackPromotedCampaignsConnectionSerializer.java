package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getSystemTime */
public class GraphQLGoodwillThrowbackPromotedCampaignsConnectionSerializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotedCampaignsConnection> {
    public final void m8076a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackPromotedCampaignsConnection__JsonHelper.m8078a(jsonGenerator, (GraphQLGoodwillThrowbackPromotedCampaignsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotedCampaignsConnection.class, new GraphQLGoodwillThrowbackPromotedCampaignsConnectionSerializer());
    }
}
