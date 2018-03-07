package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: frame_id */
public class GraphQLGroupsYouShouldCreateFeedUnitItemSerializer extends JsonSerializer<GraphQLGroupsYouShouldCreateFeedUnitItem> {
    public final void m8538a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper.m8540a(jsonGenerator, (GraphQLGroupsYouShouldCreateFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupsYouShouldCreateFeedUnitItem.class, new GraphQLGroupsYouShouldCreateFeedUnitItemSerializer());
    }
}
