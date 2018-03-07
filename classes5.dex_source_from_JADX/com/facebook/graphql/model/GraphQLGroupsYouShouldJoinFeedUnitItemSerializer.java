package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: formatted_total */
public class GraphQLGroupsYouShouldJoinFeedUnitItemSerializer extends JsonSerializer<GraphQLGroupsYouShouldJoinFeedUnitItem> {
    public final void m8555a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper.m8557a(jsonGenerator, (GraphQLGroupsYouShouldJoinFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupsYouShouldJoinFeedUnitItem.class, new GraphQLGroupsYouShouldJoinFeedUnitItemSerializer());
    }
}
