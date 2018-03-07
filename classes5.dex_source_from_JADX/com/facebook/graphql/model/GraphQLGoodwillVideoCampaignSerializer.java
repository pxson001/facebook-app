package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getMobileTcpBytesReceived */
public class GraphQLGoodwillVideoCampaignSerializer extends JsonSerializer<GraphQLGoodwillVideoCampaign> {
    public final void m8134a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillVideoCampaign__JsonHelper.m8136a(jsonGenerator, (GraphQLGoodwillVideoCampaign) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillVideoCampaign.class, new GraphQLGoodwillVideoCampaignSerializer());
    }
}
