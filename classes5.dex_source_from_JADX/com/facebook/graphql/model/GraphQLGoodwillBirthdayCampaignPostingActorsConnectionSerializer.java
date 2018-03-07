package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_browse_new */
public class GraphQLGoodwillBirthdayCampaignPostingActorsConnectionSerializer extends JsonSerializer<GraphQLGoodwillBirthdayCampaignPostingActorsConnection> {
    public final void m7815a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        C0344xcce9d9af.m7817a(jsonGenerator, (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class, new GraphQLGoodwillBirthdayCampaignPostingActorsConnectionSerializer());
    }
}
